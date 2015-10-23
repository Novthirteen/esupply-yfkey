package com.yfkey.service;

import java.io.Serializable;
import java.util.List;

import com.yfkey.exception.PrincipalNullException;


public interface UniversalManager {
	List getAll(Class clazz);

	List getAllDistinct(Class clazz);

	Object get(Class clazz, Serializable id);

	boolean exists(Class clazz, Serializable id);

	void save(Object object) throws PrincipalNullException;

	void update(Object object) throws PrincipalNullException;

	void remove(Object object);

	void remove(Class clazz, Serializable id);

	void executeByHql(String hql);

	void executeByHql(String hql, Object param);

	void executeByHql(String hql, Object[] params);

	void executeByNativeSql(String sql);

	void executeByNativeSql(String sql, Object param);

	void executeByNativeSql(String sql, Object[] params);

	List findByHql(String hql);
	
	List findByHql(String hql, Integer maxResults);

	List findByHql(String hql, Object queryParam);
	
	List findByHql(String hql, Object queryParam, Integer maxResults);

	List findByHql(String hql, Object[] queryParams);
	
	List findByHql(String hql, Object[] queryParams, Integer maxResults);

	List findByNativeSql(String sql);

	List findByNativeSql(String sql, Object queryParam);

	List findByNativeSql(String sql, Object[] queryParams);

	List findByNativeSql(Class clazz, String sql);

	List findByNativeSql(Class clazz, String sql, Object queryParam);

	List findByNativeSql(Class clazz, String sql, Object[] queryParams);

	void flushSession();

	void cleanSession();
}
