package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class Changestoreconfirmation extends Page {
	
	@AndroidFindBy(id="change_store")
	private MobileElement changestore;

	@AndroidFindBy(id="stick_store")
	private MobileElement dontchange;
	
	public Changestoreconfirmation(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
   
	public ChangeStorePage clickchangestore(){
		changestore.click();
	  return new ChangeStorePage(driver);
	}
	public ChangeStorePage clickdontchange(){
		 dontchange.click();
	  return new ChangeStorePage(driver);
	}
	
}
