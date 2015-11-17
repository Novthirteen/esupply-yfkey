package com.yfkey.qad;

public class QADConfg {
	/**
	 * 连接地址
	 */
	private static String qadServerUrl;

	// AppServerDC://ip:46000/qadsi_ASdemo
	/**
	 * 连接模式，默认为1
	 */
	private static int qadSessionMode;

	/**
	 * QadFile文件路径 如：路径为：/opt/qad/custom/gl/src/gl/xxexpensegl.p
	 * 那这里的路径为：/opt/qad/custom/gl/src/gl/
	 */
	// public static String m_QadFilePath = "/apps/cust/us/xx/";
	private static String qadFilePath;
	
	
	private static String qadUploadPathProd;
	private static String qadUploadPathTest;
	private static String qadUploadPathTraining;
	

	public static String getQadServerUrl() {
		return qadServerUrl;
	}

	public void setQadServerUrl(String qadServerUrl) {
		QADConfg.qadServerUrl = qadServerUrl;
	}

	public static int getQadSessionMode() {
		return qadSessionMode;
	}

	public void setQadSessionMode(int qadSessionMode) {
		QADConfg.qadSessionMode = qadSessionMode;
	}

	public static String getQadFilePath() {
		return qadFilePath;
	}

	public void setQadFilePath(String qadFilePath) {
		QADConfg.qadFilePath = qadFilePath;
	}

	public static String getQadUploadPathProd() {
		return qadUploadPathProd;
	}

	public static void setQadUploadPathProd(String qadUploadPathProd) {
		QADConfg.qadUploadPathProd = qadUploadPathProd;
	}

	public static String getQadUploadPathTest() {
		return qadUploadPathTest;
	}

	public  void setQadUploadPathTest(String qadUploadPathTest) {
		QADConfg.qadUploadPathTest = qadUploadPathTest;
	}

	public static String getQadUploadPathTraining() {
		return qadUploadPathTraining;
	}

	public  void setQadUploadPathTraining(String qadUploadPathTraining) {
		QADConfg.qadUploadPathTraining = qadUploadPathTraining;
	}
}