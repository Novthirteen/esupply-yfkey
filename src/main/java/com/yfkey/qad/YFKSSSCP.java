/*
**
**    Created by PROGRESS ProxyGen (Progress Version 11.4) Tue Sep 08 14:18:59 CST 2015
**
*/

package com.yfkey.qad;

import java.io.IOException;

import com.progress.message.jcMsg;
import com.progress.open4gl.ConnectException;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ProDataGraph;
import com.progress.open4gl.ProDataGraphHolder;
import com.progress.open4gl.ProSQLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.RunTimeProperties;
import com.progress.open4gl.SDOFactory;
import com.progress.open4gl.SDOInterface;
import com.progress.open4gl.SDOParameters;
import com.progress.open4gl.SDOResultSet;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.javaproxy.Connection;

//
// YFKSSSCP
//
/**
 * 
 *
 * @author Bob Bao
 * @version 1
 */
public class YFKSSSCP implements SDOFactory {
	// "This proxy version is not compatible with the current
	// version of the dynamic API."
	protected static final long m_wrongProxyVer = jcMsg.jcMSG079;

	private static final int PROXY_VER = 5;

	public YFKSSSCPImpl m_YFKSSSCPImpl;

	// ---- Constructors
	public YFKSSSCP(Connection connection)
			throws Open4GLException, ConnectException, SystemErrorException, IOException {
		/* we must do this here before we attempt to create the appobject */
		if (RunTimeProperties.getDynamicApiVersion() != PROXY_VER)
			throw new Open4GLException(m_wrongProxyVer, null);

		String urlString = connection.getUrl();
		if (urlString == null || urlString.compareTo("") == 0)
			connection.setUrl("YFKSS_SCP");

		connection.setIntProperty("PROGRESS.Session.sessionModel", QADConfg.getQadSessionMode());
		m_YFKSSSCPImpl = new YFKSSSCPImpl("YFKSS_SCP", connection, RunTimeProperties.tracer);
	}

	public YFKSSSCP(String urlString, String userId, String password, String appServerInfo)
			throws Open4GLException, ConnectException, SystemErrorException, IOException {
		Connection connection;

		/* we must do this here before we attempt to create the appobject */
		if (RunTimeProperties.getDynamicApiVersion() != PROXY_VER)
			throw new Open4GLException(m_wrongProxyVer, null);

		if ("".equals(urlString)) {
			urlString = QADConfg.getQadServerUrl();
		}
		connection = new Connection(urlString, userId, password, appServerInfo);

		m_YFKSSSCPImpl = new YFKSSSCPImpl("YFKSS_SCP", connection, RunTimeProperties.tracer);

		/* release the connection since the connection object */
		/* is being destroyed. the user can't do this */
		connection.releaseConnection();
	}

	public YFKSSSCP(String userId, String password, String appServerInfo)
			throws Open4GLException, ConnectException, SystemErrorException, IOException {
		Connection connection;

		/* we must do this here before we attempt to create the appobject */
		if (RunTimeProperties.getDynamicApiVersion() != PROXY_VER)
			throw new Open4GLException(m_wrongProxyVer, null);

		connection = new Connection("YFKSS_SCP", userId, password, appServerInfo);

		m_YFKSSSCPImpl = new YFKSSSCPImpl("YFKSS_SCP", connection, RunTimeProperties.tracer);

		/* release the connection since the connection object */
		/* is being destroyed. the user can't do this */
		connection.releaseConnection();
	}

	public YFKSSSCP() throws Open4GLException, ConnectException, SystemErrorException, IOException {
		Connection connection;

		/* we must do this here before we attempt to create the appobject */
		if (RunTimeProperties.getDynamicApiVersion() != PROXY_VER)
			throw new Open4GLException(m_wrongProxyVer, null);

		connection = new Connection(QADConfg.getQadServerUrl(), "", "", null);

		connection.setIntProperty("PROGRESS.Session.sessionModel", QADConfg.getQadSessionMode());
		m_YFKSSSCPImpl = new YFKSSSCPImpl("YFKSS_SCP", connection, RunTimeProperties.tracer);
		

		/* release the connection since the connection object */
		/* is being destroyed. the user can't do this */
		connection.releaseConnection();
	}

	public void _release() throws Open4GLException, SystemErrorException {
		m_YFKSSSCPImpl._release();
	}

	// ---- Get Connection Id
	public Object _getConnectionId() throws Open4GLException {
		return (m_YFKSSSCPImpl._getConnectionId());
	}

	// ---- Get Request Id
	public Object _getRequestId() throws Open4GLException {
		return (m_YFKSSSCPImpl._getRequestId());
	}

	// ---- Get SSL Subject Name
	public Object _getSSLSubjectName() throws Open4GLException {
		return (m_YFKSSSCPImpl._getSSLSubjectName());
	}

	// ---- Is there an open output temp-table?
	public boolean _isStreaming() throws Open4GLException {
		return (m_YFKSSSCPImpl._isStreaming());
	}

	// ---- Stop any outstanding request from any object that shares this
	// connection.
	public void _cancelAllRequests() throws Open4GLException {
		m_YFKSSSCPImpl._cancelAllRequests();
	}

	// ---- Return the last Return-Value from a Progress procedure
	public String _getProcReturnString() throws Open4GLException {
		return (m_YFKSSSCPImpl._getProcReturnString());
	}

