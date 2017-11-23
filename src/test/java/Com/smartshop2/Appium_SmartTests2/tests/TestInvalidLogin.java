package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;

public class TestInvalidLogin extends TestBase {
	/**
	 * Test that user is unable to login with invalid details and handle pop up message.
	 */
	@Test
	public void tetsinvalidlogin(){
		final String USERNAME="staging0684@gmx.com";
		final String INVALIDPASSWORD= "Test1234";
		report("Swipe", "swipe the screens");
		swipescreens();
		report("Home", "click on login button");
		Homepage homepage = new Homepage(driver);
		report("Login", "login with invalid credentials");
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(INVALIDPASSWORD);
		PopupPage page=loginPage.clickLoginButton();
		report("Popup","Handling the popupokbutton");
	    LoginPage login=page.clickpopokButton();
	}

}
