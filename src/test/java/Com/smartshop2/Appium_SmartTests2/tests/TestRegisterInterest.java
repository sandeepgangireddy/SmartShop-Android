package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.RegisterInterestPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import Com.smartshop2.Appium_SmartTests2.providers.NewUserGenerator;
import Com.smartshop2.Appium_SmartTests2.providers.NewUserGenerator.User;

public class TestRegisterInterest extends TestBase{
	/**
	 * Test that new user able to register from registration of interest.
	 */
	@Test
	public void registerinterest(){
		report("swipe","swipw the screens");
		swipescreens();
		report("Home","click on signup button");
		Homepage page = new Homepage(driver);
		StoreSelectorPage store =page.clicksignupButton();
		report("registration interest","click on registration interest");
		RegisterInterestPage register =store.cickregisterinterest();
		report("new Registration","create new registration and click signup");
		User user = NewUserGenerator.createRandomValidUser();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String postcode= user.getPostcode();
		register.setFirstname(firstName);
		register.setLastName(lastName);
		register.setEmail(email);
		register.setPostCode(postcode);
	    PopupPage pop =register.clicksubmitButton();
	    report("HomePage","you will be on Home Page");
	    Homepage home= pop.clickRegisterIntokButton();
		
		
		
		
	}
}
