package com.yfkey.webapp.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.yfkey.model.Permission;
import com.yfkey.model.PermissionType;
import com.yfkey.service.UniversalManager;

public class DataBaseFilterInvocationSecurityMetadataSource
		implements FilterInvocationSecurityMetadataSource, InitializingBean {

	protected final Log logger = LogFactory.getLog(getClass());

	private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;
	private UniversalManager universalManager;

	public void setUniversalManager(UniversalManager universalManager) {
		this.universalManager = universalManager;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
			allAttributes.addAll(entry.getValue());
		}

		return allAttributes;
	}

	public Collection<ConfigAttribute> getAttributes(Object object) {
		final HttpServletRequest request = ((FilterInvocation) object).getRequest();
		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
			if (entry.getKey().matches(request)) {
				return entry.getValue();
			}
		}
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		initRequestMap();
	}

	private void initRequestMap() {
		if (requestMap == null) {
			synchronized (this) {
				if (requestMap == null) {
					requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
					RequestMatcher requestMatcher = null;
					Collection<ConfigAttribute> attrs = null;
					List<Permission> allPermissions = this.universalManager.getAll(Permission.class);
					if (!CollectionHelper.isEmpty(allPermissions)) {
						for (Permission p : allPermissions) {
							if (p.getType() == PermissionType.U) {
								requestMatcher = new RegexRequestMatcher(p.getCode() + "*", null);
							} else {
								requestMatcher = new RegexRequestMatcher(p.getCode(), null);
							}

							attrs = new HashSet<ConfigAttribute>();
							attrs.add(new SecurityConfig(p.getCode()));
							requestMap.put(requestMatcher, attrs);
						}
					} else {
						logger.error("No data found while loading all permissions.");
					}
				}
			}
		}
	}

}
