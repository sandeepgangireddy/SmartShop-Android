package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class RegisterInterestPage extends Page{


	@AndroidFindBy(id="first_name")
	private MobileElement firstname;
	
	@AndroidFindBy(id="last_name")
	private MobileElement lastname;
	
	@AndroidFindBy(id="email")
	private MobileElement email;
	
	@AndroidFindBy(id="post_code")
	private MobileElement postcode;

	@AndroidFindBy(id="nectar_number")
	private MobileElement necternumber;
	
	@AndroidFindBy(id="submit_interest")
	private MobileElement submit;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	
	public RegisterInterestPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}

	
	public void setFirstname(String firstName) {
		firstname.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lastname.sendKeys(lastName);
		hideKeyboard();
	}
	
	public void setEmail(String emailAddress) {
		email.sendKeys(emailAddress);
		hideKeyboard();
	}
	
	public void setPostCode( String postCode){
		postcode.sendKeys(postCode);
		hideKeyboard();
	}
	
	public void setNectarCardNumber(String number){
		necternumber.sendKeys(number);
		hideKeyboard();
		delay();
	}
	
	public PopupPage clicksubmitButton(){
		submit.click();
		return new PopupPage(driver);
	}
	
	 public LoginPage clickRegisterinterestBackButton(){
	    	backbutton.click();
	    	return new LoginPage(driver);
	    }
}
