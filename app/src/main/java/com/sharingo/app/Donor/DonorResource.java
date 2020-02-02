package com.sharingo.app.Donor;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("donor")
public class DonorResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Donor> getDonorList(){
		DonorRepo donorRepo = new DonorRepo();
		
		return donorRepo.getDonorList();
	}
	
	@GET
	@Path("feedback")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public byte[] getfeedback(){
		
		DonorRepo obj = new DonorRepo();	
		
		return obj.getfeedback();
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Donor> getDonorByID(@PathParam("id") int id){
		
		DonorRepo donorRepo = new DonorRepo();		
		return donorRepo.getDonorByID(id);
		
	}
	
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	public String saveDonor(JsonObject inputData){
		
		DonorRepo donorRepo = new DonorRepo();
		try {
			donorRepo.save(inputData);
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return "Save successfull";
	
	}
	
	@GET
	@Path("foodcallrecords")
	@Produces({MediaType.APPLICATION_JSON})
	public List<DonorFood> getDonorFoodRecords(){
		
		DonorFoodRepo donorFoodRepo = new DonorFoodRepo();
		
		return donorFoodRepo.Fetch();
	}
	
	@POST
	@Path("newdonorform")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public JsonObject saveDonorFoodRecords(JsonObject inputData){
		
		DonorFoodRepo donorFoodRepo = new DonorFoodRepo();
		
		try{
			donorFoodRepo.saveDonorFood(inputData);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return inputData;
	}
	
}
