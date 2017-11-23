package Com.smartshop2.Appium_SmartTests2.helper;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Utility class to perform swipe gestures.
 */
public class Scroller {
	
	private static final Integer DEFAULT_SWIPE_DURATION = 2000;

	/**
	 * Keep a reference to the appium driver
	 */
	private final AppiumDriver<MobileElement> driver;

	public Scroller(AppiumDriver<MobileElement> driver) {
		super();
		this.driver = driver;
	}
	
	public void swipeUp() {
		swipeUp(DEFAULT_SWIPE_DURATION);
	}
	
	/**
	 * Swipe upward gesture (causing screen to scroll down)
	 */
	public void swipeUp(Integer duration) {
		Dimension dimens = driver.manage().window().getSize();
		int x = (int) (dimens.getWidth() * 0.5);
		int startY = (int) (dimens.getHeight() * 0.8);
		int endY = (int) (dimens.getHeight() * 0.2);
		driver.swipe(x, startY, x, endY, duration);
	}
	
	public void swipeDown() {
		swipeDown(DEFAULT_SWIPE_DURATION);
	}
	/**
	 * Swipe downward gesture (causing page to scroll up) 
	 */
	public void swipeDown(Integer duration) {
		Dimension dimens = driver.manage().window().getSize();
		int x = (int) (dimens.getWidth() * 0.5);
		int startY = (int) (dimens.getHeight() * 0.2);
		int endY = (int) (dimens.getHeight() * 0.8);
		driver.swipe(x, startY, x, endY, duration);
	}
	
	public void swipeLeft() {
		swipeLeft(DEFAULT_SWIPE_DURATION);
	}

	/**
	 * Swipe leftward gesture
	 */
	public void swipeLeft(Integer duration) {
		Dimension dimens = driver.manage().window().getSize();
		int y = (int) (dimens.getHeight() * 0.9);
		int startX = (int) (dimens.getWidth() * 0.2);
		int endX = (int) (dimens.getWidth() * 0.8);
		driver.swipe(startX, y, endX, y, duration);
	}
	
	public void swipeRight() {
		swipeRight(DEFAULT_SWIPE_DURATION);
	}

	/**
	 * Swipe rightWard gesture
	 */
	public void swipeRight(Integer duration) {
		Dimension dimens = driver.manage().window().getSize();
		int y = (int) (dimens.getHeight() * 0.5);
		int startX = (int) (dimens.getWidth() * 0.8);
		int endX = (int) (dimens.getWidth() * 0.2);
		driver.swipe(startX, y, endX, y, duration);
	}
	
	/**
	 * Try to move the input element in the middle of the screen height
	 * @param titleElement element to show in the middle of the screen
	 */
	public void moveElementAtTheMiddleOfTheScreen(MobileElement element) {
		moveToHeight(element,0.5);
	}
	
	/**
	 * Try to move the input element at the top of the screen height
	 * @param titleElement element to show in the middle of the screen
	 */
	public void moveToTop(MobileElement element) {
		moveToHeight(element,0.3);
	}
	
	private void moveToHeight(MobileElement element, Double fraction) {
		Dimension dimens = driver.manage().window().getSize();
		int x = (int) (dimens.getWidth() * 0.5);
		int startY = element.getLocation().y;
		int endY = (int) (dimens.getHeight() * fraction);
		driver.swipe(x, startY, x, endY, 1000);
	}

}
