package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import Com.smartshop2.Appium_SmartTests2.helper.Helper;
import Com.smartshop2.Appium_SmartTests2.helper.Scroller;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class Page extends PageObject {

	/**
	 * Constructor
	 * @param driver Appium driver for android
	 */
	public Page(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}

	// UTILITY METHODS

	public Page back() {
		driver.navigate().back();
		return this;
	}

	/**
	 * Method to close the keyboard.
	 * It wraps the hdekeyboard inside a try-catch block to avoid
	 * exception if for some reason the keyboard is already cl
	 */
	protected void hideKeyboard() {
		try {
			driver.hideKeyboard();
		} catch (Exception e) {

		}
	}

	protected void scrollTo(MobileElement element) {

		System.out.println("ScrollTo ");
		boolean isVisible = false;
		boolean isNotScrolling = false;
		List<MobileElement> elementPrevious = driver.findElements(MobileBy.xpath("//*"));
		System.out.println("size = " + elementPrevious.size());
		int step = 0;
		while(!(isVisible || isNotScrolling)) {
			Helper.delay();
			System.out.println("scrollTo step = " + step);
			try {
				if ( element != null && element.isDisplayed() ) {
					isVisible = true;
				} 
			} catch (WebDriverException e ){

			}
			if ( step > 0) {
				List<MobileElement> elementNow = driver.findElements(MobileBy.xpath("//*"));
				isNotScrolling =  (elementPrevious.size() == elementNow.size());
				System.out.println("size = " + elementNow.size());
				System.out.println("isNotScrolling = " + isNotScrolling);
				elementPrevious = elementNow;
			}

			if ( isVisible || isNotScrolling ) {
				break;
			} else {
				scrollDown();
				step++;
			}
		}
	}

	protected void scrollTo(By by) {
		System.out.println("ScrollTo " + by.toString());
		boolean isVisible = false;
		boolean isNotScrolling = false;
		List<MobileElement> elementPrevious = driver.findElements(MobileBy.xpath("//*"));
		int step = 0;
		while(!(isVisible || isNotScrolling)) {
			Helper.delay();
			System.out.println("scrollTo step = " + step);
			List<MobileElement> list = driver.findElements(by);
			if ( !list.isEmpty() && list.size() > 0 ) {
				isVisible = true;
				moveToTop(list.get(0));
			} else {
				if ( step > 0) {
					List<MobileElement> elementNow = driver.findElements(MobileBy.xpath("//*"));
					isNotScrolling =  (elementPrevious.size() == elementNow.size());
					elementPrevious = elementNow;
				}
			}

			if (!(isVisible || isNotScrolling) ) {
				scrollDown();
			}
			step++;
		}
	}
	protected void moveToTop(MobileElement element) {
		Scroller scroller = new Scroller(driver);
		scroller.moveToTop(element);
	}

	protected void scrollDown() {
		Scroller scroller = new Scroller(driver);
		scroller.swipeUp();
	}
	
	protected void scrollInTheMiddle(MobileElement element) {
		Scroller scroller = new Scroller(driver);
		scroller.moveElementAtTheMiddleOfTheScreen(element);
	}
	
	/**
	 * Manual delay. Not best practise. Avoid using this whenever possible
	 */
	protected void delay() {
		Helper.delay();
	}
	
	
	
//	public Navigation getNavigation() {
//		if (driver instanceof AndroidDriver<?> ) {
//			return new NavigationAndroid(driver);
//		} else {
//			return new NavigationIOS(driver);
//		}
//	}
	
	
}
