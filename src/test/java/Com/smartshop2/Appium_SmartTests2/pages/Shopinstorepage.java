package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class Shopinstorepage extends Page{

	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	
//	className="android.support.v7.widget.al" threedots
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.support.v7.widget.LinearLayoutCompat/android.widget.ImageView[@index=1]")
	private MobileElement threedots;
	
	@AndroidFindBy(id="product_main")
	private List<MobileElement>menuList;
	
	@AndroidFindBy(id="trolleyCounter")
	private List<MobileElement>trolleycounter;
	
	@AndroidFindBy(id="scan")
	private MobileElement itemsScan;
	
	@AndroidFindBy(id="more_button")
	private MobileElement moreButtons;
	
	@AndroidFindBy(id="title")
	private MobileElement deletefromList;
	
	@AndroidFindBy(id="scan_button")
	private MobileElement scanButton;
	
	@AndroidFindBy(id="checkout_text")
	private MobileElement checkoutButton;
	
	@AndroidFindBy(id="total_price")
	private MobileElement ItemPrice;
	
	@AndroidFindBy(id="list_item_header")
	private MobileElement stillToGet;
	
	@AndroidFindBy(id="list_item_header")
	private MobileElement addedToTrolley;
	
	public Shopinstorepage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	
	public Boolean assert_itemprice(){
		Boolean isitemprice = isElementVisible(ItemPrice,driver);
		return isitemprice;
	}

	public ShoppingListPage clickBackButton(){
		backbutton.click();
		return new ShoppingListPage (driver);
	}
	
	public PopupPage clickThreeDots(){
		threedots.click();
		return new PopupPage(driver);
	}
	
	public ScanPage clickItemscan(int index){
		itemsScan.click();
		return new ScanPage(driver);
	}
	
	public ScanPage clickItemscanButton(){
		scanButton.click();
		return new ScanPage(driver);
	}
	
	public void clickMoreButton(int index){
		moreButtons.click();
	}
	
	
	public void deletefromlist(int index){
		deletefromList.click();
	}
	
	public CheckOutPage clickcheckoutButton(){
		checkoutButton.click();
		return new CheckOutPage(driver);
	}
	
	public PopupPage clickbackbutton(){
		backbutton.click();
		return new PopupPage(driver);
	}
	
}
