package Com.smartshop2.Appium_SmartTests2.tests;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.helper.CSVFileReader;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import Com.smartshop2.Appium_SmartTests2.helper.User;

public class TestLogin extends TestBase{
	/**
	 * Test that user is able to successfully login from login page and select particular store
	 */
	@Test
	public void testswipe() {
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		report("Swipe", "swipe the screens");
		swipescreens();
		report("Home", "click on login button");
		Homepage homepage = new Homepage(driver);
		Assert.assertTrue(homepage. assert_homepagelogin());
		report("Login", "login with valid detsils");
		LoginPage loginPage = homepage.clickLoginButton();
		Assert.assertTrue(loginPage.assert_loginpage());
		Assert.assertTrue(loginPage.assert_eyeicon());
	/*	List<User> userList = CSVFileReader.getUserdetails();
		if(userList!=null && !userList.isEmpty()){
			for (int i = 0; i < userList.size(); i++) {
				User user = userList.get(i);
				loginPage.setEmail(user.getUserName());
				loginPage.setPassword(user.getPassword());
				StoreSelectorPage StoreSelectorPage = loginPage.clickSubmitButton();
				delay();
				report("store", "select the particular store");
				Assert.assertTrue(StoreSelectorPage.assert_yourstores());
				ShoppingListPage shoppingListPage = StoreSelectorPage.selectStoreFromLogin(0);
			}
		} */
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage StoreSelectorPage = loginPage.clickSubmitButton();
		delay();
		report("store", "select the particular store");
	//	Assert.assertTrue(StoreSelectorPage.assert_yourstores());
		ShoppingListPage shoppingListPage = StoreSelectorPage.selectStoreFromLogin(0);
		
	}

}
