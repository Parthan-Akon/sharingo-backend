package com.sharingo.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("donor")
public class DonorResource {

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String getDonorList(){
		DonorRepo donor = new DonorRepo();
		
		return donor.Fetch();
	}
}
