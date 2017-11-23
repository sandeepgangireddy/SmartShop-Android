package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class PopupPage extends Page {

	@AndroidFindBy(id="permission_allow_button")
	private MobileElement allow;
	
	@AndroidFindBy(id="permission_deny_button")
	private MobileElement deny;
	
	@AndroidFindBy(id="button1")
	private MobileElement button;
	
	@AndroidFindBy(id="button2")
	private MobileElement button2;
	
	@AndroidFindBy(id="dialog_button_confirm")
	private MobileElement delete;

	@AndroidFindBy(id="dialog_button_cancel")
	private MobileElement cancel;
	
	@AndroidFindBy(id="custom_ok")
	private MobileElement ok;
	
	@AndroidFindBy(id="title")
	private MobileElement cancelshop;
	
	@AndroidFindBy(id="dont_remind_me_checkbox")
	private MobileElement dontremain;
	
	@AndroidFindBy(id="dialog_message")
	private MobileElement paracetemolmeassage;
	
	public PopupPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	public Boolean assert_paracetemolmessage(){
		Boolean isparacetemolmessage =isElementVisible(paracetemolmeassage,driver);
		return isparacetemolmessage;
	}
	
	public ScanPage clickparacetemolokButton(){
		delete.click();
		return new ScanPage(driver);
	}
	public PopupPage clickallowButton(){
		allow.click();
		return new PopupPage(driver);
	}
    
	public PopupPage clickCancelShopfromthreedots(){
		cancelshop.click();
		return new PopupPage(driver);
	}
	public ScanPage clickRemove1fromtrolley(){
		cancelshop.click();
		return new ScanPage(driver);
	}
	public Shopinstorepage clickNoButton(){
		cancel.click();
		return new Shopinstorepage(driver);
	}
	
	public ShoppingListPage clickcancelShop(){
		delete.click();
		return new ShoppingListPage(driver);
	}
	
	public ProductListPage clickDeleteButtonfromProductlist(){
		delete.click();
		return new ProductListPage(driver);
	}
	
	public Shopinstorepage clickokButton(){
		button.click();
		return new Shopinstorepage(driver);
		}
	
	public ScanPage clickitemnotfoundokButton(){
		button.click();
		return new ScanPage(driver);
	}
	
	public ScanPage clickInvalidBarcodeOkButton(){
		button.click();
		return new ScanPage(driver);
	}
	
	public RegistrationPage clickNectercardalreadyokButton(){
		button.click();
		return new RegistrationPage(driver);
	}
	public Homepage clickPopmenulogoutokButton(){
		button.click();
		return new Homepage(driver);
	}
	
	public ScanPage clickallowscanButton(){
		allow.click();
		return new ScanPage(driver);
	}
	
	public LoginPage clickpopokButton(){
		button.click();
		return new LoginPage(driver);
		
	}
	
	public RegistrationPage clickemailexitsokButton(){
		button.click();
		return new RegistrationPage(driver);
		
	}
	public  Homepage clickRegisterIntokButton(){
		button.click();
		return new Homepage(driver);
		
	}
	
	public ShoppingListPage clicknotnowButton(){
		button2.click();
		return new ShoppingListPage(driver);
	}
	
	public PopupPage clicknotNowButton(){
		button2.click();
		return new PopupPage(driver);
	}
	
	public ShoppingListPage clickcancellogoutbutton(){
		button2.click();
		return new ShoppingListPage(driver);
	}
	
	
	public Myaccountpage clickpasswordokbutton(){
		ok.click();
		return new Myaccountpage(driver);
	}
	
	public ShoppingListPage clickDeleteButton(){
		delete.click();
		return new ShoppingListPage(driver);
	}
	
	public ProductListPage clickdeleteButton(){
		delete.click();
		return new ProductListPage(driver);
	}
	public ShoppingListPage clickcancelButton(){
		cancel.click();
		return new ShoppingListPage(driver);
	}
	public CheckOutPage clickScanremoveButtoncheckout(){
		delete.click();
		return new CheckOutPage (driver);
	}
	public Shopinstorepage clickScanremoveButton(){
		delete.click();
		return new Shopinstorepage (driver);
	}
	
	public ScanPage clickThink25OkButton(){
		delete.click();
		return new ScanPage (driver);
	}
	
	public void clickdontremain(){
		dontremain.click();
	}
	}

