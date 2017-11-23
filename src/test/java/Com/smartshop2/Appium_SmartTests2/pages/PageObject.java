package Com.smartshop2.Appium_SmartTests2.pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Com.smartshop2.Appium_SmartTests2.providers.AppiumConfigurationProvider;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Base class for any page object. Just include driver
 */
public class PageObject {
	/**
	 * Default wait timeout in seconds.
	 * 
	 * For example, using 10 seconds could be not enough for homepage to load.
	 * Use timeout higher than 10 seconds. 
	 */
	protected static final Integer DEFAULT_WAIT_TIMEOUT_IN_SECONDS = AppiumConfigurationProvider.explicitTimeout();

	/**
	 * Keep reference to an external driver
	 */
	protected final AppiumDriver<MobileElement> driver;
	
	/**
	 * Constructor with driver.
	 * 
	 * It relies on the two-argument constructor, providing a default WebDriverWait
	 * @param driver Appium driver for android 
	 */
	public PageObject(final AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	protected static Boolean waitForElementVisible(MobileElement mobileElement, AppiumDriver<?> driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
        Boolean elementIsNotVisible = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
        } catch (WebDriverException e) {
            elementIsNotVisible=false;
        }
        return elementIsNotVisible;
    }
	
	protected static Boolean waitForElementVisibleAndClickable(MobileElement mobileElement, AppiumDriver<?> driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
        Boolean elementIsNotVisible = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
        } catch (WebDriverException e) {
            elementIsNotVisible=false;
        }
        return elementIsNotVisible;
    }
	
	protected static Boolean waitForElementNotVisible(By by, AppiumDriver<?> driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
        Boolean elementIsNotVisible = true;
        try {
            elementIsNotVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (WebDriverException e) {
            elementIsNotVisible=false;
        }
        return elementIsNotVisible;
    }
	
	protected static Boolean isElementVisible(MobileElement element, AppiumDriver<?> driver) {
        Boolean isElementVisible = false;
        try {
        	if (element != null && element.isDisplayed() ) {
        		isElementVisible = true;
        	} else {
        		isElementVisible = false;
        	}
        } catch (WebDriverException e) {
        }
        return isElementVisible;
    }
	
}
