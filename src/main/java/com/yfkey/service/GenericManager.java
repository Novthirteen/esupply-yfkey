package com.yfkey.service;

import java.io.Serializable;
import java.util.List;

import com.yfkey.exception.PrincipalNullException;

/**
 * Generic Manager that talks to GenericDao to CRUD POJOs.
 *
 * <p>Extend this interface if you want typesafe (no casting necessary) managers
 * for your domain objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Updated by jgarcia: added full text search + reindexing
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
public interface GenericManager<T, PK extends Serializable> {

	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @return List of populated objects
	 */
	List<T> getAll();

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
	 *            the identifier (primary key) of the object to get
	 * @return - true if it exists, false if it doesn't
	 */
	boolean exists(PK id);

	/**
	 * Generic method to save an object - handles only insert.
	 * 
	 * @param object
	 *            the object to save
	 */
	void save(T object) throws PrincipalNullException;

	/**
	 * Generic method to save an object - handles only update.
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
	 * Generic method to delete an object based on class and id
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to remove
	 */
	void remove(PK id);
}
