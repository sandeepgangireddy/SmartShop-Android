package Com.smartshop2.Appium_SmartTests2.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.forgottenpasswordpage;
import io.appium.java_client.MobileElement;

public class TestForgottenpassword extends TestBase {
	/**
	 * Test that user clicks on forgotten password and verify the message.
	 */
@Test
public void forgotpassword(){
	final String USERNAME="staging0684@gmx.com";
	report("swipe","swipe the screens");
	swipescreens();
	report("Home","click on home login button");
	Homepage home = new Homepage(driver);
	report("Login","enter user with only user name ");
	LoginPage login =home.clickLoginButton();
	login.setEmail(USERNAME);
	forgottenpasswordpage forgot=login.clickforgotpassword();
	forgot.setEmail(USERNAME);
	forgot.clicksendButton();
	delay();
	report("error messsage","verify the message is present");
	String actual_message =driver.findElementById("success_message").getText();
	String expected_message ="We've sent an email to you so that you can reset your password.";
	Assert.assertEquals(actual_message, expected_message);
	
//	MobileElement login_title = driver.findElement(By.id("Logi n")); 
	
}

}
