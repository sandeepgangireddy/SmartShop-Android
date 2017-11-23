package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class StoreSelectorPage extends Page {
	
	// non-default constructor (with driver argument)
	public StoreSelectorPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
     
	// list of stores VISIBLE (at least partially) ON THE SCREEN
	@AndroidFindBy(className="android.widget.RelativeLayout")
	private List<MobileElement> listOfStores;
	
	@AndroidFindBy(id="register_interest_click")
	private MobileElement registerinterest;
	
	@AndroidFindBy(id="com.sainsburys.ssa.autoqa:id/title")
	private MobileElement yourstores;
	
	/**
	 * Click on the index-th store in the list
	 * @param index index of the store 
	 */
	public ShoppingListPage selectStoreFromLogin(int index){
		listOfStores.get(index).click();
		return new ShoppingListPage(driver);
	}
	
	/**
	 * Click on the index-th store in the list
	 * @param index index of the store 
	 */
	public RegistrationPage selectStoreFromRegistration(int index){
		listOfStores.get(index).click();
		return new RegistrationPage(driver);
	}
	
	public RegisterInterestPage cickregisterinterest(){
		registerinterest.click();
		return new RegisterInterestPage(driver);
	}
	
	public Boolean assert_yourstores(){
		Boolean isyourstores = isElementVisible(yourstores,driver);
		return isyourstores;
	}

	
	
}
