package Com.smartshop2.Appium_SmartTests2.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;


public class TestAddParacetemolTablets extends TestBase {
	
	/**
	 * Test that user is able to add paracetemol tablets with message verified
	 * Test the user invalid Barcode
	 * @throws IOException 
	 */
	@Test
	public void Testaddparacetemol () throws IOException{
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		final String PARACETEMOL="5000347045219";
		final String INVALIDBARCODE="6105217653";
		swipescreens();
		Homepage home =new Homepage(driver);
		LoginPage login =home.clickLoginButton();
		login.setEmail(USERNAME);
		login.setPassword(PASSWORD);
		StoreSelectorPage store =login.clickSubmitButton();
		delay();
		ShoppingListPage shopping =store.selectStoreFromLogin(0);
		delay();
		PopupPage popup =shopping.clickshopstore();
		AllowCamera();
		Shopinstorepage storepage =popup.clickokButton();
		Wifi();
		ScanPage scan =storepage.clickItemscanButton();
		scan.clickScannerOf();
		scan.setBarcode(INVALIDBARCODE);
		hideKeyboard();
		scan.clickfindButton();
		PopupPage pop =new PopupPage(driver);
		ScanPage scanner =pop.clickInvalidBarcodeOkButton();
		clear();
		scanner.setBarcode(PARACETEMOL);
		hideKeyboard();
		PopupPage popup1 =scanner.clickfindButton();
		Assert.assertTrue(popup1.assert_paracetemolmessage());
		ScanPage scan1 =popup1.clickparacetemolokButton();
		Shopinstorepage shop =scan1.clickBackButton();
		PopupPage page =shop.clickThreeDots();
		delay();
		PopupPage page2 =page.clickCancelShopfromthreedots();
		report("Shopping List Page","you will be on shopping list page");
		ShoppingListPage shop1 =page2.clickcancelShop();
		delay();
		
	}

}
