package Com.smartshop2.Appium_SmartTests2.tests;

import java.util.List;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.MoreButtonsPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import io.appium.java_client.MobileElement;

public class TestEmptyListfromThreeDots extends TestBase{
	/**
	 * Test that user is able to delete the full list from Three dots.
	 */

	@Test
	public void emptylistfromthreedots(){
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
		ShoppingListPage shoppinglistpage=storeSelectorPage.selectStoreFromLogin(0);
		report("plan your shop","click on plan your shop");
		Searchpage searchpage =shoppinglistpage.clickPlanYourShop();
		delay();
		report("search","enter serah text as egg and click on add to list");
		searchpage.setSearchText("egg");
		searchpage.clickAddtoList();
		delay();
		report("back","click back button and go to shopping list");
		ShoppingListPage shoppinglistpage1=searchpage.clickBackButton();
		report("Empty","empty the shopping list through three dots");
		MoreButtonsPage more =shoppinglistpage1.clickMoreButton(0);
		PopupPage popup =more.clickDeletefromList(0);
		ShoppingListPage shopping =popup.clickcancelButton();
		Boolean isListEmpty = false;
		while(!isListEmpty) {
			List <MobileElement> list =driver.findElementsById("com.sainsburys.ssa.qa:id/more_button");
			if(list.size() > 0 ){
				list.get(0).click();
				if ( list != null & list.size() > 0 ) { // we have items, list is not empty
					isListEmpty = false;
					System.out.println("Size = " + list.size() );	
					delay();
					List <MobileElement> items =driver.findElementsByClassName("android.widget.LinearLayout");
					items.get(0).click();
					driver.findElementById("dialog_button_confirm").click();
					delay();
				}else {
					isListEmpty = true;
				}
			}else {
				isListEmpty = true;
			}	
		}
	}
}


