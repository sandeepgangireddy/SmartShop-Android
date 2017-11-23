package Com.smartshop2.Appium_SmartTests2.tests;

import java.util.List;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

public class TestEmptyList extends TestBase {/**
	 * Test that user is able to delete the full list by swipping left.
	 */
	
	@Test
	public void emptylist(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
		report("swipe","swipe the screens");
		swipescreens();
		report("Home Page","click on homepage login button");
		Homepage homepage = new Homepage(driver);
		LoginPage loginPage = homepage.clickLoginButton();
		report("Login","enter user with valid credentials");
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeSelectorPage = loginPage.clickSubmitButton();
		delay();
		report("store","select particular store");
		ShoppingListPage shoppinglistpage=storeSelectorPage.selectStoreFromLogin(0);
		report("Pan your shop","click on plan your shop");
		Searchpage searchpage =shoppinglistpage.clickPlanYourShop();
		delay();
		report("serach","set text as egg and click addtolist");
		searchpage.setSearchText("egg");
		searchpage.clickAddtoList();
		delay();
		report("back","click backbutton now you  are on  shopping list page");
		ShoppingListPage shoppinglistpage1=searchpage.clickBackButton();
		report("Empty","empty the shopping list through swipe left");
	/*	PopupPage page =shoppinglistpage1.shoppinglistSwipeLeft(0);
		page.clickcancelButton(); */
		Boolean isListEmpty = false;
		while(!isListEmpty) {
			/** need to speak to developers to add id */
			List <MobileElement> list = driver.findElementsById("product_main");
				//	driver.findElementsById("list_item_product"); // list of items in the screen 
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
		}

	}

}
