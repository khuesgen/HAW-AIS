/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Kevin Hüsgen
 *
 */
public class UserDAO {
	private static List<User> users = new ArrayList<User>();
	private static int pointerId = 0;
	
	public UserDAO(){
		
		
	}
	
	public User addUser(String name, String email, String password) {
		if (!exists(email)) {
			User newUser = new User(generateUserId(),name,email,password);
			users.add(newUser);
			return newUser;
		}
		return null;
	}
	
	public User getUser(int userId) {
		for (User u : users) {
			if (u.getUserID() == userId) {
				return u;
			}
		}
		return null;
	}
	
	public User getUser(String email) {
		for (User u : users) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}
	
	
	public boolean isValidPassword(String email, String passwort) {
		User temp = getUser(email);
		if (temp != null) {
			return temp.validatePassword(passwort);
		}
		return false;	
		
	}
	
	public boolean isValidAuthenticationId(int authenticationId, User user) {
		return user.getAuthenticationId() == authenticationId;
	}
	
	public int generateUserId() {
		pointerId++;
		return pointerId;
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public boolean exists(User user) {
		boolean exists = false;
		for (User u : users) {
			if (u.getUserID() == user.getUserID()) {
				exists = true;
			}
		}
		return exists;
	}
	
	public boolean exists(String email) {
		boolean exists = false;
		for (User u : users) {
			if (u.getEmail().equals(email)) {	
				exists = true;
			}
		}
		return exists;
	}

}
