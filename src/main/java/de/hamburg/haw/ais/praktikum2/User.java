/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
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
	private String token;
	private Date expirationDate;
	
	public User(int userId, String username, String email, String password) {
		this.userID = userId;
		this.username = username;
		this.email = email;
		this.password = password;
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
	
	
	public String getToken() {
		return token;
	}
	
	@JsonIgnore
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public String getExpirationDateString() {
		if (expirationDate != null) {
			return expirationDate.toString();	
		}
		return null;
	}
		
	public String generateToken() {
		Random random = new SecureRandom();
		this.token = new BigInteger(130,random).toString(32);
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, 24);
		
		expirationDate = cal.getTime();
		
		return token;
	}
	

}
