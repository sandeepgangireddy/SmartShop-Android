package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class CancelShopPage extends Page{
	
	@AndroidFindBy(id="dialog_button_cancel")
	private MobileElement cancel;
	
	@AndroidFindBy(id="dialog_button_confirm")
	private MobileElement ok;

	public CancelShopPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
    
	public CheckOutPage clickCancelButton(){
		cancel.click();
		return new CheckOutPage(driver);
	}
	
	public ShoppingListPage clickOkButton(){
		ok.click();
		return new ShoppingListPage(driver);
	}
}
