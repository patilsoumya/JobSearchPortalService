
package com.JobSearchService.Controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.JobSearchService.Service.ValidateUserServiceImpl;
import com.jobSearch.VO.UserVO;

@Path("/ValidateLogonService")
public class ValidateLogonService {
	
	@Path("/validateUser")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
 
	public Response validateUser(UserVO userVO) throws Exception {
		userVO = ValidateUserServiceImpl.validateUser(userVO);
		return Response.ok().entity(userVO).build();
	}
	
	
	@Path("/createUser")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
 
	public Response createUser(UserVO userVO) throws Exception {
		userVO = ValidateUserServiceImpl.createUser(userVO);
		return Response.ok().entity(userVO).build();
	}
	

}
