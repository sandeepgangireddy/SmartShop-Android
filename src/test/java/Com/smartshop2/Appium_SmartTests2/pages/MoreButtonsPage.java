package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class MoreButtonsPage extends Page{
	
	@AndroidFindBy(id="title")
	private List<MobileElement> morelist;

	public MoreButtonsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}

	public PopupPage clickDeletefromList(int index) {
		morelist.get(index).click();
		return new PopupPage(driver);
	}
	
	public ProductListPage clickSearchforProduct(int index){
		morelist.get(index).click();
		return new ProductListPage(driver);
	}
	
}
