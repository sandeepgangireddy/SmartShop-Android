package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class CheckOutPage extends Page {
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.support.v7.widget.LinearLayoutCompat/android.widget.ImageView[@index=0]")
	private MobileElement threedots;
	
	@AndroidFindBy(id="title")
	private MobileElement cancelShop;
	
	@AndroidFindBy(id="more_button")
	private MobileElement moreButtons;
	
	@AndroidFindBy(id="title")
	private MobileElement remove1fromTrolley;
	
	@AndroidFindBy(id="scan")
	private List< MobileElement> itemsScan;
	
	@AndroidFindBy(id="scan_qr_code_button")
	private MobileElement scanQrCode;
	
	@AndroidFindBy(id="tems_in_trolley_header")
	private MobileElement itemsinTrolley;
	
	public CheckOutPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	public Boolean assert_itemsinTrolley(){
		Boolean isitemsinTrolley = isElementVisible(itemsinTrolley,driver);
		return isitemsinTrolley;
	}
    
	
	public PopupPage clickThreeDots(){
		threedots.click();
		return new PopupPage(driver);
	}
	
	public  Shopinstorepage clickBackButton(){
		backbutton.click();
		return new Shopinstorepage(driver);
	}
	public void clickMoreButton(int index){
		moreButtons.click();
	}
	
	public CancelShopPage clickCanceShop(){
		cancelShop.click();
		return new CancelShopPage(driver);
	}
	
	public ScanPage clickItemscan(int index){
		itemsScan.get(index).click();
		return new ScanPage(driver);
	}
	
    public ScanQrCodePage clickScanQrCode(){
    	scanQrCode.click();
    	return new ScanQrCodePage(driver);
    }
    
}
