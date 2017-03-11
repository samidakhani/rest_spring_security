package org.dakhani.spring.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dakhani.spring.bo.UserBO;
import org.dakhani.spring.service.UserService;
import org.dakhani.spring.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

/**
 * @author Sami Dakhani Created on Mar 6, 2017
 *
 */
@Path("/api/")
@Controller
public class RestController {

	@Autowired
	private UserService service;

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Response getUserData() {

		List<UserBO> users = this.service.retrieveUsers();
		String jsonObj = JSONUtil.getJsonString(users);

		return Response.status(Status.OK).entity(jsonObj).build();

	}

}
