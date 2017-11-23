package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class ChangepasswordPage extends Page{
	
	@AndroidFindBy(id="password")
	private MobileElement password;
	
	@AndroidFindBy(id="new_password")
	private MobileElement newpassword;
	
	@AndroidFindBy(id="confirm_new_password")
	private MobileElement confirmpassword;
	
	@AndroidFindBy(id="show_password_checkbox")
    private MobileElement showpassword;
	
	@AndroidFindBy(id="save_btn")
    private MobileElement savebutton;
	
	public ChangepasswordPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);// TODO Auto-generated constructor stub
	}

	public void setPassword(String passwordString){
		password.sendKeys(passwordString);
		hideKeyboard();
	}
	
	public void setnewpassword( String newpasswordString){
		newpassword.sendKeys(newpasswordString);
		hideKeyboard();
	}
	
	public void setconfirmpassword( String newconfirmpasswordString){
		confirmpassword.sendKeys(newconfirmpasswordString);
		hideKeyboard();
	}
	
	public void clickshowpassword(){
		savebutton.click();
	}
	
	public PopupPage clicksavebutton(){
		savebutton.click();
		return new PopupPage (driver);
	}
	
	public ChangepasswordPage clicksaveButton(){
		savebutton.click();
		return new ChangepasswordPage (driver);
	}

}
