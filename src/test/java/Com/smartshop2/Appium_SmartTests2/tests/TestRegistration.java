package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.helper.Scroller;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.RegistrationPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import Com.smartshop2.Appium_SmartTests2.providers.NewUserGenerator;
import Com.smartshop2.Appium_SmartTests2.providers.NewUserGenerator.User;

public class TestRegistration extends TestBase{
	/**
	 * Test that new user is able to registration from Home page.
	 */
	@Test
	public void testswipe() {
		report("swipe","swpie the screens");
		swipescreens();
		report("Home","click on signup button");
		Homepage homepage = new Homepage(driver);
		StoreSelectorPage storeSelectorPage= homepage.clicksignupButton();
		report("Store","select store from registration");
		RegistrationPage registrationPage = storeSelectorPage.selectStoreFromRegistration(0);
	//	RegistrationPage registrationPage = homepage.clicksignupButton();
		report("new Registration","create new registration and click signup");
		User user = NewUserGenerator.createRandomValidUser();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();
		String confirmPassword = user.getConfirmPassword();
		String nectarNumber = user.getNectarNumber();
		registrationPage.setFirstname(firstName);
		registrationPage.setLastName(lastName);
		registrationPage.setEmail(email);
		registrationPage.setPassword(password);
		registrationPage.setConfirmPassword(confirmPassword);
	//	registrationPage.setNectarCardNumber(nectarNumber);
		registrationPage.clickTermsCheckbox();
		Scroller scroller =new Scroller(driver);
		scroller.swipeUp();
	    registrationPage.signup();
		
	}

}
