package Com.smartshop2.Appium_SmartTests2.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.ProductListPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestAddList extends TestBase {
	/**
	 * Test that user is able add products through quick tags,free text,search,scan to shopping list.
	 */
	@Test
	public void addlist() throws IOException{
		
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		report("swipe", "swipe the screens");
		swipescreens();
		report("Home","click on login button");
		Homepage homepage = new Homepage(driver);
		report("Login","enter valid login credentials");
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage = loginPage.clickSubmitButton();
		delay();
		report("store","click on particular store");
		ShoppingListPage shoppingListPage = storeSelectorPage.selectStoreFromLogin(0);
		report("plan your Shop","select quick tags");
		Searchpage search=shoppingListPage.clickPlanYourShop();
		search.clickNotSelectedTag(0);
		delay();
		search.clickNotSelectedTag(2);
		delay();
		search.clickSelectedTag(0);
		delay();
		report("Search","search for milk and add item");
		search.setSearchText("milk");
		delay();
		ProductListPage product =search.clickSearchButton();
		for(int i=0;i<4;i++){
			product.clickAddButton(1);
		}
		delay();
		product.clickBackButton();
		Searchpage searchpage =product.clickBackButton();
		
		report("scan","scan an item and add to basket");
		ScanPage scan =searchpage.clickScanButton();
	//	AllowCamera();
	/** This code is used when you don't have barcode manually */		
	/*	scan.setBarcodeToUserList("5034660521495","Mint", 1, USERNAME,PASSWORD);
		delay();
		Searchpage search1=scan.clickbackbutton();
		search1.setSearchText("Yogurt"); */
	//	 scan.clickBarcodeManually();
		 scan.clickScannerOf();
		 scan.setBarcode("01773255");
		 scan.clickFindButton();
		 report("FreeText","add free text");
		 Searchpage searchitem = scan.clickbackbutton();
		 searchitem.setSearchText("yougurt");
		 searchitem.clickAddtoList();
		 report("Shopping","after adding items come back to shopping list");
		 ShoppingListPage shopping= searchitem.clickBackButton();
		 delay();
		
	}

}
