package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class ContactUsPage extends Page{
	
	@AndroidFindBy(id="submit")
    private MobileElement contactbyemail;
	
	@AndroidFindBy(id="phone_number")
    private MobileElement phonenumer;
	
	@AndroidFindBy(id="radio_customer_service")
    private MobileElement customerService;
	
	@AndroidFindBy(id="radio_improvement_ideas")
    private MobileElement improvementIdeas;
	
	@AndroidFindBy(id="radio_complaint")
    private MobileElement complaint;
	
	@AndroidFindBy(id="radio_technical_issue")
    private MobileElement technicalIssue;
	
	@AndroidFindBy(id="radio_general_feedback")
    private MobileElement genaeralFeedback;
	
	@AndroidFindBy(id="radio_other")
    private MobileElement other;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	 
	public ContactUsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}

	public Boolean assert_contactbyemail() {
		  Boolean iscontactbyemail = isElementVisible(contactbyemail,driver);
		  return iscontactbyemail;
	} 
	
	public Boolean assert_phonenumer() {
		  Boolean isphonenumer = isElementVisible(phonenumer,driver);
		  return isphonenumer;
	} 
	
	public ShoppingListPage clickcontactusBackButton(){
		backbutton.click();
		return new ShoppingListPage(driver);
	}
}
