package Com.smartshop2.Appium_SmartTests2.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoadingMessagesPage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;



public class TestLoadingMessages extends TestBase{
	
	private static final String MESSAGE1 = "From time to time we carry out random trolley rescans.";
	private static final String MESSAGE2 = "Use Sainsbury's Wi-Fi when you shop in store to save on your data costs.";
	private static final String MESSAGE3 = "SmartShop checkouts are card only";
	
	@Test
	public void loadingmessages(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		swipescreens();
		Homepage homepage = new Homepage(driver);
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage = loginPage.clickSubmitButton();
		delay();
		ShoppingListPage shoppinglistpage =storeSelectorPage.selectStoreFromLogin(0);
		PopupPage page =shoppinglistpage.clickshopstore();
		AllowCamera();
		page.clickokButton();
	    LoadingMessagesPage loading =new LoadingMessagesPage(driver);
	    String message = loading.getMessage();
	    Assert.assertTrue(message.equals(MESSAGE1) || message.equals(MESSAGE2) || message.equals(MESSAGE3));
	    delay();
	    Shopinstorepage store =new Shopinstorepage(driver);
	    store.clickBackButton();
	   
	}

}
