package com.yfkey.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.yfkey.model.LabelValue;
import com.yfkey.model.Supply;



/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/supplys")
public interface SupplyManager {

	
	@GET
	@Path("getSupplyData")
	public List<LabelValue> getSupplyData(@QueryParam("domain") String domain,@QueryParam("usercode") String usercode,@QueryParam("query") String query);

	
	@GET
	@Path("getItemData")
	public List<LabelValue> getItemData(@QueryParam("domain") String domain,@QueryParam("query") String query);
	
	@GET
	@Path("getShiptoData")
	public List<LabelValue> getShiptoData(@QueryParam("domain") String domain,@QueryParam("query") String query);
}