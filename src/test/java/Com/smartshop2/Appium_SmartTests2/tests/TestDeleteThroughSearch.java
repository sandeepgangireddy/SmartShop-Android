package Com.smartshop2.Appium_SmartTests2.tests;

import java.util.List;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.MenuPage;
import Com.smartshop2.Appium_SmartTests2.pages.MoreButtonsPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.ProductListPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

public class TestDeleteThroughSearch extends TestBase {
	/**
	 * Test that user is able to search and  add and delete items from the product list
	 */
	@Test
    public void testsearch(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
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
		ShoppingListPage shoppingListPage = storeSelectorPage.selectStoreFromLogin(0);
/*		Boolean isListEmpty = false;
		while(!isListEmpty) {
			List <MobileElement> list = driver.findElementsByClassName("android.widget.LinearLayout"); // list of items in the screen 
			if ( list != null & list.size() > 0 ) { // we have items, list is not empty
				isListEmpty = false;
				System.out.println("Size = " + list.size() );
				// remove one item 
				list.get(0).swipe(SwipeElementDirection.LEFT, 100, 100, 3000);
				delay();
				driver.findElementById("dialog_button_confirm").click();
				delay(); 
			} else {
				isListEmpty = true;
			}
		} */
		report("plan your shop","click on plan your shop");
		Searchpage search=shoppingListPage.clickPlanYourShop();
		report("Search","set text as milk and clik addtolist button");
		search.setSearchText("milk");
		search.clickAddtoList();
		report("Back","click back button now you are on shopping list page");
		ShoppingListPage shoplist =search.clickBackButton();
		report("moreButton","click on three dots more button index 0");
		MoreButtonsPage more =shoplist.clickMoreButton(0);
		report("Search product","click on search for product");
		ProductListPage product =more.clickSearchforProduct(1);
		report("Add Button","click add button 4 times");
		for(int i=0; i<4;i++)
	    {
	    product.clickAddButton(0);
	    }
		report("remove Button","click add button 4 times");
		for(int i=0;i<4;i++)
		{
	    product.clickRemoveButton(0);
		}
		report("PopUp","confirm popup delete button");
		PopupPage popup =new PopupPage(driver);
		ProductListPage product1 =popup.clickdeleteButton();
		product1.clickBackButtonfromproductlist();
	}

}
