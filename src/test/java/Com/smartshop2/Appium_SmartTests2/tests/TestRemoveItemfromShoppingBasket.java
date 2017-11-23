package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestRemoveItemfromShoppingBasket extends TestBase {
	
	@Test
	public void removeitemfromshoppingbasket(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		final String NUMBER= "01725773";
		report("swipe","swipe the screens");
		swipescreens();
		report("Home Page","click on home page login button");
		Homepage homepage = new Homepage(driver);
		LoginPage loginPage = homepage.clickLoginButton();
		report("Login","enter user with valid credentials");
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage = loginPage.clickSubmitButton();
		delay();
		report("store","select the particular store");
		ShoppingListPage shoppinglistpage=storeSelectorPage.selectStoreFromLogin(0);
		report("Startshopping","click on shop in store");
		PopupPage page =shoppinglistpage.clickshopstore();
		AllowCamera();
		Shopinstorepage store =page.clickokButton();
		Wifi();
		report("scan","click scanbutton");
		ScanPage scan =store.clickItemscanButton();
		AllowCamera();
		report("Bracode","enter barcode and click on find button");
		scan.clickBarcodeManually();
		scan.setBarcode(NUMBER);
		scan.clickFindButton();
		report("back","user is on shopinstore");
		Shopinstorepage shop =scan.clickBackButton();
		report("moreButtons","click on morebuttons");
		shop.clickMoreButton(0);
		PopupPage page1 =new PopupPage(driver);
		ScanPage scan1 =page1.clickRemove1fromtrolley();
		report("Bracode","enter barcode and click on find button");
		scan1.clickBarcodeManually();
		scan1.setBarcode(NUMBER);
		PopupPage page2 =scan1.clickfindButton();
		report("scanremove","click on scanremove PopUP remove Button");
		Shopinstorepage shop1 =page2.clickScanremoveButton();
		report("shoppinglistpage","user is on shoppingListpage");
		ShoppingListPage shopping =shop1.clickBackButton();
	}

}
