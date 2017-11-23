package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class TermsPage extends Page{
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	

	public TermsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}

	public RegistrationPage clickBackButton(){
		backbutton.click();
		return new RegistrationPage(driver);
	}

}
