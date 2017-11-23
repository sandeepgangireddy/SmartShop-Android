package Com.smartshop2.Appium_SmartTests2.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LocationPage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestThinkTwentyFive extends TestBase{
	
	/**
	 * Test the user with Location verification
	 * Test that user is able to add think 25 products and handling the pop up.
	 */
	@Test
	public void thinktwentyfive() throws IOException{
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		final String NUMBER ="3029440000408"; // alcohal bar code
		report("swipe","swipe the screens");
		swipescreens(); 
		report("HomePage","clik on login button");
		Homepage homepage = new Homepage(driver);
		report("Login","enter the user with valid credentials");
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage = loginPage.clickSubmitButton();
		delay();
		report("Store","select particuler store");
		ShoppingListPage shoppingListPage = storeSelectorPage.selectStoreFromLogin(1);
		report("Star shopping","click on start shopping");
		PopupPage page =shoppingListPage.clickshopstore();
		DenyLocation();
		LocationPage location =new LocationPage(driver);
		ShoppingListPage shopper =location.clickCancelButton();
		PopupPage poppage =shopper.clickshopstore();
		AllowCamera();
		Shopinstorepage shopinstore=poppage.clickokButton();
		report("scan","click on scan icon");
		Wifi();
		ScanPage scanpage = shopinstore.clickItemscanButton();
		// Handling the new pop for new version	
		report("barcode","enter alcohol barcode and click find button");
		scanpage.clickScannerOf();
		scanpage.setBarcode(NUMBER);
		hideKeyboard();
		 PopupPage page1 =scanpage.clickfindButton();
		 report("Think25","click on thnk25 ok button");
		ScanPage scan = page1.clickThink25OkButton();
		report("back","user in shopinstore page");
		Shopinstorepage shopping =scan.clickBackButton();
		report("cancelshop","click 3 dots and handele popup confimation");
		PopupPage popup2 =shopping.clickThreeDots();
		PopupPage popup3 = popup2.clickCancelShopfromthreedots();
		ShoppingListPage shop1 =popup3.clickcancelShop();
    	delay(); 
		
	/*	scanpage.setBarcodeToShopinstore("3029440000408",USERNAME,PASSWORD);
		delay();
		Shopinstorepage shopinstore1 = scanpage.clickBackButton();
		PopupPage popup =new PopupPage(driver);
		Shopinstorepage shop =popup.clickThink25OkButton();
		PopupPage popup2 =shopinstore1.clickThreeDots();
		delay();
		PopupPage popup3 = popup2.clickCancelShopfromthreedots();
		ShoppingListPage shop1 =popup3.clickcancelShop();
    	delay(); */
	}

}
