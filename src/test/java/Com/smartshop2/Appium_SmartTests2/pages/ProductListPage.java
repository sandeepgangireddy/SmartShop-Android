package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class ProductListPage extends Page{
	

	@AndroidFindBy(id="quantity")
	private List<MobileElement>  listQuantityButton;
	
	@AndroidFindBy(id="remove")
	private List<MobileElement> removeButton;
	
	@AndroidFindBy(id="add")
	private List<MobileElement> addButton;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	
	public ProductListPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
	}
	
	
	public void clickQuantityButton(int index) {
		listQuantityButton.get(index).click();
	}
    
	public void clickAddButton(int index){
		addButton.get(index).click();
	}
	
	
	public void clickRemoveButton(int index){
		removeButton.get(index).click();
	}
	
	public Searchpage clickBackButton(){
		backbutton.click();
		return new Searchpage(driver);
	}
    
	public ShoppingListPage clickBackButtonfromproductlist(){
		backbutton.click();
		return new ShoppingListPage(driver);
	}
}
