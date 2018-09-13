package com.fimc.hello.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/people")
public class PeopleResource {
	List<PeopleRequest> listofpeople =  new ArrayList<>();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getpeople(PeopleRequest peopleRequest) {
		listofpeople.add(peopleRequest);
		return Response.ok().entity(listofpeople).build();
		
	}
}
