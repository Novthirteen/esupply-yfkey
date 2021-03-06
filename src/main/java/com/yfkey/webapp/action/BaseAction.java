package com.yfkey.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.progress.open4gl.ProDataObject;
import com.progress.open4gl.javaproxy.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import com.yfkey.Constants;
import com.yfkey.exception.QadException;
import com.yfkey.exception.SupplierAuthorityException;
import com.yfkey.exception.UserPasswordNotValidException;
import com.yfkey.model.User;
import com.yfkey.model.UserPasswordLog;
import com.yfkey.service.MailEngine;
import com.yfkey.service.RoleManager;
import com.yfkey.service.UserManager;
import com.yfkey.util.NativeSqlRepository;

import org.springframework.mail.SimpleMailMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.yfkey.qad.QADConfg;
import com.yfkey.qad.YFKSSSCP;
import com.yfkey.model.LabelValue;
import com.yfkey.model.PermissionType;
import com.yfkey.service.UniversalManager;

/**
 * Implementation of <strong>ActionSupport</strong> that contains convenience
 * methods for subclasses. For example, getting the current user and saving
 * messages/errors. This class is intended to be a base class for all Action
 * classes.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 3525445612504421307L;

	/**
	 * Constant for cancel result String
	 */
	public static final String CANCEL = "cancel";

	/**
	 * Transient log to prevent session synchronization issues - children can
	 * use instance for logging.
	 */
	protected final transient Log log = LogFactory.getLog(getClass());

	/**
	 * The UserManager
	 */
	protected UserManager userManager;

	/**
	 * The UniversalManager
	 */
	protected UniversalManager universalManager;

	/**
	 * The RoleManager
	 */
	protected RoleManager roleManager;

	/**
	 * Indicator if the user clicked cancel
	 */
	protected String cancel;

	/**
	 * Indicator for the page the user came from.
	 */
	protected String from;

	/**
	 * Set to "delete" when a "delete" request parameter is passed in
	 */
	protected String delete;

	/**
	 * Set to "save" when a "save" request parameter is passed in
	 */
	protected String save;

	/**
	 * MailEngine for sending e-mail
	 */
	protected MailEngine mailEngine;

	/**
	 * A message pre-populated with default data
	 */
	protected SimpleMailMessage mailMessage;

	/**
	 * Velocity template to use for e-mailing
	 */
	protected String templateName;

	/**
	 * Simple method that returns "cancel" result
	 *
	 * @return "cancel"
	 */

	protected static YFKSSSCP yfkssScp;
	private static String yfkssScpLock = "yfkssScpLock";

	public String getCbValue() {
		return UUID.randomUUID().toString();
	}

	public String cancel() {
		return CANCEL;
	}

	/**
	 * Save the message in the session, appending if messages already exist
	 *
	 * @param msg
	 *            the message to put in the session
	 */
	@SuppressWarnings("unchecked")
	protected void saveMessage(String msg) {
		List messages = (List) getRequest().getSession().getAttribute("messages");
		if (messages == null) {
			messages = new ArrayList();
		}
		messages.add(msg);
		getRequest().getSession().setAttribute("messages", messages);
	}

	/**
	 * Convenience method to get the Configuration HashMap from the servlet
	 * context.
	 *
	 * @return the user's populated form from the session
	 */
	protected Map getConfiguration() {
		Map config = (HashMap) getSession().getServletContext().getAttribute(Constants.CONFIG);
		// so unit tests don't puke when nothing's been set
		if (config == null) {
			return new HashMap();
		}
		return config;
	}

	/**
	 * Convenience method to get the request
	 *
	 * @return current request
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * Convenience method to get the response
	 *
	 * @return current response
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * Convenience method to get the session. This will create a session if one
	 * doesn't exist.
	 *
	 * @return the session from the request (request.getSession()).
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * Convenience method to send e-mail to users
	 *
	 * @param user
	 *            the user to send to
	 * @param msg
	 *            the message to send
	 * @param url
	 *            the URL to the application (or where ever you'd like to send
	 *            them)
	 */
	protected void sendUserMessage(User user, String msg, String url) {
		if (log.isDebugEnabled()) {
			log.debug("sending e-mail to user [" + user.getEmail() + "]...");
		}

		mailMessage.setTo(user.getFullName() + "<" + user.getEmail() + ">");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", user);
		// TODO: figure out how to get bundle specified in struts.xml
		// model.put("bundle", getTexts());
		model.put("message", msg);
		model.put("applicationURL", url);
		mailEngine.sendMessage(mailMessage, templateName, model);
	}

	public void setMailEngine(MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}

	public void setMailMessage(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * Convenience method for setting a "from" parameter to indicate the
	 * previous page.
	 *
	 * @param from
	 *            indicator for the originating page
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public UniversalManager getUniversalManager() {
		return universalManager;
	}

	public void setUniversalManager(UniversalManager universalManager) {
		this.universalManager = universalManager;
	}

	protected void saveErrorForStaleObjectStateException() {
		addActionError(getText("errors.staleObjectStateException"));
	}

	protected void saveErrorForUnexpectException(Exception ex) {
		log.error("Unexpect exception occur.", ex);
		List<Object> args = new ArrayList<Object>();
		args.add(ex.getMessage());
		addActionError(getText("errors.unexpectError", args));
	}

	protected static boolean ConnectQAD() {
		try {

			if (yfkssScp == null) {
				synchronized (yfkssScpLock) {
					if (yfkssScp == null) {
						yfkssScp = new YFKSSSCP(new Connection(QADConfg.getQadServerUrl(), "", "", null));
					}
				}
			}
			if (yfkssScp != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	protected List<String> getSupplierCodeList(String supplierCode) {

		String userCode = this.getRequest().getRemoteUser();
		String domain = this.getCurrentDomain();
		List<String> supplierCodeList = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		List<String> permissionCodeList = universalManager.findByNativeSql(
				"select permission_code from (" +NativeSqlRepository.SELECT_PERMISSION_VIEW_STATEMENT +") p",
				new Object[] {userCode,  PermissionType.S.toString(), domain + "%",userCode,  PermissionType.S.toString(), domain + "%" });

		if (permissionCodeList != null && permissionCodeList.size() > 0) {
			for (String code : permissionCodeList) {

				String[] codeArray = code.split("_");
				supplierCodeList.add(codeArray[1].toUpperCase());
			}
		}
		if (supplierCode != null && !supplierCode.trim().equals("")) {

			if (supplierCodeList.contains(supplierCode.toUpperCase())) {
				supplierCodeList = new ArrayList<String>();
				supplierCodeList.add(supplierCode.toUpperCase());
			} else {
				supplierCodeList = new ArrayList<String>();
			}
		}
		return supplierCodeList;
	}

	protected String getCurrentDomain() {
		return this.getRequest().getSession().getAttribute(Constants.SELECTED_USER_PLANT).toString();
	}

	protected void checkSupplier(String supplierCode) throws SupplierAuthorityException {
		String userCode = this.getRequest().getRemoteUser();
		String domain = this.getCurrentDomain();
		List<String> supplierCodeList = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		List<String> permissionCodeList = universalManager.findByNativeSql(
				"select permission_code from ("+NativeSqlRepository.SELECT_PERMISSION_VIEW_STATEMENT +") p",
				new Object[] { userCode,PermissionType.S.toString(),  domain + "%",userCode,PermissionType.S.toString(),  domain + "%" });

		if (permissionCodeList != null && permissionCodeList.size() > 0) {
			for (String code : permissionCodeList) {

				String[] codeArray = code.split("_");
				supplierCodeList.add(codeArray[1].toUpperCase());
			}
		}
		if (supplierCode != null && !supplierCode.trim().equals("")) {

			if (!supplierCodeList.contains(supplierCode.toUpperCase())) {
				List<Object> args = new ArrayList<Object>();
				args.add(supplierCode);
				throw new SupplierAuthorityException(getText("supplier.no.authority", args));
			}
		}

	}

	public String getQadErrorMessage(List<ProDataObject> errorOutDataList) {
		String errorMessage = "";
		if (errorOutDataList != null && errorOutDataList.size() > 0) {
			for (ProDataObject qadError : errorOutDataList) {
				if (qadError.getBigDecimal("tt_erro_errid").equals(new BigDecimal(2))
						&& getRequest().getLocale().toString().equals("zh_CN")) {
					errorMessage = (String) qadError.get("tt_erro_msg");
					break;
				} else if (qadError.getBigDecimal("tt_erro_errid").equals(new BigDecimal(1))
						&& getRequest().getLocale().toString().equals("en")) {
					errorMessage = (String) qadError.get("tt_erro_msg");
					break;
				}
			}
		}
		return errorMessage;
	}
}
