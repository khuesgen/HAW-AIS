/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;

/**
 * @author Kevin Hüsgen
 *
 */
public class Credentials {

		private int userID;
		private int authenticationId;
		
		public Credentials(int userID, int authenticationId) {
			this.userID = userID;
			this.authenticationId = authenticationId;
		}
		
		public Credentials() {
			
		}

		/**
		 * @return the authenticationId
		 */
		public int getAuthenticationId() {
			return authenticationId;
		}

		/**
		 * @return the userID
		 */
		public int getUserID() {
			return userID;
		}

		
		
		
}