	// ---- Create an SDO ResultSet object - There are 3 overloaded variations
	public SDOResultSet _createSDOResultSet(String procName) throws Open4GLException, ProSQLException {
		return (m_YFKSSSCPImpl._createSDOResultSet(procName, null, null, null));
	}

	public SDOResultSet _createSDOResultSet(String procName, String whereClause, String sortBy)
			throws Open4GLException, ProSQLException {
		return (m_YFKSSSCPImpl._createSDOResultSet(procName, whereClause, sortBy, null));
	}

	public SDOResultSet _createSDOResultSet(String procName, String whereClause, String sortBy, SDOParameters params)
			throws Open4GLException, ProSQLException {
		return (m_YFKSSSCPImpl._createSDOResultSet(procName, whereClause, sortBy, params));
	}

	// Create the ProcObject that knows how to talk to SDO's.
	public SDOInterface _createSDOProcObject(String procName) throws Open4GLException {
		return (m_YFKSSSCPImpl._createSDOProcObject(procName));
	}

	/**
	*	
	*	
	*/
	public String xxcreate_xasndet(ProDataGraph input_xasndet, ProDataGraphHolder export_xasndet)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxcreate_xasndet(input_xasndet, export_xasndet);
	}

	/**
	*	
	*	
	*/
	public String xxexport_xasndet(ProDataGraph input_xasndet, ProDataGraphHolder export_xasndet)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxexport_xasndet(input_xasndet, export_xasndet);
	}

	/**
	*	
	*	
	*/
	public String xxexport_xpyhddet(ProDataGraph input_xpyhddet, ProDataGraphHolder export_xpyhddet)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxexport_xpyhddet(input_xpyhddet, export_xpyhddet);
	}

	/**
	*	
	*	
	*/
	public String xxinquiry_xprcdet(ProDataGraph input_xprcd, ProDataGraphHolder export_xprcd)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxinquiry_xprcdet(input_xprcd, export_xprcd);
	}

	/**
	*	
	*	
	*/
	public String xxinquiry_xprcmstr(ProDataGraph input_xprc, ProDataGraphHolder export_xprc)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxinquiry_xprcmstr(input_xprc, export_xprc);
	}

	/**
	*	
	*	
	*/
	public String xxinquiry_xpyhddet(ProDataGraph input_xpyhddet, ProDataGraphHolder export_xpyhddet)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxinquiry_xpyhddet(input_xpyhddet, export_xpyhddet);
	}

	/**
	*	
	*	
	*/
	public String xxinquiry_xpyhmstr(ProDataGraph input_xpyhmstr, ProDataGraphHolder export_xpyhmstr)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxinquiry_xpyhmstr(input_xpyhmstr, export_xpyhmstr);
	}

	/**
	*	
	*	
	*/
	public String xxinqury_prhdet(ProDataGraph input_prhdet, ProDataGraphHolder export_prhdet)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxinqury_prhdet(input_prhdet, export_prhdet);
	}

	/**
	*	
	*	
	*/
	public String xxinqury_prhmstr(ProDataGraph input_prhmstr, ProDataGraphHolder export_prhmstr)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxinqury_prhmstr(input_prhmstr, export_prhmstr);
	}

	/**
	*	
	*	
	*/
	public String xxinqury_xasnmstr(ProDataGraph input_xasnmstr, ProDataGraphHolder export_xasnmstr)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxinqury_xasnmstr(input_xasnmstr, export_xasnmstr);
	}

	/**
	*	
	*	
	*/
	public String xxinqury_xpyhddet2(ProDataGraph input_xpyhddet, ProDataGraphHolder export_xpyhddet)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxinqury_xpyhddet2(input_xpyhddet, export_xpyhddet);
	}

	/**
	*	
	*	
	*/
	public String xxprint_barcode(ProDataGraph input_bcddet, ProDataGraphHolder export_bcddet)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxprint_barcode(input_bcddet, export_bcddet);
	}

	/**
	*	
	*	
	*/
	public String xxupdate_xprcmstr(ProDataGraph input_xprc, ProDataGraphHolder export_xprc)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxupdate_xprcmstr(input_xprc, export_xprc);
	}

	/**
	*	
	*	
	*/
	public String xxupdate_xpyhmstr(ProDataGraph input_xpyhmstr, ProDataGraphHolder export_xpyhmstr)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxupdate_xpyhmstr(input_xpyhmstr, export_xpyhmstr);
	}

	/**
	*	
	*	
	*/
	public String xxview_xasndet(ProDataGraph input_xasndet, ProDataGraphHolder export_xasndet)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxview_xasndet(input_xasndet, export_xasndet);
	}

	/**
	*	
	*	
	*/
	public String xxview_xpyhddet(ProDataGraph input_xpyhddet, ProDataGraphHolder export_xpyhddet)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxview_xpyhddet(input_xpyhddet, export_xpyhddet);
	}

	/**
	*	
	*	
	*/
	public String xxview_forecast(ProDataGraph input_scpfcast, ProDataGraphHolder export_scpfcast)
			throws Open4GLException, RunTime4GLException, SystemErrorException {
		return m_YFKSSSCPImpl.xxview_forecast(input_scpfcast, export_scpfcast);
	}

	/**
	*	
	*	
	*/
	public String xxinquiry_claimdet(ProDataGraph input_xprcd, ProDataGraphHolder export_xprcd)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		return m_YFKSSSCPImpl.xxinquiry_claimdet( input_xprcd,  export_xprcd);
	}

}
