/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;


/**
 * @author Kevin Hüsgen
 *
 */

public class User {
	
	private int userId;
	private String name;
	private String email;
	private String password;
	
	public User(int userId, String name, String email, String password) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;		
	}
	
	public User() {
		
	}
	
	public int getUserID() {
		return userId;
	}
	
	public String getUsername() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		return "UserID: " + userId + " Username: " + name + " E-Mail: " + email + " Password: " + password;
	}
	
	public boolean validatePassword(String password) {
		return this.password.equals(password);			
	}
	

}
