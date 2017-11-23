package Com.smartshop2.Appium_SmartTests2.tests;

import org.junit.Assert;

import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.helper.Helper;
import Com.smartshop2.Appium_SmartTests2.pages.AccessibilityPage;
import Com.smartshop2.Appium_SmartTests2.pages.ContactUsPage;
import Com.smartshop2.Appium_SmartTests2.pages.FaqsPage;
import Com.smartshop2.Appium_SmartTests2.pages.HelpPage;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.MenuPage;
import Com.smartshop2.Appium_SmartTests2.pages.Myaccountpage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.PrivacyPolicy;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import Com.smartshop2.Appium_SmartTests2.pages.TermsandConditionsPage;
import Com.smartshop2.Appium_SmartTests2.pages.UserguidePage;

public class TestMenu extends TestBase {
	
	/**
	 * Test that user is able click on all menu lists and verify whether the pages
	 * and logout.
	 */
   @Test
   public void menu (){
	   final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1234x";
	    report("swipe","swipe the screens");
		swipescreens();
		report("Home Page","click on Home login button");
		Homepage homepage = new Homepage(driver);
		report("Login","enter user with valid credentials");
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage storeselectorPage = loginPage.clickSubmitButton();
		delay();
		report("store","select particular store");
		ShoppingListPage shop=storeselectorPage.selectStoreFromLogin(0);
		report("settings","click on setting icon");
		MenuPage page=shop.clicksettingsButton();
		report("My account","click on My account");
		Myaccountpage accountpage=page.clickmyAccount(0);
		report("back","click back and come to shopping list page");
		ShoppingListPage shop1 =accountpage.clickBackButton();
		report("settings","click on setting icon");
		MenuPage page1 =shop1.clicksettingsButton();
		report("Help","clicks on help");
		HelpPage help =page1.clickmyHelp(1);
		report("userguide","clicks on userguide");
		UserguidePage guide =help.clickquickguide();
		report("Verify","Verify the page is present or not");
	Assert.assertTrue(guide.assert_title());
		report("backbutton","user is on helppage");
		HelpPage help1 =guide.clickUserguideBackButton();
		report("Faqs","click on Faqs Button");
		FaqsPage faq =help1.clickFaqsButton();
		report("backbutton","user is on helppage");
		HelpPage help2 =faq.clickFaqsBackButton();
		report("Termsandconditiond","user clicks on terms and condtions");
		TermsandConditionsPage term =help2.clickTermsandConditions();
		report("backbutton","user is on helppage");
		HelpPage help3 =term.clickTermsandConditionsBackButton();
		PrivacyPolicy privacy =help3.clickPrivacyPolicy();
		report("backbutton","user is on helppage");
		HelpPage help4 =privacy.clickPrivacyPolicyBackButton();
		report("accessibility","user cliks accessibility button");
		AccessibilityPage access=help4.clickAcessStatement();
		report("backbutton","user is on helppage");
		HelpPage help5 =access.clickAccessibilityBackButton();
		report("backbutton","user is on shoppinglistapge");
		ShoppingListPage shoping =help5.clickHelpBackButton();
		report("settings","click on setting icon");
		MenuPage page2 =shoping.clicksettingsButton();
		report("Logout","click logout button and handle popup cancel button");
	    PopupPage popup=	page2.clicklogout(2);
	    report("shoppinglist page","now you are on shopping list page");
	    ShoppingListPage shopping= popup.clickcancellogoutbutton();
	    report("settings","click on setting icon");
	    MenuPage page4 = shopping.clicksettingsButton();
	    report("Logout","click logout button and handle popup ok button");
	    PopupPage popuppage=	page4.clicklogout(2);
	    Homepage homepage1=  popuppage.clickPopmenulogoutokButton();
	    report("Verify","Verify the user in homepage");
	  Assert.assertTrue(homepage. assert_homepagelogin());
   }

}
