package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.NecterPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestProductNotFound extends TestBase{
	
	/**
	 * Test that user is able test product not found through shopping list and shop in store 
	 */
	@Test
	public void productnotfound(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		final String NUMBER= "5054014691995";
	    report("swipe","swipe the screens");
		swipescreens();
		report("Home Page","click on Home login button");
		Homepage homepage = new Homepage(driver);
		report("Login","enter user with valid credentials");
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeselectorPage = loginPage.clickSubmitButton();
		delay();
		report("store","select particular store");
		ShoppingListPage shop=storeselectorPage.selectStoreFromLogin(0);
		report("plan your shop","click on plan your shop and your are serachpage");
		Searchpage search =shop.clickPlanYourShop();
		report("scan","enterbarcode and click on find button");
		ScanPage scan =search.clickScanButton();
	   //AllowCamera();
		scan.clickScannerOf();
		scan.setBarcode(NUMBER);
		hideKeyboard();
		PopupPage page =scan.clickfindButton();
		report("item not found","click on item not found ok button");
		ScanPage scan1 =page.clickitemnotfoundokButton();
		hideKeyboard();
		report("backbutton","user in serachpage");
		Searchpage search1 =scan1.clickbackbutton();
		report("ShoppingListPage","user in shopping list page");
		ShoppingListPage shopping =search1.clickBackButton();
		report("startshopping","click on shop in store");
		PopupPage pop=shopping.clickshopstore();
		AllowCamera();
		Shopinstorepage shopping1 =pop.clickokButton();
	//	Wifi();
		report("scan page","click on scan button");
		ScanPage scan2 =shopping1.clickItemscanButton();
		report("scan","enterbarcode and click on find button");
		scan2.setBarcode(NUMBER);
		hideKeyboard();
		PopupPage page1 =scan2.clickfindButton();
		ScanPage scan3 =page1.clickitemnotfoundokButton();
		report("backbutton","user is on shopping list page");
		Shopinstorepage store =scan3.clickBackButton();
		ShoppingListPage shop1 =store.clickBackButton();
		
		
	}

}
