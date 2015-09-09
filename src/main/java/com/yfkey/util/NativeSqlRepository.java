package com.yfkey.util;

public class NativeSqlRepository {
	public static final String SELECT_ROLE_ASSIGNED_PERMISSION_STATEMENT = "select permission_code from role_permission where permission_type = ? and role_code = ?";
	public static final String SELECT_ROLE_AVAILABLE_PERMISSION_STATEMENT = "select * from permission where type = ?";
	
	public static final String SELECT_USER_MENU_STATEMENT = "select * from ("
			+ " select m.* from menu as m "
			+ " inner join permission_view as pv on m.permission_code = pv.permission_code"
			+ " where pv.username = ? and m.is_active = 1"
			+ " union all"
			+ " select distinct m.* from menu as m"
			+ " where m.code in ("
			+ " select distinct m.parent from menu as m "
			+ " inner join permission_view as pv on m.permission_code = pv.permission_code"
			+ " where pv.username = ? and m.parent is not null) and m.is_active = 1) as menu"
			+ " order by menu.sequence";
	
	public static final String SELECT_USER_PASSWORD_STATEMENT = "select password from user where username = ?";
}
