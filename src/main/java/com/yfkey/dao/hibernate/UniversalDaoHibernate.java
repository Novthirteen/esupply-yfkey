package com.yfkey.dao.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;

import com.yfkey.dao.UniversalDao;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.Auditable;
import com.yfkey.model.Traceable;
import com.yfkey.model.Versionable;
import com.yfkey.webapp.util.SecurityContextHelper;

@Repository("universalDao")
public class UniversalDaoHibernate implements UniversalDao {
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Log log = LogFactory.getLog(getClass());

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public Session getSession() throws HibernateException {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	@Autowired
	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	public List getAll(Class clazz) {
		Session sess = getSession();
		return sess.createCriteria(clazz).list();
	}

	/**
	 * {@inheritDoc}
	 */
	public List getAllDistinct(Class clazz) {
		Collection result = new LinkedHashSet(getAll(clazz));
		return new ArrayList(result);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object get(Class clazz, Serializable id) {
		Session sess = getSession();
		IdentifierLoadAccess byId = sess.byId(clazz);
		Object entity = byId.load(id);

		if (entity == null) {
			log.warn("Uh oh, '" + clazz + "' object with id '" + id + "' not found...");
			throw new ObjectRetrievalFailureException(clazz, id);
		}

		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists(Class clazz, Serializable id) {
		Session sess = getSession();
		IdentifierLoadAccess byId = sess.byId(clazz);
		Object entity = byId.load(id);
		return entity != null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws PrincipalNullException
	 */
	public void save(Object object) throws PrincipalNullException {
		if (object instanceof Auditable) {
			((Auditable) object).setCreateDate(new Timestamp((new Date()).getTime()));
			((Auditable) object).setCreateUser(SecurityContextHelper.getRemoteUserName());
			((Auditable) object).setUpdateDate(((Auditable) object).getCreateDate());
			((Auditable) object).setUpdateUser(((Auditable) object).getCreateUser());
		} else if (object instanceof Traceable) {
			((Traceable) object).setCreateDate(new Timestamp((new Date()).getTime()));
			((Traceable) object).setCreateUser(SecurityContextHelper.getRemoteUserName());
		}

		if (object instanceof Versionable) {
			((Versionable) object).setVersion(1);
		}

		Session sess = getSession();
		sess.save(object);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws PrincipalNullException
	 */
	public void update(Object object) throws PrincipalNullException {

		if (object instanceof Auditable) {
			((Auditable) object).setUpdateDate(new Timestamp((new Date()).getTime()));
			((Auditable) object).setUpdateUser(SecurityContextHelper.getRemoteUserName());
		}

		Session sess = getSession();
		sess.update(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(Object object) {
		Session sess = getSession();
		sess.delete(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(Class clazz, Serializable id) {
		Session sess = getSession();
		IdentifierLoadAccess byId = sess.byId(clazz);
		sess.delete(byId.load(id));
	}

	public void executeByHql(String hql) {
		executeByHql(hql, (Object[]) null);
	}

	public void executeByHql(String hql, Object param) {
		executeByHql(hql, new Object[] { param });
	}

	public void executeByHql(String hql, Object[] params) {
		Session sess = getSession();

		Query query = sess.createQuery(hql);

		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		query.executeUpdate();
	}

	public void executeByNativeSql(String sql) {
		executeByNativeSql(sql, (Object[]) null);
	}

	public void executeByNativeSql(String sql, Object param) {
		executeByNativeSql(sql, new Object[] { param });
	}

	public void executeByNativeSql(String sql, Object[] params) {
		Session sess = getSession();

		Query query = sess.createSQLQuery(sql);

		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		query.executeUpdate();
	}

	public List findByHql(String hql) {
		return findByHql(hql, (Object[]) null, null);
	}
	
	public List findByHql(String hql, Integer maxResults) {
		return findByHql(hql, (Object[]) null, maxResults);
	}

	public List findByHql(String hql, Object queryParam) {
		return findByHql(hql, new Object[] { queryParam }, null);
	}
	
	public List findByHql(String hql, Object queryParam, Integer maxResults) {
		return findByHql(hql, new Object[] { queryParam }, maxResults);
	}
	
	public List findByHql(String hql, Object[] queryParams) {
		return findByHql(hql, queryParams, null);
	}

	public List findByHql(String hql, Object[] queryParams, Integer maxResults) {
		Session sess = getSession();
		Query query = sess.createQuery(hql);

		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i, queryParams[i]);
			}
		}
		
		if (maxResults != null) {
			query.setMaxResults(maxResults);
		}

		return query.list();
	}

	public List findByNativeSql(String sql) {
		return findByNativeSql(null, sql, (Object[]) null);
	}

	public List findByNativeSql(String sql, Object queryParam) {
		return findByNativeSql(null, sql, new Object[] { queryParam });
	}

	public List findByNativeSql(String sql, Object[] queryParams) {
		return findByNativeSql(null, sql, queryParams);
	}

	public List findByNativeSql(Class clazz, String sql) {
		return findByNativeSql(sql, (Object[]) null);
	}

	public List findByNativeSql(Class clazz, String sql, Object queryParam) {
		return findByNativeSql(clazz, sql, new Object[] { queryParam });
	}

	public List findByNativeSql(Class clazz, String sql, Object[] queryParams) {
		Session sess = getSession();
		SQLQuery query = sess.createSQLQuery(sql);

		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i, queryParams[i]);
			}
		}

		if (clazz != null) {
			query.addEntity(clazz);
		}

		return query.list();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void flushSession() {
		Session sess = getSession();
		sess.flush();
	}

	/**
	 * {@inheritDoc}
	 */
	public void cleanSession() {
		Session sess = getSession();
		sess.clear();
	}
}
