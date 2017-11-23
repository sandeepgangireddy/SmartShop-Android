package Com.smartshop2.Appium_SmartTests2.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.AccessibilityPage;
import Com.smartshop2.Appium_SmartTests2.pages.ChangeStorePage;
import Com.smartshop2.Appium_SmartTests2.pages.ChangepasswordPage;
import Com.smartshop2.Appium_SmartTests2.pages.Changestoreconfirmation;
import Com.smartshop2.Appium_SmartTests2.pages.CheckOutPage;
import Com.smartshop2.Appium_SmartTests2.pages.FaqsPage;
import Com.smartshop2.Appium_SmartTests2.pages.HelpPage;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoadingMessagesPage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.MenuPage;
import Com.smartshop2.Appium_SmartTests2.pages.MoreButtonsPage;
import Com.smartshop2.Appium_SmartTests2.pages.Myaccountpage;
import Com.smartshop2.Appium_SmartTests2.pages.NecterPage;
import Com.smartshop2.Appium_SmartTests2.pages.PopupPage;
import Com.smartshop2.Appium_SmartTests2.pages.PrivacyPolicy;
import Com.smartshop2.Appium_SmartTests2.pages.ProductListPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanPage;
import Com.smartshop2.Appium_SmartTests2.pages.ScanQrCodePage;
import Com.smartshop2.Appium_SmartTests2.pages.Searchpage;
import Com.smartshop2.Appium_SmartTests2.pages.Shopinstorepage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import Com.smartshop2.Appium_SmartTests2.pages.TermsandConditionsPage;
import Com.smartshop2.Appium_SmartTests2.pages.UserguidePage;
import Com.smartshop2.Appium_SmartTests2.pages.WrongTexttPage;
import Com.smartshop2.Appium_SmartTests2.pages.emailsentpage;
import Com.smartshop2.Appium_SmartTests2.pages.forgottenpasswordpage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

public class TestRegressionLogin extends TestBase{

