package com.yfkey.webapp.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.yfkey.Constants;

public class NoPlantSelectedInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5875989396901908133L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if (invocation.getInvocationContext().getSession().get(Constants.SELECTED_USER_PLANT) == null) {
			return "home";
		}

		return invocation.invoke();
	}
}