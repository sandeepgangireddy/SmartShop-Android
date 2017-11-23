package Com.smartshop2.Appium_SmartTests2.tests;

import org.openqa.selenium.SearchContext;
import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.ProductListPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestCreateShoppingList extends TestBase {
	/**
	 * Test that user is able to search and add products to shoppling list
	 */
	@Test
	public void createshoppinglist(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		report("swipe","swipe the screens");
		swipescreens();
		report("Home page","click on login button");
		Homepage homepage = new Homepage(driver);
		LoginPage loginPage= homepage.clickLoginButton();
		report("Login","enter user with valid credentials");
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage =loginPage.clickSubmitButton();
		delay();
		report("store","select particular store");
		ShoppingListPage shoppingListPage =storeSelectorPage.selectStoreFromLogin(0);
		delay();
		report("plan shop","select plan your shop");
		Searchpage searchpage= shoppingListPage.clickPlanYourShop();
		report("search","search the text with eggs");
		searchpage.setSearchText("eggs");
		report("product List Page", " add product 3 times");
	    ProductListPage productListPage = searchpage.clickSearchButton();
	    for(int i=0;i<3;i++)
	    {
	    	productListPage.clickAddButton(2);
	    }
	    report("Shopping List","Come back to shopping list page");
	    Searchpage search =productListPage.clickBackButton();
	    delay();
	    search.clickBackButton();
	    delay();
	}


}
