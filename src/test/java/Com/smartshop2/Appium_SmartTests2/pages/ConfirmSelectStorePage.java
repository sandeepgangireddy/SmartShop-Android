package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class ConfirmSelectStorePage extends Page {
	
	@AndroidFindBy(id="change_store")
	private MobileElement changestore;
	
	@AndroidFindBy(id="stick_store")
	private MobileElement dontchange;

	public ConfirmSelectStorePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	public Myaccountpage clickonChangeStore(){
		changestore.click();
		return new Myaccountpage(driver);
	}
	
	public Myaccountpage clickonDontChange(){
		dontchange.click();
		return new Myaccountpage(driver);
	}

}
