package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class Myaccountpage extends Page{
	
    @AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id='com.sainsburys.ssa.auto_qa:id/tabs']/android.widget.ImageView[@index=0]")
	private MobileElement image;
   
    @AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id='com.sainsburys.ssa.auto_qa:id/tabs']/android.widget.ImageView[@index=1]")
	private MobileElement storeicon;
	
    @AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
    
	@AndroidFindBy(id="first_name")
	private MobileElement firstname;
	
	@AndroidFindBy(id="last_name")
	private MobileElement lastname;
	
	@AndroidFindBy(id="nectar_number")
	private MobileElement necternumber;
	
	@AndroidFindBy(id="change_email")
	private MobileElement changeemail;
	
	@AndroidFindBy(id="change_password")
	private MobileElement changepassword;
	
	@AndroidFindBy(id="marketing_preferenceschange_password")
	private MobileElement marketprefernces;
	
	public Myaccountpage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	public void clickimageicon(){
		image.click();
	}
	
   public ChangeStorePage clickStoreIcon(){
	   storeicon.click();
	   return new ChangeStorePage (driver);
   }
    
   public ShoppingListPage clickBackButton(){
	   backbutton.click();
	   return new ShoppingListPage(driver);
   }
	public void setFirstName(String name){
		firstname.sendKeys(name);
		hideKeyboard();
	}
	
	public void setLastname(String name){
		lastname.sendKeys(name);
		hideKeyboard();
	}
	
	public void setNecterNumber (String number){
		necternumber.sendKeys(number);
		hideKeyboard();
	}
	
    public ChangepasswordPage ClickChangePassword(){
    	changepassword.click();
    	return new ChangepasswordPage(driver);
    }
    
    public MarketingPreferencePage ClickMarketingPreference(){
    	marketprefernces.click();
    	return new MarketingPreferencePage(driver);
    }
    
    public Homepage clickbackbutton(){
    	backbutton.click();
    	return new Homepage(driver);
    }
	
    public ChangeStorePage clickstoreicon(){
    	storeicon.click();
    	return new ChangeStorePage(driver);
    }
}

