package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class LocationPage extends Page {
	
	
	@AndroidFindBy(id="location_permission_cancel_button")
	private MobileElement cancel;
	
	@AndroidFindBy(id="location_permission_allow_button")
	private MobileElement Allow;
	
	public LocationPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
   
	public ShoppingListPage clickCancelButton(){
		cancel.click();
		return new ShoppingListPage(driver);
	}
	
	public void clickAllowButton(){
		Allow.click();
	}
}
