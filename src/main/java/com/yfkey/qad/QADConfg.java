package com.yfkey.qad;


public class QADConfg {
	/**
	 * 连接地址
	 */
	public static String m_AppSrvUrl = "AppServer://192.168.210.114:5162/YFKSS_SCP";
	
//	AppServerDC://ip:46000/qadsi_ASdemo
	/**
	 * 连接模式，默认为1
	 */
	public static int m_SessionModel = 1;
	
	/**
	 * QadFile文件路径
	 * 如：路径为：/opt/qad/custom/gl/src/gl/xxexpensegl.p
	 * 那这里的路径为：/opt/qad/custom/gl/src/gl/
	 */
	//public static String m_QadFilePath = "/apps/cust/us/xx/";
    public static String m_QadFilePath = "/home/mfg/scp/us/xx/";
	
}