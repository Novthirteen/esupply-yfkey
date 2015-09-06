package com.yfkey.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.util.StringHelper;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.yfkey.model.PermissionType;
import com.yfkey.dao.UniversalDao;
import com.yfkey.dao.UserDao;
import com.yfkey.model.Menu;
import com.yfkey.model.User;
import com.yfkey.model.UserAuthority;
import com.yfkey.model.UserMenu;
import com.yfkey.util.NativeSqlRepository;

/**
 * This class interacts with Hibernate session to save/delete and retrieve User
 * objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler</a> Extended to
 *         implement Acegi UserDetailsService interface by David Carter
 *         david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan
 *         Noll</a> to work with the new BaseDaoHibernate implementation that
 *         uses generics. Modified by jgarcia (updated to hibernate 4)
 */
@Repository("userDao")
public class UserDaoHibernate extends GenericDaoHibernate<User, String>implements UserDao, UserDetailsService {

	@Autowired
	private UniversalDao universalDao;

	/**
	 * Constructor that sets the entity to User.class.
	 */
	public UserDaoHibernate() {
		super(User.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Query qry = getSession().createQuery("from User u order by upper(u.username)");
		return qry.list();
	}

	/**
	 * {@inheritDoc}
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List users = getSession().createCriteria(User.class).add(Restrictions.eq("username", username)).list();
		if (users == null || users.isEmpty()) {
			throw new UsernameNotFoundException("user '" + username + "' not found...");
		} else {
			User user = (User) users.get(0);

			loadUserPermission(user);
			loadUserMenu(user);
			return (UserDetails) user;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getUserPassword(String userName) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(SessionFactoryUtils.getDataSource(getSessionFactory()));
		Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
		return jdbcTemplate.queryForObject("select password from " + table.name() + " where userName=?", String.class,
				userName);
	}

	private void loadUserPermission(User user) {

		Collection<UserAuthority> userAuthorities = getSession().createCriteria(UserAuthority.class)
				.add(Restrictions.eq("username", user.getUsername())).list();

		if (CollectionHelper.isNotEmpty(userAuthorities)) {
			for (UserAuthority userAuthoritiy : userAuthorities) {
				if (userAuthoritiy.getPermissionType() == PermissionType.U) {
					user.addUserAuthorizedUrl(userAuthoritiy);
				} else if (userAuthoritiy.getPermissionType() == PermissionType.P) {
					user.addUserAuthorizedPlant(userAuthoritiy);
				} else if (userAuthoritiy.getPermissionType() == PermissionType.S) {
					user.addUserAuthorizedSupplier(userAuthoritiy);
				} else if (userAuthoritiy.getPermissionType() == PermissionType.B) {
					user.addUserAuthorizedButton(userAuthoritiy);
				}
			}
		}
	}

	private void loadUserMenu(User user) {
		List<Menu> authorityMenuList = universalDao.findByNativeSql(Menu.class,
				NativeSqlRepository.SELECT_USER_MENU_STATEMENT,
				new Object[] { user.getUsername(), user.getUsername() });

		if (CollectionHelper.isNotEmpty(authorityMenuList)) {
			List<UserMenu> userMenus = new ArrayList<UserMenu>();
			for (Menu menu : authorityMenuList) {
				if (StringHelper.isEmpty(menu.getParent())) {
					UserMenu userMenu = this.assemblyUserMenu(menu);
					userMenus.add(userMenu);
					for (Menu childMenu : authorityMenuList) {
						if (menu.getCode().equals(childMenu.getParent())) {
							userMenu.addItem(this.assemblyUserMenu(childMenu));
						}
					}
				}
			}

			user.setUserMenus(userMenus);
		}
	}

	private UserMenu assemblyUserMenu(Menu menu) {
		UserMenu userMenu = new UserMenu();
		userMenu.setValue(menu.getCode());
		userMenu.setText(menu.getName());
		if (StringHelper.isNotEmpty(menu.getImageUrl())) {
			userMenu.setImageUrl(menu.getImageUrl());
		}
		userMenu.setSequence(menu.getSequence());
		if (StringHelper.isNotEmpty(menu.getPageUrl())) {
			userMenu.setUrl(menu.getPageUrl());
		}

		return userMenu;
	}
}
