package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.MoreButtonsPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ProductListPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestDeletefromProductList extends TestBase {
	/**
	 * Test that user is able to add free text and search for product
	 * and add and delete the items
	 */
	@Test
	public void testdelete(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		report("swipe","swipe the screens");
		swipescreens();
		report("Home page","click on login button");
		Homepage homepage = new Homepage(driver);
		report("Login","enter with valid credentials");
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage = loginPage.clickSubmitButton();
		delay();
		report("store","select particular store");
		ShoppingListPage shoppingListPage = storeSelectorPage.selectStoreFromLogin(0);
		report("plan your shop","select plan your shop");
		Searchpage search=shoppingListPage.clickPlanYourShop();
		report("search","set text as egg and click add to list");
		search.setSearchText("egg");
		search.clickAddtoList();
		report("shopping ListPage","you are on shooping list page");
		ShoppingListPage shoplist =search.clickBackButton();
		report("moreButtons","click more buttons index 0");
		MoreButtonsPage more =shoplist.clickMoreButton(0);
		report("search for roduct","clicks on search for product");
		ProductListPage product =more.clickSearchforProduct(1);
		report("add product","add product for 4 times");
		for(int i=0; i<4;i++)
	    {
	    product.clickAddButton(0);
	    }
		report("remove product","add product for 4 times");
		for(int i=0;i<4;i++)
		{
	    product.clickRemoveButton(0);
		}
		delay();
		report("popup Handling","Handling popup ok button");
		driver.findElementById("dialog_button_confirm").click();
		ProductListPage productlist = new ProductListPage(driver);
		report("Shopping List Page","again come back to shopping list page");
	    ShoppingListPage shop1=productlist.clickBackButtonfromproductlist();
	}

}
