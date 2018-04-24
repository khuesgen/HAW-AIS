/**
 * 
 */
package de.hamburg.haw.ais.praktikum2;

/**
 * @author Kevin Hüsgen
 *
 */
public class Credentials {

		private String email;
		private String password;
		
		public Credentials(String email, String password) {
			this.email = email;
			this.password = password;
		}
		
		public Credentials() {
			
		}

		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		
		
		
}