	/**
	 * ForgottenPassword,Minpassword Errormessage,InvalidLogin,validLogin
	 * AddList quicktags,freeText,search,scan
	 * Setting menu list,myaccount,storeselector,changepassword.
	 * emptylist by swipping,delete list by from three dots,search for product from three dots.
	 * startshopping,add products and delete from shopinstore,cancelshop.
	 * add weighted items,think 25items,,paracetemol,wrongtext,hanlind worngbarcode,
	 * delete from checkout,remove one from trolley cancelshopfrom checkout.
	 * 
	 */
	@Test
	public void regressionlogin(){
		final String USERNAME="issa10@sainsburys.co.uk";
		final String MINPASSWORD ="sains";
		final String INVALIDPASSWORD= "sainsbury";
		final String PASSWORD ="Test1234x";
		final String CHEESEBARCODE="01773255";
		final String WRONGTEXT ="cbcwcygg339";
		final String BANANA ="2623322009964";
		final String PARACETEMOL="5000347045219";
		final String INVALIDBARCODE="6105217653";
		final String ALCOHOLNUMBER ="3029440000408";
		final String KIDSDiPPER="01773255";
	    final String MESSAGE1 = "From time to time we carry out random trolley rescans.";
		final String MESSAGE2 = "Use Sainsbury's Wi-Fi when you shop in store to save on your data costs.";
		final String MESSAGE3 = "SmartShop checkouts are card only";
		String actual_error ="";
		String Expected_error = "Your password must be at least 8 characters and can't contain spaces";
		report("swipe","swipe the screens");
		swipescreens();
		//Forgot Password test
		report("Home","click on home login button");
		Homepage home = new Homepage(driver);
		report("Login","enter user with only user name ");
		LoginPage login =home.clickLoginButton();
		login.setEmail(USERNAME);
		forgottenpasswordpage forgot=login.clickforgotpassword();
		forgot.setEmail(USERNAME);
		emailsentpage email =forgot.clicksendButton();
		delay();
		report("error messsage","verify the message is present");
		String actual_message =driver.findElementById("success_message").getText();
		String expected_message ="We've sent an email to you so that you can reset your password.";
		Assert.assertEquals(actual_message, expected_message);
		//Min Password Error Message test
		LoginPage loginPage =email.clickEmailsentBackButton();
		loginPage.setPassword(MINPASSWORD);
		LoginPage page = loginPage.clicksubmitbutton();
		delay();
		report("Assert","Verified Error message is present");
		List<MobileElement> allDivs = driver.findElements(By.className("android.widget.TextView"));
		if(allDivs.size() >=4){
			MobileElement mobileElement = (MobileElement) allDivs.get(3);
			actual_error = mobileElement.getText();
		}
		Assert.assertEquals(actual_error, Expected_error);
		//Invalid Login test	
		page.setPassword(INVALIDPASSWORD);
		PopupPage poppage=page.clickLoginButton();
		report("Popup","Handling the popupokbutton");
		LoginPage  validlogin=poppage.clickpopokButton(); 
		//Valid Login test    
		validlogin.setPassword(PASSWORD);
		StoreSelectorPage StoreSelectorPage = validlogin.clickSubmitButton();
		delay();
		report("store", "select the particular store");
		ShoppingListPage shoppingListPage = StoreSelectorPage.selectStoreFromLogin(1);
		Searchpage search=shoppingListPage.clickPlanYourShop();
		// Test quick tags and deleselect
		search.clickNotSelectedTag(0);
		delay();
		search.clickNotSelectedTag(2);
		delay();
		search.clickSelectedTag(0);
		delay();
		//Test Search and products and delete products	
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
		//Test scan the products weighted item and other products	
		report("scan","scan an item and add to basket");
		ScanPage scan =searchpage.clickScanButton();
		scan.clickScannerOf();
		scan.setBarcode(BANANA);
		hideKeyboard();
		scan.clickFindButton();
		clear();
		//	 scan.clickBarcodeManually();
		scan.setBarcode(CHEESEBARCODE);
		hideKeyboard();
		scan.clickFindButton();
		report("FreeText","add free text");
		//Test free text and handling wrong test and verfifying	 
		Searchpage searchitem = scan.clickbackbutton();
		searchitem.setSearchText( WRONGTEXT);
		searchitem.clickSearchcloseButton();
		searchitem.setSearchText( WRONGTEXT);
		WrongTexttPage wrong=searchitem.clicksearchbutton();
		report("Verify","Verify the wrong text is present or not");
		Assert.assertTrue(wrong.assert_wrongText());
		wrong.clickwrongtextBackButton();
		Searchpage searchfree = wrong.clickwrongtextBackButton();
		//Test add quick tag and free text delete from three dots and search for products from three dots and add and delete products   
		searchfree.clickNotSelectedTag(0);
		searchfree.setSearchText("Egg");
		searchfree.clickAddtoList();
		report("Shopping","after adding items come back to shopping list");
		ShoppingListPage shopping= searchfree.clickBackButton();
		delay();
		MoreButtonsPage more =shopping.clickMoreButton(0);
		PopupPage delete =more.clickDeletefromList(0);
		ShoppingListPage shop= delete.clickDeleteButton();
		MoreButtonsPage more1 =shop.clickMoreButton(0);
		report("Search product","click on search for product");
		ProductListPage product1 =more1.clickSearchforProduct(1);
		report("Add Button","click add button 2 times");
		for(int i=0; i<2;i++)
		{
			product1.clickAddButton(0);
		}
		report("remove Button","click add button 2 times");
		for(int i=0;i<2;i++)
		{
			product1.clickRemoveButton(0);
		}
		report("PopUp","confirm popup delete button");
		PopupPage popup =new PopupPage(driver);
		delay();
		ProductListPage product2 =popup.clickdeleteButton();
		ShoppingListPage shopping2 =product2.clickBackButtonfromproductlist();
		//Test menu list help and my account, change password and change store
		MenuPage page2= shopping2.clicksettingsButton();
		report("My account","click on My account");
		Myaccountpage accountpage=page2.clickmyAccount(0);
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
		MenuPage menu=shoping.clicksettingsButton();
		Myaccountpage accountpage1=menu.clickmyAccount(0);
		report("change password","select change password");
		ChangepasswordPage password =accountpage.ClickChangePassword();
		report("password","enter existing password");
		password.setPassword("Test1234x");
		report("password","enter new password");
		password.setnewpassword("Test1234x");
		report("password","enter confirm password and save");
		password.setconfirmpassword("sainsbury");
		report("Error","password doesnot match");
		ChangepasswordPage change =password.clicksaveButton();
		change.setconfirmpassword("Test1234x");
		PopupPage pop =change.clicksavebutton();
		Myaccountpage account= pop.clickpasswordokbutton();
		report("store","click on store icon");
		ChangeStorePage store =account.clickstoreicon();
		report("select store","click on particular store");
		Changestoreconfirmation confirm =store.clickonstoreselection(3);
		report("dontchangestore","click on dontchage store confirmation");
		ChangeStorePage store1 =confirm.clickdontchange();
		Changestoreconfirmation confirm1 =store1.clickonstoreselection(3);
		report("changestore","click on change store confirmation");
		ChangeStorePage changestore =confirm1.clickchangestore();
		//Test login again when you change password and empty the shopping list	
		Homepage homepage  =changestore.clickBackButton();
		LoginPage loginpage =homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		StoreSelectorPage StoreSelector = loginPage.clickSubmitButton();
		delay();
		report("store", "select the particular store");
		ShoppingListPage shopper = StoreSelectorPage.selectStoreFromLogin(0);
		delay();
		Boolean isListEmpty = false;
		while(!isListEmpty) {
			List <MobileElement> list = driver.findElementsById("product_main"); // list of items in the screen 
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
		//Test shop in store add weighted items and verify the price	
		ShoppingListPage list =new ShoppingListPage(driver);
		PopupPage popok =list.clickshopstore();
		AllowCamera();
		Shopinstorepage storepage =popok.clickokButton();
		LoadingMessagesPage loading =new LoadingMessagesPage(driver);
	    String message = loading.getMessage();
	    Assert.assertTrue(message.equals(MESSAGE1) || message.equals(MESSAGE2) || message.equals(MESSAGE3));
		delay();
		delay();
		ScanPage scanner =storepage.clickItemscanButton();
		report("Barcode","enter weighted item barcode manually and click find button");
		scanner.setBarcode(BANANA);
		hideKeyboard();
		scanner.clickFindButton();
		report("back","go back to shop in store page");
		Shopinstorepage startshop1 =scanner.clickBackButton();
		report("Verfying","The expected price is present or not");
		Assert.assertTrue(storepage.assert_itemprice());
		//Test invalid barcode	
		ScanPage scanner5 =startshop1.clickItemscanButton();
		scanner5 .setBarcode(INVALIDBARCODE);
		hideKeyboard();
		scanner5 .clickfindButton();
		PopupPage popup5 =new PopupPage(driver);
		ScanPage scanner6 =popup5.clickInvalidBarcodeOkButton();
		//Test paracetemol and verify the message	
		clear();
		scanner6.setBarcode(PARACETEMOL);
		hideKeyboard();
		PopupPage popup7 =scanner6.clickfindButton();
		Assert.assertTrue(popup7.assert_paracetemolmessage());
		ScanPage scanner7 =popup7.clickparacetemolokButton();
		//Test Thiknk 25 product and verify the message
		clear();
		scanner7.setBarcode(ALCOHOLNUMBER);
		hideKeyboard();
		PopupPage popage =scanner7.clickfindButton();
		report("Think25","click on thnk25 ok button");
		ScanPage scanner8 = popage.clickThink25OkButton();
		//Test add products to shop in store and delete through swipe and remove from three dots through scanning	
		for(int i=0;i<2;i++){
			clear();
			scanner8.setBarcode(KIDSDiPPER);
			hideKeyboard();
			scanner8.clickfindButton();
		}
		for(int i=0;i<2;i++){
			clear();
			scanner8.setBarcode(CHEESEBARCODE);
			hideKeyboard();
			scanner8.clickfindButton();
		}
		Shopinstorepage startshop2 =scanner8.clickBackButton();
		List <MobileElement> list1 = driver.findElementsById("list_item");
		list1.get(0).swipe(SwipeElementDirection.LEFT, 100, 100, 3000);
		delay();
		ScanPage scanning = new ScanPage(driver);
		scanning.setBarcode(CHEESEBARCODE);
		hideKeyboard();
		scanning.clickfindButton();
		Shopinstorepage shoppers =new Shopinstorepage(driver);
		shoppers.clickMoreButton(0);
		PopupPage popokpage =new PopupPage(driver);
		ScanPage scanner9 =popokpage.clickRemove1fromtrolley();
		report("Bracode","enter barcode and click on find button");
		scanner9.setBarcode(CHEESEBARCODE);
		hideKeyboard();
		scanner9.clickfindButton();
		report("scanremove","click on scanremove PopUP remove Button");
		Shopinstorepage startshop3 =new Shopinstorepage(driver);
		CheckOutPage check =startshop3.clickcheckoutButton();
		check.clickMoreButton(0);
		PopupPage popokpage2 =new PopupPage(driver);
		ScanPage scanner10 =popokpage2.clickRemove1fromtrolley();
		scanner10 .setBarcode(KIDSDiPPER);
		hideKeyboard();
		scanner10.clickfindButton();
		CheckOutPage checkout = new CheckOutPage(driver);
		ScanQrCodePage qrpage =checkout.clickScanQrCode();
		CheckOutPage outpage =qrpage.clickBackButton();
		PopupPage popokpage4 =outpage.clickThreeDots();
		delay();
		PopupPage popokpage5 =popokpage4.clickCancelShopfromthreedots();
		report("Shopping List Page","you will be on shopping list page");
		ShoppingListPage shopper1 =popokpage5.clickcancelShop();
		delay();
		PopupPage popokpage6 =shopper1.clickshopstore();
		Shopinstorepage shopper2=popokpage6.clickokButton();
		LoadingMessagesPage loading1 =new LoadingMessagesPage(driver);
	    String message1 = loading1.getMessage();
	    Assert.assertTrue(message1.equals(MESSAGE1) || message1.equals(MESSAGE2) || message1.equals(MESSAGE3));
		delay();
		ScanPage scanner11 =shopper2.clickItemscanButton();
		report("Barcode","enter weighted item barcode manually and click find button");
		scanner.setBarcode(BANANA);
		hideKeyboard();
		scanner.clickFindButton();
		report("back","go back to shop in store page");
		Shopinstorepage shopper3 =scanner.clickBackButton();
		shopper3.clickThreeDots();
		PopupPage popokpage66 =popokpage4.clickCancelShopfromthreedots();
		ShoppingListPage shopper4 =popokpage66.clickcancelShop();
		MenuPage menu1 =shopper4.clicksettingsButton();
		PopupPage popokpage7 =menu1.clicklogout(2);
		ShoppingListPage shopper5 =popokpage7.clickcancellogoutbutton();
		report("settings","click on setting icon");
		MenuPage menu2 = shopper5.clicksettingsButton();
		report("Logout","click logout button and handle popup ok button");
		PopupPage popokpage8=	menu2.clicklogout(2);
		Homepage homepage1=  popokpage8.clickPopmenulogoutokButton();
		report("Verify","Verify the user in homepage");
		Assert.assertTrue(homepage. assert_homepagelogin());
	}

}



