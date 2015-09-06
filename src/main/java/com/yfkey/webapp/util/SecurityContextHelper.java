package com.yfkey.webapp.util;

import java.util.Collection;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.yfkey.model.UserAuthority;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.User;
import com.yfkey.model.UserMenu;

public class SecurityContextHelper {

	public static String getRemoteUser() throws PrincipalNullException {
		SecurityContext context = SecurityContextHolder.getContext();

		if (context != null && context.getAuthentication() != null && context.getAuthentication().getPrincipal() != null
				&& context.getAuthentication().getPrincipal() instanceof User) {
			return ((User) context.getAuthentication().getPrincipal()).getUsername();
		} else {
			throw new PrincipalNullException();
		}
	}
	
	public static Collection<UserMenu> getRemoteUserMenus() {
		SecurityContext context = SecurityContextHolder.getContext();

		if (context != null && context.getAuthentication() != null && context.getAuthentication().getPrincipal() != null
				&& context.getAuthentication().getPrincipal() instanceof User) {
			return ((User) context.getAuthentication().getPrincipal()).getUserMenus();
		} else {
			return null;
		}
	}
	
	public static Collection<UserAuthority> getRemoteUserPlants() {
		SecurityContext context = SecurityContextHolder.getContext();

		if (context != null && context.getAuthentication() != null && context.getAuthentication().getPrincipal() != null
				&& context.getAuthentication().getPrincipal() instanceof User) {
			return ((User) context.getAuthentication().getPrincipal()).getAuthoriedPlants();
		} else {
			return null;
		}
	}
}
