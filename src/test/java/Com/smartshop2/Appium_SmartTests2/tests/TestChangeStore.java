package Com.smartshop2.Appium_SmartTests2.tests;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.ChangeStorePage;
import Com.smartshop2.Appium_SmartTests2.pages.Changestoreconfirmation;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.MenuPage;
import Com.smartshop2.Appium_SmartTests2.pages.Myaccountpage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;

public class TestChangeStore extends TestBase{
	/**
	 * Test that user is able to don't change the store and change the store
	 */
  @Test
  public void changestore(){
	  final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
			report("swipe","swipe the screens");
			swipescreens();
			report("Home","click on homelogin button");
			Homepage homepage = new Homepage(driver);
			report("Login","enter user with valid credentials");
			LoginPage loginPage = homepage.clickLoginButton();
			loginPage.setEmail(USERNAME);
			loginPage.setPassword(PASSWORD);
			StoreSelectorPage storeselectorPage = loginPage.clickSubmitButton();
			delay();
			report("store","select the particular store");
			ShoppingListPage shop=storeselectorPage.selectStoreFromLogin(1);
			report("Menu","click on settings button");
			MenuPage page=shop.clicksettingsButton();
			report("My account","click my account");
			Myaccountpage account =page.clickmyAccount(0);
			report("store","click on store icon");
			ChangeStorePage store =account.clickstoreicon();
			report("select store","click on particular store");
			Changestoreconfirmation confirm =store.clickonstoreselection(3);
			report("dontchangestore","click on dontchage store confirmation");
			ChangeStorePage store1 =confirm.clickdontchange();
			Changestoreconfirmation confirm1 =store1.clickonstoreselection(3);
			report("changestore","click on change store confirmation");
			ChangeStorePage change =confirm1.clickchangestore();
			report("Backbutton","click on back button now ur in shopping list page");
			ShoppingListPage shopping =change.clickbabkbutton();
			
			
			
  }
}
