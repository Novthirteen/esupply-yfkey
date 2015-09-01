package com.yfkey.service.impl;

import org.apache.commons.lang.StringUtils;
import com.yfkey.dao.UserDao;
import com.yfkey.exception.UserExistsException;
import com.yfkey.model.User;
import com.yfkey.service.MailEngine;
import com.yfkey.service.UserManager;
import com.yfkey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("userManager")
@WebService(serviceName = "UserService", endpointInterface = "com.yfkey.service.UserService")
public class UserManagerImpl extends GenericManagerImpl<User, Long>implements UserManager, UserService {
	private PasswordEncoder passwordEncoder;
	private UserDao userDao;

	private MailEngine mailEngine;
	private SimpleMailMessage message;

	private String passwordRecoveryTemplate = "passwordRecovery.vm";
	private String passwordUpdatedTemplate = "passwordUpdated.vm";

	@Autowired
	@Qualifier("passwordEncoder")
	public void setPasswordEncoder(final PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Autowired
	public void setUserDao(final UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired(required = false)
	public void setMailEngine(final MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}

	@Autowired(required = false)
	public void setMailMessage(final SimpleMailMessage message) {
		this.message = message;
	}

	/**
	 * Velocity template name to send users a password recovery mail (default
	 * passwordRecovery.vm).
	 *
	 * @param passwordRecoveryTemplate
	 *            the Velocity template to use (relative to classpath)
	 * @see com.yfkey.service.MailEngine#sendMessage(org.springframework.mail.SimpleMailMessage,
	 *      String, java.util.Map)
	 */
	public void setPasswordRecoveryTemplate(final String passwordRecoveryTemplate) {
		this.passwordRecoveryTemplate = passwordRecoveryTemplate;
	}

	/**
	 * Velocity template name to inform users their password was updated
	 * (default passwordUpdated.vm).
	 *
	 * @param passwordUpdatedTemplate
	 *            the Velocity template to use (relative to classpath)
	 * @see com.yfkey.service.MailEngine#sendMessage(org.springframework.mail.SimpleMailMessage,
	 *      String, java.util.Map)
	 */
	public void setPasswordUpdatedTemplate(final String passwordUpdatedTemplate) {
		this.passwordUpdatedTemplate = passwordUpdatedTemplate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUser(final String userName) {
		return userDao.get(userName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getUsers() {
		return userDao.getAllDistinct();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User saveUser(final User user) throws UserExistsException {

		if (user.getVersion() == 0) {
			// if new user, lowercase userId
			user.setUsername(user.getUsername().toLowerCase());
		}

		// Get and prepare password management-related artifacts
		boolean passwordChanged = false;
		if (passwordEncoder != null) {
			// Check whether we have to encrypt (or re-encrypt) the password
			if (user.getVersion() == 0) {
				// New user, always encrypt
				passwordChanged = true;
			} else {
				// Existing user, check password in DB
				final String currentPassword = userDao.getUserPassword(user.getUsername());
				if (currentPassword == null) {
					passwordChanged = true;
				} else {
					if (!currentPassword.equals(user.getPassword())) {
						passwordChanged = true;
					}
				}
			}

			// If password was changed (or new user), encrypt it
			if (passwordChanged) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
			}
		} else {
			log.warn("PasswordEncoder not set, skipping password encryption...");
		}

		try {
			userDao.save(user);
			return user;
		} catch (final Exception e) {
			e.printStackTrace();
			log.warn(e.getMessage());
			throw new UserExistsException("User '" + user.getUsername() + "' already exists!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeUser(final User user) {
		log.debug("removing user: " + user);
		userDao.remove(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeUser(final String userName) {
		log.debug("removing user: " + userName);
		userDao.remove(userName);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param username
	 *            the login name of the human
	 * @return User the populated user object
	 * @throws org.springframework.security.core.userdetails.
	 *             UsernameNotFoundException
	 *             thrown when username not found
	 */
	@Override
	public User getUserByUsername(final String username) throws UsernameNotFoundException {
		return (User) userDao.loadUserByUsername(username);
	}

	private void sendUserEmail(final User user, final String template, final String url, final String subject) {
		message.setTo(user.getFullName() + "<" + user.getEmail() + ">");
		message.setSubject(subject);

		final Map<String, Serializable> model = new HashMap<String, Serializable>();
		model.put("user", user);
		model.put("applicationURL", url);

		mailEngine.sendMessage(message, template, model);
	}
}
