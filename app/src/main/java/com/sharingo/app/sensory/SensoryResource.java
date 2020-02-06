package com.sharingo.app.sensory;

import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("sensory")
public class SensoryResource {

	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Sensory> getSensoryList() {
	
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public JsonObject saveSensory(JsonArray inputData) {
		
		SensoryRepo sensoryRepo = new SensoryRepo();
		
		try{
			int j = inputData.size();
			for(int i=0;i<j;i++){
				JsonObject jsonObject = inputData.getJsonObject(i);
				sensoryRepo.saveSensory(jsonObject);
			}
			
			System.out.println("successfull");
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
}	
