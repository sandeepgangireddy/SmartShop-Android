package Com.smartshop2.Appium_SmartTests2.tests;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

public class TestDeletefromShopinstore extends TestBase{
	
	/**
	 * Test that user is able to delete the list from shop in store.
	 */
  @Test
  public void deletfromshopinstore() throws IOException{
	  final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		swipescreens();
		Homepage homepage = new Homepage(driver);
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage = loginPage.clickSubmitButton();
		delay();
		ShoppingListPage shoppingListPage = storeSelectorPage.selectStoreFromLogin(0);
		PopupPage page =shoppingListPage.clickshopstore();
		AllowCamera();
		Shopinstorepage shopinstore= page.clickokButton();
		delay();
		ScanPage scanpage = shopinstore.clickItemscanButton();
		// Handling the new pop for new version	
		scanpage.clickScannerOf();
		scanpage.setBarcode("01725773");
		hideKeyboard();
		scanpage.clickfindButton();
		clear();
		scanpage.setBarcode("01773255");
		hideKeyboard();
		scanpage.clickfindButton();
	//	scanpage.setBarcode("01725773",USERNAME,PASSWORD);
	//	delay();
		Shopinstorepage shopinstore1 = scanpage.clickBackButton();
		Boolean isListEmpty = false;
		while(!isListEmpty) {
			List <MobileElement> list = driver.findElementsById("product_main"); // list of items in the screen 
			if ( list != null & list.size() > 0 ) { // we have items, list is not empty
				isListEmpty = false;
				System.out.println("Size = " + list.size() );
				// remove one item 
				list.get(0).swipe(SwipeElementDirection.LEFT, 100, 100, 3000);
				delay();
				ScanPage scan = new ScanPage(driver);
				scan.setBarcode("01725773");
				hideKeyboard();
				scan.clickfindButton();
			} else {
				isListEmpty = true;
			} 
		} 
  }
}
