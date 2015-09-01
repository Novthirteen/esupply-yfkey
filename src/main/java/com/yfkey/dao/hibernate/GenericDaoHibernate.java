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
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;
import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.yfkey.dao.GenericDao;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.Auditable;
import com.yfkey.model.Traceable;
import com.yfkey.model.Versionable;
import com.yfkey.webapp.util.SecurityContextHelper;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre>
 *      &lt;bean id="fooDao" class="com.yfkey.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="com.yfkey.model.Foo"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 *
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a> Updated by jgarcia:
 *         update hibernate3 to hibernate4
 * @author jgarcia (update: added full text search + reindexing)
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Log log = LogFactory.getLog(getClass());
	private Class<T> persistentClass;
	@Resource
	private SessionFactory sessionFactory;
	private Analyzer defaultAnalyzer;

	/**
	 * Constructor that takes in a class to see which type of entity to persist.
	 * Use this constructor when subclassing.
	 *
	 * @param persistentClass
	 *            the class type you'd like to persist
	 */
	public GenericDaoHibernate(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_35);
	}

	/**
	 * Constructor that takes in a class and sessionFactory for easy creation of
	 * DAO.
	 *
	 * @param persistentClass
	 *            the class type you'd like to persist
	 * @param sessionFactory
	 *            the pre-configured Hibernate SessionFactory
	 */
	public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory) {
		this.persistentClass = persistentClass;
		this.sessionFactory = sessionFactory;
		defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_35);
	}

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
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session sess = getSession();
		return sess.createCriteria(persistentClass).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAllDistinct() {
		Collection<T> result = new LinkedHashSet<T>(getAll());
		return new ArrayList<T>(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		Session sess = getSession();
		IdentifierLoadAccess byId = sess.byId(persistentClass);
		T entity = (T) byId.load(id);

		if (entity == null) {
			log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
			throw new ObjectRetrievalFailureException(this.persistentClass, id);
		}

		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public boolean exists(PK id) {
		Session sess = getSession();
		IdentifierLoadAccess byId = sess.byId(persistentClass);
		T entity = (T) byId.load(id);
		return entity != null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws PrincipalNullException
	 */
	@SuppressWarnings("unchecked")
	public void save(T object) throws PrincipalNullException {
		if (object instanceof Auditable) {
			((Auditable) object).setCreateDate(new Timestamp((new Date()).getTime()));
			((Auditable) object).setCreateUser(SecurityContextHelper.getRemoteUser());
			((Auditable) object).setUpdateDate(((Auditable) object).getCreateDate());
			((Auditable) object).setUpdateUser(((Auditable) object).getCreateUser());
		} else if (object instanceof Traceable) {
			((Traceable) object).setCreateDate(new Timestamp((new Date()).getTime()));
			((Traceable) object).setCreateUser(SecurityContextHelper.getRemoteUser());
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
	@SuppressWarnings("unchecked")
	public void update(T object) throws PrincipalNullException {
		if (object instanceof Auditable) {
			((Auditable) object).setUpdateDate(new Timestamp((new Date()).getTime()));
			((Auditable) object).setUpdateUser(SecurityContextHelper.getRemoteUser());
		}

		Session sess = getSession();
		sess.update(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(T object) {
		Session sess = getSession();
		sess.delete(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(PK id) {
		Session sess = getSession();
		IdentifierLoadAccess byId = sess.byId(persistentClass);
		T entity = (T) byId.load(id);
		sess.delete(entity);
	}
}
