package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class Searchpage extends Page{

	@AndroidFindBy(id="tag_not_selected")
	private List <MobileElement> listNotSelectedTags;

	@AndroidFindBy(id="tag_selected")
	private List <MobileElement> listSelectedTags;

	@AndroidFindBy(id="action_scanner")
	private MobileElement scanbar;

	@AndroidFindBy(id="search_src_text")
	private MobileElement searchfield;

	@AndroidFindBy(id="search_close_btn")
	private MobileElement searchclosebutton;

	@AndroidFindBy(id="add_to_list_button")
	private MobileElement addtoList;

	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	
	//(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.qa:id/toolbar']/android.widget.ImageButton[@index=0]")

	// non-default constructor (with driver argument)
	public Searchpage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	public Boolean assert_searchclosebutton(){
		Boolean issearchclosebutton =isElementVisible(searchclosebutton,driver); 
		return  issearchclosebutton;
	}

	public int numberOfNotSelectedTag(int index) {
		return listNotSelectedTags.size();
	}

	public int numberOfSelectedTag(int index) {
		return listSelectedTags.size();
	}


	public void clickSelectedTag(int index) {
		listSelectedTags.get(index).click();
	}


	public TagConfirmationPopup clickNotSelectedTag(int index) {
		listNotSelectedTags.get(index).click();
		return new TagConfirmationPopup(driver);
	}

	public ScanPage clickScanButton(){
		scanbar.click();
		return new ScanPage(driver);
	}

	public void setSearchText(String search){
		searchfield.sendKeys(search);
	}

	public void clickSearchcloseButton(){
		searchclosebutton.click();
	}

	public void clickAddtoList(){
		addtoList.click();
	}

	public ShoppingListPage clickBackButton(){
		backbutton.click();
		return new ShoppingListPage(driver);
	}
	
	public WrongTexttPage clicksearchbutton(){
		
		// appium java client 2.2.0 sendKeyEvent() moved from AppiumDriver to AndroidDriver
				// appium java client 3.2.0 Replace sendKeyEvent() method in android with pressKeyCode(int key) 
				AndroidDriver<?> androidDriver = (AndroidDriver<?>)driver;
				androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER); // not working
				androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_DOWN); // not working
				androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH); // not working
				androidDriver.pressKeyCode(84); // not working
				// Using TouchAction (not good solution but seems to be the official solution provided in appium discussion!)
				Dimension dimens = driver.manage().window().getSize();
				// try to determine position of magnifier icon as % of screen size
				int x = (int) ((dimens.getWidth()  * 1000)/1080); 
				int y = (int) ((dimens.getHeight() * 1698)/1794);

				TouchAction action = new TouchAction(driver);
				action.tap(x,y).perform();
				return new WrongTexttPage(driver);
			}

	public ProductListPage clickSearchButton() {

		// appium java client 2.2.0 sendKeyEvent() moved from AppiumDriver to AndroidDriver
		// appium java client 3.2.0 Replace sendKeyEvent() method in android with pressKeyCode(int key) 
		AndroidDriver<?> androidDriver = (AndroidDriver<?>)driver;
		androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER); // not working
		androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_DOWN); // not working
		androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH); // not working
		androidDriver.pressKeyCode(84); // not working
		// Using TouchAction (not good solution but seems to be the official solution provided in appium discussion!)
		Dimension dimens = driver.manage().window().getSize();
		// try to determine position of magnifier icon as % of screen size
		int x = (int) ((dimens.getWidth()  * 1000)/1080); 
		int y = (int) ((dimens.getHeight() * 1698)/1794);

		TouchAction action = new TouchAction(driver);
		action.tap(x,y).perform();
		return new ProductListPage(driver);
	}

}
