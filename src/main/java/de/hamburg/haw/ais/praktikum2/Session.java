/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;

/**
 * @author Kevin Hüsgen
 *
 */
public class Session {
	
	int userID;
	String token;
	
	public Session(int userID, String token) {
		this.userID = userID;
		this.token = token;
	}
	
	public Session() {
		
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	
	public String toString() { 
		return "UserID: " + userID + " Token: " + token;
	}
	

}
