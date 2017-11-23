package Com.smartshop2.Appium_SmartTests2.tests;

import java.util.Random;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.helper.Scroller;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.RegistrationPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import Com.smartshop2.Appium_SmartTests2.pages.TermsPage;
import Com.smartshop2.Appium_SmartTests2.providers.NewUserGenerator;
import Com.smartshop2.Appium_SmartTests2.providers.NewUserGenerator.User;

public class TestEmailAddressAlredyRegistered extends TestBase{
	
	/**
	 * Verify the user when registered email already exists and check terms and conditions Page
	 * Nectercard already used
	 */
	@Test
	public void emailaddressalreadyregistered(){
		swipescreens();
		Homepage home =new Homepage(driver);
		StoreSelectorPage store =home.clicksignupButton();
		RegistrationPage register =store.selectStoreFromRegistration(0);
		register.setFirstname("SMART");
		register.setLastName("SHOP");
		register.setEmail("Smart123@gmail.com");
		register.setPassword("sainsburys");
		register.setConfirmPassword("sainsburyss");
		Scroller scroller =new Scroller(driver);
		scroller.swipeUp();
	//	TermsPage term =register.clicktermtext();
	//	RegistrationPage reg =term.clickBackButton();
		register.clickTermsCheckbox();
		PopupPage pop =register.clicksignupnecterpopup();
		pop.clicknotNowButton();
		delay();
		RegistrationPage reg1 =pop.clickemailexitsokButton();
		Scroller scroller1 =new Scroller(driver);
		scroller1.swipeDown();
		User user = NewUserGenerator.createRandomValidUser();
		String email = user.getEmail();
		reg1.setEmail(email);
		Scroller scroller3 =new Scroller(driver);
		scroller3.swipeUp();
		reg1.setNectarCardNumber("12015917017");
		PopupPage pop1 =reg1.clicksignupnecterpopup();
		RegistrationPage reg2 =pop1.clickNectercardalreadyokButton();
		
		
		
		
		
	}
}
