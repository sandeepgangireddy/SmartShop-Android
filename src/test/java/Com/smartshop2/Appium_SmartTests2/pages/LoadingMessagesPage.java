package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class LoadingMessagesPage extends Page{
	

	@AndroidFindBy(id="loading_message")
	private MobileElement loadingMessages;

	public LoadingMessagesPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}

	
	public String getMessage() { // this method returns the actual message displayed on the page
//		String actualMessage = null;
//		if ( isElementVisible(loadingMessages, driver)) {
//			actualMessage = loadingMessages.getText(); 
//		} 
//		return actualMessage; 
		try {
		return loadingMessages.getText();
		} catch (Exception e) {
			
		}
		return null;
	}
	
}


