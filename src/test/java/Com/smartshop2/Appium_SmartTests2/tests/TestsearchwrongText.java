package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import Com.smartshop2.Appium_SmartTests2.pages.WrongTexttPage;
import org.junit.Assert;

public class TestsearchwrongText extends TestBase{
	/**
	 * Test that user serach for any wrong text and verify the item could not found
	 * and test to clear the text on search box
	 */
	@Test
	public void searchwrongtext(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		final String WRONGTEXT ="cbcwcygg339";
		report("swipe", "swipe the screens");
		swipescreens();
		report("Home","click on login button");
		Homepage homepage = new Homepage(driver);
		report("Login","enter valid login credentials");
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage = loginPage.clickSubmitButton();
		delay();
		report("store","click on particular store");
		ShoppingListPage shoppingListPage = storeSelectorPage.selectStoreFromLogin(0);
		report("plan your Shop","clik on plan your shop ");
		Searchpage search=shoppingListPage.clickPlanYourShop();
		report("setText","set any wrong text and click search button");
		search.setSearchText( WRONGTEXT);
	    search.clickSearchcloseButton();
	    search.setSearchText( WRONGTEXT);
		WrongTexttPage wrong=search.clicksearchbutton();
		report("Verify","Verify the wrong text is present or not");
        Assert.assertTrue(wrong.assert_wrongText());
		
	}

}
