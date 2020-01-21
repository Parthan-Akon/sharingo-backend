package com.sharingo.app;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("volunteer")
public class VolunteerResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Volunteer> getAllVolunteers(){
		
		VolunteerRepo volunteerRepo = new VolunteerRepo();
		
		return volunteerRepo.getVolunteerList();
	}
}
