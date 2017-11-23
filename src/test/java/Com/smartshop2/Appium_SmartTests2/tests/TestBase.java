package Com.smartshop2.Appium_SmartTests2.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Com.smartshop2.Appium_SmartTests2.helper.RetryAnalyzer;
import Com.smartshop2.Appium_SmartTests2.providers.AppiumConfigurationProvider;
import Com.smartshop2.Appium_SmartTests2.reports.ReportConfiguration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

//Useful reminder about TestNG annotations. See http://testng.org/doc/documentation-main.html#annotations
// @BeforeMethod: The annotated method will be run before each test method.
// @BeforeTest: The annotated method will be run before all the test methods 
//             belonging to the classes inside the tag have run.
// @AfterMethod: The annotated method will be run after each test method.
// @AfterTest: The annotated method will be run after all the test methods 
//             belonging to the classes inside the tag have run.

/**
 * Mother class for all appium tests.
 * 
 * This class takes care of configuration, in particular for
 * - appium client configuration 
 * - reports configuration 
 */
public abstract class TestBase {

	/** Instance of the appium driver */
	protected AppiumDriver<MobileElement> driver = null;

	/** Instance of the class to add description of the steps to the reports */
	private ReportConfiguration reportConfiguration = new ReportConfiguration();

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) {
		for (ITestNGMethod method : context.getAllTestMethods()) {
			method.setRetryAnalyzer(new RetryAnalyzer(AppiumConfigurationProvider.maximumNumberOfFailedTestRepeats())); // rerun failed tests
		}
	}

	/**
	 * Setup appium client before running every test
	 * @throws MalformedURLException whenever the url of the appium server is not formatted correctly
	 */
	@BeforeMethod
	public void setUp() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, AppiumConfigurationProvider.platformName());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, AppiumConfigurationProvider.deviceName());
		cap.setCapability(MobileCapabilityType.APP, AppiumConfigurationProvider.appAbsolutePath());

		String deviceUDID = AppiumConfigurationProvider.deviceUDID();
		if (deviceUDID != null && !deviceUDID.isEmpty() ) {
			cap.setCapability(MobileCapabilityType.UDID, deviceUDID);
		}

		if ( cap.getCapability(MobileCapabilityType.PLATFORM_NAME).equals(MobilePlatform.ANDROID) ) { // platform is android
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppiumConfigurationProvider.appPackage());
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppiumConfigurationProvider.appActivity());
			driver = new AndroidDriver<>(new URL(AppiumConfigurationProvider.url()), cap);
		} else { // iOS platform
			driver = new IOSDriver<>(new URL(AppiumConfigurationProvider.url()), cap);
		}

		// set implicit timeout for @FindBy
		driver.manage().timeouts().implicitlyWait(AppiumConfigurationProvider.implicitTimeout(), TimeUnit.SECONDS);

		// set escape property to false to allow html tags in reportng 
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}

	/**
	 * This method is executed whenever a  test is completed
	 */
	@AfterMethod
	public void tearDown() {
		if ( driver != null ) { 
			driver.resetApp();
			driver.closeApp();
			driver.quit();
		}
	}

	/** Return current instance of appium driver*/
	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	/**
	 * Auxiliary function to add step summary to the report by calling the underlying {@link TestBase#reportConfiguration} instance. 
	 *
	 * @param stepText the test step summary text
	 * @param stepOutput the step output text
	 */
	public void report(String stepText, String stepDetails) {
		reportConfiguration.report(stepText, stepDetails);
	}
	
	public void delay() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void Wifi(){
		try {
			driver.findElementById("dialog_button_cancel").click();
			}catch (Exception e) {}
	}
	
	public void AllowCamera(){
		try {
			driver.findElementByXPath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']").click();
			}catch (Exception e) {}
	}

	public void DenyLocation(){
		try {
			driver.findElementByXPath("//*[@resource-id='com.android.packageinstaller:id/permission_deny_button']").click();
			}catch (Exception e) {}
	}
	
	public void clear(){
		driver.findElementById("barcode_entry").clear();
	}
	
public void swipescreens() {
		
	for ( int screen =0; screen < 4; screen++) {
		 			driver.findElementById("body").swipe(SwipeElementDirection.LEFT, 1200);
		 		}
		 		driver.findElement(By.id("done_button")).click();
		 	}
	protected void hideKeyboard() {
		try {
			driver.hideKeyboard();
		} catch (Exception e) {

		}
	}
}
