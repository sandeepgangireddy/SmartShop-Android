package Com.smartshop2.Appium_SmartTests2.tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.smartshop2.Appium_SmartTests2.helper.CSVFileReader;
import Com.smartshop2.Appium_SmartTests2.helper.User;
import Com.smartshop2.Appium_SmartTests2.pages.Homepage;
import Com.smartshop2.Appium_SmartTests2.pages.LoginPage;
import Com.smartshop2.Appium_SmartTests2.pages.ShoppingListPage;
import Com.smartshop2.Appium_SmartTests2.pages.StoreSelectorPage;
import io.appium.java_client.MobileElement;
	
public class TestMinPasswordErrorMessage extends TestBase{
	@Test
	public void loginerrormessage(){
		final String USERNAME="staging0684@gmx.com";
		final String PASSWORD ="Test1";
		String actual_error ="";
		String Expected_error = "Your password must be at least 8 characters and can't contain spaces";
		report("Swipe", "swipe the screens");
		swipescreens();
		report("Home","click on login button");
		Homepage homepage = new Homepage(driver);
		report("Login","login woth invalid credentails");
		LoginPage loginPage = homepage.clickLoginButton();
		loginPage.setEmail(USERNAME);
		loginPage.setPassword(PASSWORD);
		LoginPage page = loginPage.clicksubmitbutton();
		delay();
		report("Assert","Verified Error message is present");
		List<MobileElement> allDivs = driver.findElements(By.className("android.widget.TextView"));
		/*for (Iterator iterator = allDivs.iterator(); iterator.hasNext();) {
			MobileElement mobileElement = (MobileElement) iterator.next();
			System.out.println("Ram"+ mobileElement.getText());
			
		}*/
		if(allDivs.size() >=4){
			MobileElement mobileElement = (MobileElement) allDivs.get(3);
			actual_error = mobileElement.getText();
		}
		//System.out.println(driver.findElementById("com.sainsburys.ssa.qa:id/subTitle").getText());
		
		Assert.assertEquals(actual_error, Expected_error);
		System.out.println("Ram");
	}

}
