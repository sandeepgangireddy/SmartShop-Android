package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class HelpPage extends Page{
	
	 @AndroidFindBy(id="tutorial")
     private MobileElement quickguide;
	 
	 @AndroidFindBy(id="faq")
     private MobileElement faqs;
	 
	 @AndroidFindBy(id="terms")
     private MobileElement termsandconditions;
	 
	 @AndroidFindBy(id="privacy_policy")
     private MobileElement privacypolicy;
	 
	 @AndroidFindBy(id="accessibility_statement")
     private MobileElement accessstatement;
	 
	 @AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	 private MobileElement backbutton;
	 
	public HelpPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
    public UserguidePage clickquickguide(){
    	quickguide.click();
    	return new UserguidePage(driver);
    }
    
    public FaqsPage clickFaqsButton(){
    	faqs.click();
    	return new FaqsPage(driver);
    }
    public TermsandConditionsPage clickTermsandConditions(){
    	termsandconditions.click();
    	return new TermsandConditionsPage(driver);
    }
    
    public PrivacyPolicy clickPrivacyPolicy(){
    	privacypolicy.click();
    	return new PrivacyPolicy(driver);
    }
    public AccessibilityPage clickAcessStatement(){
    	accessstatement.click();
    	return new AccessibilityPage(driver);
    }
    
    public ShoppingListPage clickHelpBackButton(){
    	backbutton.click();
    	return new ShoppingListPage(driver);
    }
}
