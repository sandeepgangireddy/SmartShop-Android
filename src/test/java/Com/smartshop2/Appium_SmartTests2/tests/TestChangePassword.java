package Com.smartshop2.Appium_SmartTests2.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.ChangepasswordPage;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.MenuPage;
import Com.smartshop2.Appium_SmartTests2.pages.Myaccountpage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestChangePassword extends TestBase{
	/**
	 * Test that user is able to change password
	 */
	@Test
	public void changepassword(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		report("swipe","swipe the screens");
		swipescreens();
		report("Home","click on login button");
		Homepage homepage = new Homepage(driver);
		LoginPage loginPage = homepage.clickLoginButton();
		report("Login","enter valid login details");
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeselectorPage = loginPage.clickSubmitButton();
		delay();
		report("store","select particular store");
		ShoppingListPage shop=storeselectorPage.selectStoreFromLogin(0);
		report("settings button","click on settings icon");
		MenuPage page=shop.clicksettingsButton();
		report("My account","select my account");
		Myaccountpage accountpage=page.clickmyAccount(0);
		report("change password","select change password");
		ChangepasswordPage password =accountpage.ClickChangePassword();
		report("password","enter existing password");
		password.setPassword("Test1234x");
		report("password","enter new password");
		password.setnewpassword("Test1234x");
		report("password","enter confirm password and save");
		password.setconfirmpassword("sainsbury");
		report("Error","password doesnot match");
		ChangepasswordPage change =password.clicksaveButton();
		change.setconfirmpassword("Test1234x");
		PopupPage pop =change.clicksavebutton();
		Myaccountpage account= pop.clickpasswordokbutton();
		report("Home page","should be on home page");
		Homepage home =account.clickbackbutton();
		Assert.assertTrue(homepage. assert_homepagelogin());
		
	}

}
