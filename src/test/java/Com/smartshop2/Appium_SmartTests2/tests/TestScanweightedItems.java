package Com.smartshop2.Appium_SmartTests2.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestScanweightedItems extends TestBase{
	/**
	 * Test that user is able to add weighted items to shopping list and shop in store.
	 * and verify item price 
	 */

@Test

public void testscan () throws IOException{
	final String USERNAME="staging0684@gmx.com";
	final String PASSWORD ="Test1234x";
	final String BANANA ="2623322009964";
	report("swipe","swipe the screens");
	swipescreens();
	report("Home","click on login button");
	Homepage homepage = new Homepage(driver);
	report("Login","login with valid credentials");
    LoginPage loginPage =  homepage.clickLoginButton();
	loginPage.setEmail(USERNAME);
	loginPage.setPassword(PASSWORD);
	StoreSelectorPage storeSelectorPage=loginPage.clickSubmitButton();
	delay();
	report("store","select the particular store");
	ShoppingListPage shoppingListPage=storeSelectorPage.selectStoreFromLogin(1);
	delay();
	report("plan your shop","click on plan your shop");
	Searchpage searchpage=shoppingListPage.clickPlanYourShop();
	report("scan","select the scan icon button");
	ScanPage scanPage=searchpage.clickScanButton();
	// Handling the new pop for new version	
//	AllowCamera();
	report("Barcode","enter weighted item barcode manually and click find button");
	scanPage.clickScannerOf();
	scanPage.setBarcode(BANANA);
	hideKeyboard();
	scanPage.clickFindButton();
	scanPage.clickBackbutton();
	Searchpage search =new Searchpage(driver);
	report("Back","go back to shopping list page");
	ShoppingListPage shopping =search.clickBackButton();
	shopping.clickQuantity(0);
	for(int i=0;i<3;i++){
	shopping.clickaddButton(0);
	}
	for(int i=0;i<4;i++){
	shopping.clickremoveButton(0);
	}
	PopupPage pop =new PopupPage(driver);
	ShoppingListPage shopping1 =pop.clickDeleteButton();
	report("start shopping","select start shopping");
	PopupPage popup =shopping1.clickshopstore();
	AllowCamera();
	report("dontremian","click dont remain again");
	popup.clickdontremain();
	Shopinstorepage store =popup.clickokButton();
	report("scan","select scan item button from shop in store");
	Wifi();
    ScanPage scan =store.clickItemscanButton();
    report("Barcode","enter weighted item barcode manually and click find button");
    scan.clickScannerOf();
	scan.setBarcode(BANANA);
	hideKeyboard();
	scan.clickFindButton();
	report("back","go back to shop in store page");
	Shopinstorepage storepage = new Shopinstorepage(driver);
	report("Verfying","The expected price is present or not");
	Assert.assertTrue(storepage.assert_itemprice());
	report("Three dots","click three dots and click on cancel shop popup");
	PopupPage page =storepage.clickThreeDots();
	delay();
	PopupPage page2 =page.clickCancelShopfromthreedots();
	report("Shopping List Page","you will be on shopping list page");
	ShoppingListPage shop1 =page2.clickcancelShop();
	delay();
}

}
