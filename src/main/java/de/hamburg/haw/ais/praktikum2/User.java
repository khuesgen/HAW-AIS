/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author Kevin Hüsgen
 *
 */

public class User {
	
	private int userID;
	private String username;
	private String email;
	private String password;
	private int authenticationId;
	
	public User(int userId, String username, String email, String password) {
		this.userID = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		String authentication = sdf.format(cal.getTime()) + userId;
		authenticationId = authentication.hashCode();
	}
	
	public User() {
		
	}
	
	public int getUserID() {
		return userID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		return "UserID: " + userID + " Username: " + username + " E-Mail: " + email + " Password: " + password;
	}
	
	public boolean validatePassword(String password) {
		return this.password.equals(password);			
	}
	
	public int getAuthenticationId() {
		return authenticationId;
	}
	

}
