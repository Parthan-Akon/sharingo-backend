package com.sharingo.app.collection;

import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("collection")
public class CollectionResource {
	
	CollectionRepo collectionRepo = new CollectionRepo();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Collection> getAllCollection(){
		
				
		return collectionRepo.getCollections();
		
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Collection> getCollectionByDonorID(@PathParam("id") int id){
		
		return collectionRepo.getCollectionByID(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public JsonObject saveCollection(JsonObject inputData){
		
		
		try {
			collectionRepo.saveCollection(inputData);
			System.out.print(inputData);
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return inputData ;
	
	}
}