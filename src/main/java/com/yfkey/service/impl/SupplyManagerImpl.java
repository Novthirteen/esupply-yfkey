package com.yfkey.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.QueryParam;

import org.apache.avro.data.Json;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yfkey.Constants;
import com.yfkey.dao.UserDao;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.Item;
import com.yfkey.model.LabelValue;
import com.yfkey.model.Permission;
import com.yfkey.model.PermissionType;
import com.yfkey.model.Role;
import com.yfkey.model.Shipto;
import com.yfkey.model.Supply;
import com.yfkey.model.User;
import com.yfkey.model.UserPermission;
import com.yfkey.model.UserRole;
import com.yfkey.service.UniversalManager;
import com.yfkey.service.UserManager;
import com.yfkey.service.SupplyManager;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("supplyManager")
@WebService(serviceName = "SupplyManager", endpointInterface = "com.yfkey.service.SupplyManager")
public class SupplyManagerImpl extends GenericManagerImpl<User, String>implements SupplyManager {
	@Autowired
	private UniversalManager universalManager;

	@SuppressWarnings("unchecked")
	@ResponseBody
	@Override
	public List<LabelValue> getSupplyData(String domain,String usercode, String query) {
		List<LabelValue> lvList = new ArrayList<LabelValue>();

		List<String[]> permissionCodeList = universalManager.findByNativeSql(
				"select permission_code,permission_name from permission_view where permission_type = ? and username = ? and permission_code like ?",
				new Object[] { PermissionType.S.toString(), usercode, domain+"%"});
		
		if(permissionCodeList != null && permissionCodeList.size()>0)
		{
			for (Object[] permission : permissionCodeList) {
				lvList.add(new LabelValue((String)permission[1], (String)permission[0]));
			}
			
		}
		
		return lvList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LabelValue> getItemData(String domain, String query) {
		List<LabelValue> lvList = new ArrayList<LabelValue>();

		List<Item> itemList = universalManager.findByHql("from Item where itemdomain = ?", new Object[] { domain });

		if (itemList != null && itemList.size() > 0) {
			for (Item item : itemList) {
				lvList.add(new LabelValue(item.getItemcode() + "(" + item.getItemdesc() + ")", item.getItemcode()));
			}
		}
		return lvList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LabelValue> getShiptoData(String domain, String query) {
		List<LabelValue> lvList = new ArrayList<LabelValue>();
		
		List<Shipto> shiptoList = universalManager.findByHql("from Shipto where shdomain = ?", new Object[] { domain });

		if (shiptoList != null && shiptoList.size() > 0) {
			for (Shipto shipto : shiptoList) {
				lvList.add(new LabelValue(shipto.getShcode() + "(" + shipto.getShname() + ")", shipto.getShcode()));
			}
		}
		return lvList;
	}

}
