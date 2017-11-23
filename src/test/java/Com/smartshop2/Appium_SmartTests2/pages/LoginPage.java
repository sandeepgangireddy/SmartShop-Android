package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends Page {

	@AndroidFindBy(id="email")
	private MobileElement email;

	@AndroidFindBy(id="password")
	private MobileElement password;

	@AndroidFindBy(id="login_button")
	private MobileElement submit;
	
	@AndroidFindBy(id="forgotPasswordText")
	private MobileElement forgotpassword;
	
	@AndroidFindBy(id="show_password_checkbox")
	private MobileElement showPassword;
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	private MobileElement MinpasswordTextMessage;
	
	@AndroidFindBy(id="subTitle")
	private MobileElement registerorsignuplink;
	
	@AndroidFindBy(id="text_input_password_toggle")
	private MobileElement eyeicon;

	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	
	// non-default constructor (with driver argument)
	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	public Boolean assert_loginpage() {
		  Boolean isloginpage = isElementVisible(forgotpassword,driver);
		  return isloginpage;
	} 
	
	public Boolean assert_signuplink() {
		  Boolean issignuplink = isElementVisible(registerorsignuplink,driver);
		  return issignuplink;
	}
	
	public Boolean assert_eyeicon() {
		  Boolean iseyeicon = isElementVisible(eyeicon,driver);
		  return iseyeicon;
	}	

	public String errorMessage() {
		final String errorMessage;
		if ( MinpasswordTextMessage != null) {
			errorMessage = MinpasswordTextMessage.getText();
		} else {
			errorMessage = null;
		}
		return errorMessage;
	}

	public void setEmail(String emailAddress){
		email.sendKeys(emailAddress);
		hideKeyboard();
	}
	
	public void setPassword(String passwordString){
		password.sendKeys(passwordString);
		hideKeyboard();
	}

	public void clickShowpassword (){
		showPassword.click();
		hideKeyboard();
	}
	
	public StoreSelectorPage clickSubmitButton(){
		submit.click();
		return new StoreSelectorPage(driver);
	}
    
	public PopupPage clickLoginButton(){
		submit.click();
		return new PopupPage(driver);
	}
    public forgottenpasswordpage clickforgotpassword(){
    	forgotpassword.click();
    	return new forgottenpasswordpage(driver);
    }
    public LoginPage clicksubmitbutton(){
    	submit.click();
    	return new LoginPage(driver);
    }
    public RegisterInterestPage clickRegisterinterestlink(){
    	registerorsignuplink.click();
    	return new RegisterInterestPage(driver);
    }
    public Homepage clickLoginBackButton(){
    	backbutton.click();
    	return new Homepage(driver);
    }
    
   
}
