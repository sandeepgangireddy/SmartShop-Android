package Com.smartshop2.Appium_SmartTests2.providers;

import Com.smartshop2.Appium_SmartTests2.helper.Helper;

public class NewUserGenerator {
	
	private static final String DEFAULT_FIRST_NAME = "Smart";
	private static final String DEFAULT_LAST_NAME = "Shop";
	private static final String DEFAULT_PASSWORD = "test12345";
	private static final String DEFAULT_CONFIRMPASSWORD = "test123456";
	private static final String DEFAULT_EMAIL_PROVIDER = "@gmail.com";
	private static final String DEFAULT_EMAIL_PREFIX = "smart";
	private static final String DEFAULT_POSTCODE="Ig117qb";
	private static final String DEFAULT_NECTAR_NUMBER = "12015917017";
	
	
	
	public static User createRandomValidUser() {
		User user = new User();
		user.setFirstName(DEFAULT_FIRST_NAME);
		user.setLastName(DEFAULT_LAST_NAME);
		user.setEmail(Helper.generateRandomEmailAddress(70,DEFAULT_EMAIL_PREFIX,DEFAULT_EMAIL_PROVIDER));
		user.setConfirmPassword(DEFAULT_CONFIRMPASSWORD);
		user.setNectarNumber(DEFAULT_NECTAR_NUMBER);
		user.setPassword(DEFAULT_PASSWORD);
		user.setPostcode(DEFAULT_POSTCODE);
		return user;
	}
	
	
	public static User createRandomWrongPasswordUser() {
		User user = new User();
		user.setFirstName(DEFAULT_FIRST_NAME);
		user.setLastName(DEFAULT_LAST_NAME);
		user.setEmail(Helper.generateRandomEmailAddress(70,DEFAULT_EMAIL_PREFIX,DEFAULT_EMAIL_PROVIDER));
		user.setConfirmPassword(DEFAULT_CONFIRMPASSWORD ); //+ "hukeariue");
		user.setNectarNumber(DEFAULT_NECTAR_NUMBER);
		user.setPassword(DEFAULT_PASSWORD);
		user.setPostcode(DEFAULT_POSTCODE);
		return user;
	}
	
	
	
	
	
	
	
	public static class User {
		private String firstName ;
		private String lastName;
		private String email;
		private String password;
		private String confirmPassword;
		private String nectarNumber;
		private String postcode;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		
		public String getPostcode(){
			return postcode;
		}
		
		public void setPostcode(String postcode){
			this.postcode= postcode;
		}
		public String getNectarNumber() {
			return nectarNumber;
		}
		public void setNectarNumber(String nectarNumber) {
			this.nectarNumber = nectarNumber;
		}
		
		
	}

}
