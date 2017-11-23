package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class NecterPage extends Page{
	
	@AndroidFindBy(id="nectar_number")
	private MobileElement necternumber;
	
	@AndroidFindBy(id="add_card_button")
	private MobileElement addcardnumber;
	
	@AndroidFindBy(id="cancel_button")
	private MobileElement cancelButton;
	

	public NecterPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}

	public Shopinstorepage setNectercardnumber(String number){
		necternumber.sendKeys(number);
		hideKeyboard();
		return new Shopinstorepage(driver);
	}
	public Shopinstorepage clickaddcard(){
		addcardnumber.click();
		return new Shopinstorepage(driver);
	}
	public ShoppingListPage clickcancelButton(){
		cancelButton.click();
		return new ShoppingListPage(driver);
	}
}
