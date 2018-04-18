/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Kevin Hüsgen
 *
 */

@Path("user")
public class UserService {
	
	UserDAO users = new UserDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{user}")
	public User getUsername(@PathParam("user") int userId) {
		
		User user = users.getUser(userId);
		if ( user != null) {
			return user;
		}
		else {
			return null;
		}
		
	}
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(@FormParam("name") String name, @FormParam("email") String email, @FormParam("password") String password) {
		User newUser = users.addUser(name, email, password);
		
		if (newUser != null) {
			return  Response.status(Response.Status.OK).entity(newUser).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).entity(null).build();
	}
	
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("allUsers")
	public List<User> getAllUsers() {
		return users.getAllUsers();
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(User user) {
		if (users.isValidPassword(user.getEmail(), user.getPassword())) {
			// TODO User einloggen (Session setzen etc.)
			return Response.status(Response.Status.OK).build();
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	//TODO User löschen (@DELETE)
	

}
