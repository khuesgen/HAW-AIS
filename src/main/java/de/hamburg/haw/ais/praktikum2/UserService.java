/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("profile")
	public Response getUsername(Session session) {	
		if (users.isValidSession(session)){
			User temp = users.getUser(session.getUserID());
			if(users.isValidToken(session.getToken(), temp)) {
				return Response.status(Response.Status.OK).entity(temp).build();
			}
		}							
		return Response.status(Response.Status.UNAUTHORIZED).build();	
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
	

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Credentials credentials) {
		User temp = users.getUser(credentials.getEmail());
		if (temp != null){
				if (users.isValidPassword(credentials.getPassword(), temp)) {
					String token = temp.generateToken();
					Session session = new Session(temp.getUserID(),token);
					users.addSession(session);
					return Response.status(Response.Status.OK).entity(session).build();
				}	
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("logout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logout(Session session) {
		if (users.isValidSession(session)) {
			User temp = users.getUser(session.getUserID());	
			if (users.isValidToken(session.getToken(), temp)) {			
				users.removeSession(session);
				return Response.status(Response.Status.OK).build();
			}
		}
					
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	

}
