package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.CheckOutPage;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanQrCodePage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestDeletefromCheckOut extends TestBase {
	/**
	 * Test delete the products from checkout page by clicking on three dots and swipe
	 * and cancel shop
	 */
	@Test
 public void deletefromcheckout(){
	final String USERNAME="staging0684@gmx.com";
	final String PASSWORD ="Test1234x";
	final String CHESSE ="01725773"; // Cheese 
	final String KIDS="01773255"; //kids Dipper
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
	AllowCamera();
	Shopinstorepage shopinstore= page.clickokButton();
	Wifi();
	report("scan","clin on scan icon button");
	ScanPage scanpage = shopinstore.clickItemscanButton();
	// Handling the new pop for new version	
//	AllowCamera();
	scanpage.clickScannerOf();
	clear();
	scanpage.setBarcode(CHESSE);
	hideKeyboard();
	scanpage.clickFindButton();
	clear();
	scanpage.setBarcode(KIDS);
	hideKeyboard();
	scanpage.clickFindButton();
	Shopinstorepage shop =scanpage.clickBackButton();
	CheckOutPage check =shop.clickcheckoutButton();
	check.clickMoreButton(0);
	PopupPage pop =new PopupPage(driver);
	ScanPage scan =pop.clickRemove1fromtrolley();
	scan.setBarcode(CHESSE);
	hideKeyboard();
	scan.clickfindButton();
	CheckOutPage checkout = new CheckOutPage(driver);
	ScanQrCodePage qrpage =checkout.clickScanQrCode();
	CheckOutPage outpage =qrpage.clickBackButton();
	PopupPage pop1 =outpage.clickThreeDots();
	delay();
	PopupPage page2 =pop1.clickCancelShopfromthreedots();
	report("Shopping List Page","you will be on shopping list page");
	ShoppingListPage shop1 =page2.clickcancelShop();
	delay();
/*	PopupPage popup2 =checkout.clickThreeDots();
	PopupPage popup3 = popup2.clickCancelShopfromthreedots();
	ShoppingListPage shop1 =popup3.clickcancelShop();
	delay() */
	}
}
