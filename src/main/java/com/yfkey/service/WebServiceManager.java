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

import com.yfkey.model.Supply;



/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/webServices")
public interface WebServiceManager {

	
	@GET
	@Path("getSupplyData")
	public List<String> getSupplyData(String query);

	
	@GET
	@Path("getItemData")
	public List<String> getItemData(String query);
	
	@GET
	@Path("getShiptoData")
	public List<String> getShiptoData(String query);
}