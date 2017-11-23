package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class ChangeStorePage  extends Page {
	
	@AndroidFindBy(className="android.widget.RelativeLayout")
	private List<MobileElement> changestore;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	
	

	public ChangeStorePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	public Changestoreconfirmation clickonstoreselection (int index){
		changestore.get(index).click();
		return new Changestoreconfirmation(driver);
	}
	
	public ShoppingListPage clickbabkbutton(){
		backbutton.click();
		return new ShoppingListPage (driver);
	}
   public Homepage clickBackButton(){
	   backbutton.click();
	   return new Homepage(driver);
	   
   }
}
