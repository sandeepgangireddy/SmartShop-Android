package Com.smartshop2.Appium_SmartTests2.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.CheckOutPage;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestSample extends TestBase {
	
	@Test
	public void sample() throws IOException{
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
		Searchpage searchpage =shoppinglistpage.clickPlanYourShop();
		delay();
		searchpage.setSearchText("shop");
	//	delay();
		searchpage.clickAddtoList();
		ShoppingListPage shoppinglistpage1=searchpage.clickBackButton();
		PopupPage page =shoppinglistpage1.clickshopstore();
		// Handling the new pop for new version	
		AllowCamera();
		Shopinstorepage shopinstore= page.clickokButton();
		delay();
		ScanPage scanpage = shopinstore.clickItemscanButton();
		// Handling the new pop for new version	
		AllowCamera();
		//scanpage.clickBarcodeManually();
		scanpage.setBarcodeToShopinstore("01725773",USERNAME,PASSWORD);
		delay();
		Shopinstorepage shopinstore1 = scanpage.clickBackButton();
		CheckOutPage checkout =shopinstore1.clickcheckoutButton();
		checkout.clickScanQrCode(); 

		}

}
