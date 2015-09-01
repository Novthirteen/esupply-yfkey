package com.yfkey.dao;

import java.io.Serializable;
import java.util.List;

import com.yfkey.exception.PrincipalNullException;

/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 *
 * <p>
 * Extend this interface if you want typesafe (no casting necessary) DAO's for
 * your domain objects.
 *
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * @author jgarcia (update: added full text search + reindexing)
 *
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @return List of populated objects
	 */
	List<T> getAll();

	/**
	 * Gets all records without duplicates.
	 * <p>
	 * Note that if you use this method, it is imperative that your model
	 * classes correctly implement the hashcode/equals methods
	 * </p>
	 * 
	 * @return List of populated objects
	 */
	List<T> getAllDistinct();

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 *
	 * @param id
	 *            the identifier (primary key) of the object to get
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	T get(PK id);

	/**
	 * Checks for existence of an object of type T using the id arg.
	 * 
	 * @param id
	 *            the id of the entity
	 * @return - true if it exists, false if it doesn't
	 */
	boolean exists(PK id);

	/**
	 * Generic method to save an object - insert only.
	 * 
	 * @param object
	 *            the object to save
	 */
	void save(T object) throws PrincipalNullException;

	/**update
	 * Generic method to update an object - insert only.
	 * 
	 * @param object
	 *            the object to update
	 */
	void update(T object) throws PrincipalNullException;

	/**
	 * Generic method to delete an object
	 * 
	 * @param object
	 *            the object to remove
	 */
	void remove(T object);

	/**
	 * Generic method to delete an object
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to remove
	 */
	void remove(PK id);
}