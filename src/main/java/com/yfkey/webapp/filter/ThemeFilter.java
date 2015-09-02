package com.yfkey.webapp.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.util.StringHelper;
import org.springframework.web.filter.OncePerRequestFilter;

import com.yfkey.Constants;

/**
 * Filter to wrap request with a request including user preferred locale.
 */
public class ThemeFilter extends OncePerRequestFilter {

	@SuppressWarnings("unchecked")
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String theme = request.getParameter(Constants.BOOTSTRAP_THEME);

		if (StringHelper.isNotEmpty(theme)) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				session.setAttribute(Constants.BOOTSTRAP_THEME, theme);
			}
		}

		chain.doFilter(request, response);
	}
}
