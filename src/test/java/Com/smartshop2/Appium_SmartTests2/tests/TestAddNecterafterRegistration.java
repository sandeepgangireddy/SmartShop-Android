package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.helper.Scroller;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.NecterPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.RegisterInterestPage;
import Com.smartshop2.Appium_SmartTests2.pages.RegistrationPage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import Com.smartshop2.Appium_SmartTests2.providers.NewUserGenerator;
import Com.smartshop2.Appium_SmartTests2.providers.NewUserGenerator.User;

public class TestAddNecterafterRegistration extends TestBase{
	/**
	 * user is able to click signup link from login page
	 * Test that user is able to add Nectercard details after registration.
	 */
	@Test
	public void necterafterRegistration(){
		report("swipe","swipe the screens");
		swipescreens();
		Homepage homepage = new Homepage(driver);
		report("Home","click on login button");
	    LoginPage page =homepage.clickLoginButton();
	    report("Regsiterlink","click on sign up or register link");
	    RegisterInterestPage register = page.clickRegisterinterestlink();
	    LoginPage page1= register.clickRegisterinterestBackButton();
	    report("Home","click on signup button");
	    Homepage homepage1= page1.clickLoginBackButton();
		StoreSelectorPage storeSelectorPage= homepage1.clicksignupButton();
		report("store","select particular store");
		RegistrationPage registrationPage = storeSelectorPage.selectStoreFromRegistration(0);
	//	RegistrationPage registrationPage = homepage.clicksignupButton();
		report("new user","enter new user details");
		User user = NewUserGenerator.createRandomValidUser();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String password = user.getPassword();
		String confirmPassword = user.getConfirmPassword();
	//	String nectarNumber = user.getNectarNumber();
		registrationPage.setFirstname(firstName);
		registrationPage.setLastName(lastName);
		registrationPage.setEmail(email);
		registrationPage.setPassword(password);
		registrationPage.setConfirmPassword(confirmPassword);
	//	registrationPage.setNectarCardNumber(nectarNumber);
		registrationPage.clickTermsCheckbox();
		Scroller scroller =new Scroller(driver);
		scroller.swipeUp();
		PopupPage pop= registrationPage.clicksignupnecterpopup();
		report("Popup","Handling necter popup notnow button");
		ShoppingListPage shop =pop.clicknotnowButton();
		report("startshopping","click on start shopping");
	    NecterPage necter= shop.clickShopinStore();
	    report("Necter card","set necter card details");
	//    necter.setNectercardnumber("12015917017");
	    AllowCamera();
	    report("CanceButton","you should be shoppinglist page");
	    ShoppingListPage shop1= necter.clickcancelButton() ;
	    NecterPage necterpage= shop1.clickShopinStore();
	    necterpage.setNectercardnumber("12015917017");
	    report("add nectercard","click on add nectercard button");
	    necter.clickaddcard();
	}

}
