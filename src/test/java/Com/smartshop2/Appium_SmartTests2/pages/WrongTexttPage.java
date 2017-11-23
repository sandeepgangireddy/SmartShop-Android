package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class WrongTexttPage extends Page{
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	
	@AndroidFindBy(id="search_close_btn")
	private MobileElement crossmark;
	
	@AndroidFindBy(id="empty_list_state_text")
	private MobileElement wrongText;
	

	public WrongTexttPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}

	public Searchpage clickwrongtextBackButton(){
		backbutton.click();
		return new Searchpage(driver);
	}
	
	public void clickcrossmark(){
		crossmark.click();
	}
	
	public Boolean assert_wrongText(){
		Boolean iswrongText= isElementVisible(wrongText,driver);
		return iswrongText;
	}
}
