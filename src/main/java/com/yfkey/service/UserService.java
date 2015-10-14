package com.yfkey.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yfkey.exception.UserExistsException;
import com.yfkey.model.User;



/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/users")
public interface UserService {

	/**
	 * Retrieves a list of all users.
	 *
	 * @return List
	 */
	@GET
	@Path("getUsers")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getUsers();

	/**
	 * Retrieves a user by userId. An exception is thrown if user not found
	 *
	 * @param userName
	 *            for the user
	 * @return User
	 */
	@GET
	@Path("getuser/{userName}")
	public User getUser(@PathParam("userName") String userName);

	/**
	 * Finds a user by their username.
	 *
	 * @param username
	 *            the user's username used to login
	 * @return User a populated user object
	 */
	public User getUserByUsername(@PathParam("username") String username);
	
	@GET
	@Path("getData")
	public List<String> getData(String query);


}