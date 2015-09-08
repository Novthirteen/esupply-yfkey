package com.yfkey.webapp.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.web.filter.OncePerRequestFilter;

import com.yfkey.Constants;
import com.yfkey.webapp.util.SecurityContextHelper;

public class MenuFilter extends OncePerRequestFilter {

	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute(Constants.USER_MENUS) == null
				&& CollectionHelper.isNotEmpty(SecurityContextHelper.getRemoteUserMenus())) {
			session.setAttribute(Constants.USER_MENUS, SecurityContextHelper.getRemoteUserMenus());
		}

		chain.doFilter(request, response);
	}
}
