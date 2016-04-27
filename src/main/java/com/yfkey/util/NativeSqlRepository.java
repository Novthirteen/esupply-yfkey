package com.yfkey.util;

public class NativeSqlRepository {
	public static final String SELECT_ROLE_ASSIGNED_PERMISSION_STATEMENT = "select permission_code from role_permission where permission_type = ? and role_code = ?";
	public static final String SELECT_ROLE_AVAILABLE_PERMISSION_STATEMENT = "select * from permission where type = ?";

	public static final String SELECT_PERMISSION_VIEW_STATEMENT = "select username,permission_code,permission_name,permission_type from ("
			+ " select up.username as username,up.permission_code as permission_code,p.name  as permission_name,up.permission_type as permission_type"
			+ " from user_permission up inner join permission p on up.permission_code = p.code and up.permission_type = p.type where up.username = ?  and  up.permission_type = ? and up.permission_code like ?"
//			+ " union all select upg.username as username,pgp.permission_code as permission_code,p.name as permission_name,pgp.permission_type as permission_type"
//			+ " from user_permission_group upg inner join permission_group_permission pgp on upg.permission_group_code = pgp.permission_group_code"
//			+ " inner join permission p on pgp.permission_code = p.code and pgp.permission_type = p.type"
//			+ " where upg.username = ?  and pgp.permission_type = ? and pgp.permission_code like ?"
			+ " union all select ur.username as username,rp.permission_code as permission_code,p.name as permission_name,rp.permission_type as permission_type"
			+ " from user_role ur inner join role_permission rp on ur.role_code = rp.role_code"
			+ " inner join permission p  on rp.permission_code = p.code and rp.permission_type = p.type"
			+ " where ur.username = ?  and rp.permission_type = ? and rp.permission_code like ?"
//			+ "union all select ur.username as username,pgp.permission_code as permission_code,p.name as permission_name,pgp.permission_type as permission_type"
//			+ "from user_role ur inner join role_permission_group rpg on ur.role_code = rpg.role_code"
//			+ "inner join permission_group_permission pgp on rpg.permission_group_code = pgp.permission_group_code"
//			+ "inner join permission p on pgp.permission_code = p.code and pgp.permission_type = p.type"
//			+ "where ur.username = ?  and pgp.permission_type = ? and pgp.permission_code like ?"
			+ ") p group by username,permission_code,permission_name,permission_type";
	
	
	public static final String SELECT_USER_PERMISSION_STATEMENT = "select username,permission_code,permission_name,permission_type from ("
			+ " select up.username as username,up.permission_code as permission_code,p.name  as permission_name,up.permission_type as permission_type"
			+ " from user_permission up inner join permission p on up.permission_code = p.code and up.permission_type = p.type where up.username = ?  "
//			+ " union all select upg.username as username,pgp.permission_code as permission_code,p.name as permission_name,pgp.permission_type as permission_type"
//			+ " from user_permission_group upg inner join permission_group_permission pgp on upg.permission_group_code = pgp.permission_group_code"
//			+ " inner join permission p on pgp.permission_code = p.code and pgp.permission_type = p.type"
//			+ " where upg.username = ?  "
			+ " union all select ur.username as username,rp.permission_code as permission_code,p.name as permission_name,rp.permission_type as permission_type"
			+ " from user_role ur inner join role_permission rp on ur.role_code = rp.role_code"
			+ " inner join permission p  on rp.permission_code = p.code and rp.permission_type = p.type"
			+ " where ur.username = ?  "
//			+ "union all select ur.username as username,pgp.permission_code as permission_code,p.name as permission_name,pgp.permission_type as permission_type"
//			+ "from user_role ur inner join role_permission_group rpg on ur.role_code = rpg.role_code"
//			+ "inner join permission_group_permission pgp on rpg.permission_group_code = pgp.permission_group_code"
//			+ "inner join permission p on pgp.permission_code = p.code and pgp.permission_type = p.type"
//			+ "where ur.username = ? "
			+ ") p group by username,permission_code,permission_name,permission_type";
	

	public static final String SELECT_USER_MENU_STATEMENT = "select * from (" + " select m.* from menu as m "
			+ " inner join ("+ SELECT_USER_PERMISSION_STATEMENT +") as pv on m.permission_code = pv.permission_code"
			+ " where pv.username = ? and m.is_active = 1" + " union all" + " select distinct m.* from menu as m"
			+ " where m.code in (" + " select distinct m.parent from menu as m "
			+ " inner join ("+ SELECT_USER_PERMISSION_STATEMENT +") as pv on m.permission_code = pv.permission_code"
			+ " where pv.username = ? and m.parent is not null) and m.is_active = 1) as menu"
			+ " order by menu.sequence";

	public static final String SELECT_USER_PASSWORD_STATEMENT = "select password from user where username = ?";
}
