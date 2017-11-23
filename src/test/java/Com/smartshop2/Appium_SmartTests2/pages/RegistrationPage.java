package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class RegistrationPage extends Page{

	@AndroidFindBy(id="first_name")
	private MobileElement firstname;
	
	@AndroidFindBy(id="last_name")
	private MobileElement lastname;
	
	@AndroidFindBy(id="email")
	private MobileElement email;
	
	@AndroidFindBy(id="password")
	private MobileElement password;
	
	@AndroidFindBy(id="confirm_password")
	private MobileElement confirmPassword;
	
	@AndroidFindBy(id="nectar_number")
	private MobileElement nectorNumber;
	
	@AndroidFindBy(id="offers_checkbox")
	private MobileElement offersChechbox;
	
	@AndroidFindBy(id="terms_checkbox")
	private MobileElement termsChechbox;
	
	@AndroidFindBy(id="terms_text")
	private MobileElement termtext;
	
	@AndroidFindBy(id="login_button")
	private MobileElement signUpButton;
	
	
	
	public RegistrationPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	
	public void setFirstname(String firstName) {
		firstname.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lastname.sendKeys(lastName);
		hideKeyboard();
		delay();
	}
	 
	public void setPassword(String passwordString){
		password.sendKeys(passwordString);
		hideKeyboard();
		delay();
	}
	
	public void setConfirmPassword(String passwordString){
		confirmPassword.sendKeys(passwordString);
		hideKeyboard();
		delay();
	}

	public void setNectarCardNumber(String number){
		nectorNumber.sendKeys(number);
		hideKeyboard();
		delay();
	}
		
	public void setEmail(String emailAddress) {
		email.sendKeys(emailAddress);
		hideKeyboard();
		delay();
	}
	
	public void clickTermsCheckbox() {
		termsChechbox.clear();
	}
	
	public TermsPage clicktermtext(){
		termtext.click();
		return new TermsPage(driver);
	}
	public void clickOffersCheckbox() {
		offersChechbox.clear();
	}
	
	public StoreSelectorPage signup() {
		signUpButton.click();
		return new StoreSelectorPage(driver);
	}
	
	public PopupPage clicksignupnecterpopup(){
		signUpButton.click();
		return new PopupPage(driver);
	}
	
}

