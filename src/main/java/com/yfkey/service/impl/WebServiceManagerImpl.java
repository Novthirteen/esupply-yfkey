package com.yfkey.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.avro.data.Json;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yfkey.dao.UserDao;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.PermissionType;
import com.yfkey.model.User;
import com.yfkey.model.UserPermission;
import com.yfkey.model.UserRole;
import com.yfkey.service.UniversalManager;
import com.yfkey.service.UserManager;
import com.yfkey.service.UserService;
import com.yfkey.service.WebServiceManager;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("webServiceManager")
@WebService(serviceName = "WebServiceManager", endpointInterface = "com.yfkey.service.WebServiceManager")
public class WebServiceManagerImpl extends GenericManagerImpl<User, String>implements  WebServiceManager {
	@Autowired
	private UniversalManager universalManager;

	

	@ResponseBody
	@Override
	public List<String> getSupplyData(String query) {
		List<String> data = new ArrayList<String>();
		
		data.add("chinese");
		data.add("american");
		data.add("janpenes");
		data.add("korea");
		data.add("sigapo");
		return data;
	}

	@Override
	public List<String> getItemData(String query) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<String> getShiptoData(String query) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
