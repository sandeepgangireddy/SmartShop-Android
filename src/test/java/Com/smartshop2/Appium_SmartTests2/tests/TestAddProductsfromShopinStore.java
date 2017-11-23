package Com.smartshop2.Appium_SmartTests2.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestAddProductsfromShopinStore extends TestBase{
	@Test
	public void addproductsfromshopinstore() throws IOException{
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		report("swipe","swipe the screens");
		swipescreens();
		report("Home","click on login button");
		Homepage homepage = new Homepage(driver);
		report("Login","login with valid credentails");
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage = loginPage.clickSubmitButton();
		delay();
		report("store","select the particular store");
		ShoppingListPage shoppingListPage = storeSelectorPage.selectStoreFromLogin(0);
		report("start shopping","click on start shopping");
		PopupPage page =shoppingListPage.clickshopstore();
		report("camera","Handling the android native camera");
		AllowCamera();
		Shopinstorepage shopinstore= page.clickokButton();
		Wifi();
		report("scan","clin on scan icon button");
		ScanPage scanpage = shopinstore.clickItemscanButton();
		// Handling the new pop for new version	
		AllowCamera();
	
		
	}

}
