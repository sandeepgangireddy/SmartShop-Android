package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class MenuPage extends Page {
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	private List<MobileElement> menulist;
	
	public MenuPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}

	
	public Myaccountpage clickmyAccount (int index){
		menulist.get(index).click();
		return new Myaccountpage(driver);
	}
	
	public HelpPage clickmyHelp (int index){
		menulist.get(index).click();
		return new HelpPage(driver);
	}
	
	public ContactUsPage clickcontactus (int index){
		menulist.get(index).click();
		return new ContactUsPage (driver);
	}
	
	public PopupPage clicklogout (int index){
		menulist.get(index).click();
		return new PopupPage(driver);
	}
	
	public ScanPage clickBarcodeScanner(int index){
		menulist.get(index).click();
		return new ScanPage(driver);
		
	}
}
