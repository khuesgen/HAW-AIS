/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


/**
 * @author Kevin Hüsgen
 *
 */
public class UserDAO {
	private static HashMap<Integer, User> users = new HashMap<Integer, User>();
	private static HashMap<Integer,Session> sessions = new HashMap<Integer, Session>();
	private static int pointerId = 0;
	
	public UserDAO(){
			
	}
	
	public User addUser(String name, String email, String password) {
		if (!exists(email)) {
			User newUser = new User(generateUserId(),name,email,password);
			users.put(newUser.getUserID(), newUser);
			return newUser;
		}
		return null;
	}
	
	public void addSession(Session s) {
		sessions.put(s.getUserID(), s);
	}
	
	public void removeSession(Session s) {
		sessions.remove(s.getUserID());
	}
	
	public User getUser(int userId) {
		if (users.containsKey(userId)) {
			return users.get(userId);
		}
		return null;
	}
	
	public User getUser(String email) {
		for (User u : users.values()) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}
	
	
	public boolean isValidToken(String token, User user) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (cal.getTime().before(user.getExpirationDate())) {
			return user.getToken().equals(token);
		} else {
			return false;
		}
		
	}
	
	public boolean isValidPassword(String password, User user) {
		return user.getPassword().equals(password);
	}
	
	public boolean isValidSession(Session session) {
		return sessions.containsKey(session.getUserID());
	}
	
	public int generateUserId() {
		pointerId++;
		return pointerId;
	}
	
	
	public boolean exists(User user) {
		return users.containsValue(user);
	}
	
	public boolean exists(String email) {
		boolean exists = false;
		for (User u : users.values()) {
			if (u.getEmail().equals(email)) {	
				exists = true;
			}
		}
		return exists;
	}

}
