package com.yfkey.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yfkey.dao.GenericDao;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.service.GenericManager;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre>
 *     &lt;bean id="userManager" class="com.yfkey.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="com.yfkey.dao.hibernate.GenericDaoHibernate"&gt;
 *                 &lt;constructor-arg value="com.yfkey.model.User"/&gt;
 *                 &lt;property name="sessionFactory" ref="sessionFactory"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 * <p/>
 * <p>
 * If you're using iBATIS instead of Hibernate, use:
 * 
 * <pre>
 *     &lt;bean id="userManager" class="com.yfkey.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="com.yfkey.dao.ibatis.GenericDaoiBatis"&gt;
 *                 &lt;constructor-arg value="com.yfkey.model.User"/&gt;
 *                 &lt;property name="dataSource" ref="dataSource"/&gt;
 *                 &lt;property name="sqlMapClient" ref="sqlMapClient"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 *
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Updated by
 *         jgarcia: added full text search + reindexing
 */
public class GenericManagerImpl<T, PK extends Serializable> implements GenericManager<T, PK> {
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * GenericDao instance, set by constructor of child classes
	 */
	protected GenericDao<T, PK> dao;

	public GenericManagerImpl() {
	}

	public GenericManagerImpl(GenericDao<T, PK> genericDao) {
		this.dao = genericDao;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAll() {
		return dao.getAll();
	}

	/**
	 * {@inheritDoc}
	 */
	public T get(PK id) {
		return dao.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists(PK id) {
		return dao.exists(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public void save(T object) throws PrincipalNullException {
		dao.save(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(T object) throws PrincipalNullException {
		dao.update(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(T object) {
		dao.remove(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(PK id) {
		dao.remove(id);
	}
}
