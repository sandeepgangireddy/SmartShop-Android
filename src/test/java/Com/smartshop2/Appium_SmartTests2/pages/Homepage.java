
package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class Homepage extends Page {
	
	@AndroidFindBy(id="log_in")
	private MobileElement login;
	
	@AndroidFindBy(id="sign_up")
	private MobileElement signup;
	
	// non-default constructor (with driver argument)
		public Homepage(AppiumDriver<MobileElement> driver) {
			super(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
		}
		
	public Boolean assert_homepagelogin(){
		Boolean  ishomepagelogin = isElementVisible(login,driver);
		return ishomepagelogin;
	}
	
	public Boolean assert_homepagesignup(){
		Boolean  ishomepagesignup = isElementVisible(signup,driver);
		return ishomepagesignup;
	}
	public LoginPage clickLoginButton(){
		login.click();
		return new LoginPage(driver);
	}
	
    public StoreSelectorPage clicksignupButton(){
    	signup.click();
    	return new StoreSelectorPage(driver);
    }
	
	
}
