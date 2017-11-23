package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class forgottenpasswordpage extends Page{
	
    @AndroidFindBy(className="android.widget.EditText")
    private MobileElement emailaddress;
    
    @AndroidFindBy(id="buttonRecovery")
    private MobileElement send;
    
    public forgottenpasswordpage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
    public void setEmail(String emailAddress){
		emailaddress.sendKeys(emailAddress);
		hideKeyboard();
	}
	
    public emailsentpage clicksendButton(){
    	send.click();
    	return new emailsentpage(driver);
    }
}
