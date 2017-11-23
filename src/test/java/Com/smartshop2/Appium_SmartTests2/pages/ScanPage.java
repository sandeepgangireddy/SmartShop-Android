package Com.smartshop2.Appium_SmartTests2.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.sainsburys.shoppingsdk.Basket;
import com.sainsburys.shoppingsdk.ListItem;
import com.sainsburys.shoppingsdk.RemoteError;
import com.sainsburys.shoppingsdk.ServiceBasket;
import com.sainsburys.shoppingsdk.ServiceBasket.AddItemCallback;
import com.sainsburys.shoppingsdk.ServiceBasket.CreateCallback;
import com.sainsburys.shoppingsdk.ServiceBasket.RemoveItemCallback;
import com.sainsburys.shoppingsdk.ServiceFactory;
import com.sainsburys.shoppingsdk.ServiceShoppingList;
import com.sainsburys.shoppingsdk.ShoppingList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class ScanPage extends Page {
	
	@AndroidFindBy(id="permission_allow_button")
	private MobileElement allow;
	
	@AndroidFindBy(id="permission_deny_button")
	private MobileElement deny;
	
	@AndroidFindBy(id="barcode_entry")
	private MobileElement enterbarcode;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.widget.ImageButton[@index=0]")
	private MobileElement backbutton;
	
	@AndroidFindBy(className="android.widget.EditText")
	private MobileElement barcodenumber;
	
	@AndroidFindBy(id="find_button")
	private MobileElement find;
	
	@AndroidFindBy(id="button2")
	private MobileElement cancel;
	
	@AndroidFindBy(id="stay_on_toggle")
	private MobileElement scannerOn;
	
	@AndroidFindBy(id="stay_on_toggle")
	private MobileElement scannerOf;
	
	// non-default constructor (with driver argument)
		public ScanPage(AppiumDriver<MobileElement> driver) {
			super(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
		}
	
		
	public void clickScannerOf() {
		scannerOf.click();
	}
	public void clickAllowButton() {
		allow.click();
	}
	
	public void clickDenyButton() {
		deny.click();
	}
	
	public void clickBarcodeManually(){
		enterbarcode.click();
	}
	
	public Searchpage clickbackbutton(){
		backbutton.click();
		return  new Searchpage (driver);	
		
	}
	
	public ShoppingListPage clickBackbutton(){
		backbutton.click();
		return  new ShoppingListPage (driver);
	}
	
	public Shopinstorepage clickBackButton(){
		backbutton.click();
		return  new Shopinstorepage  (driver);
	}
	
	public void setBarcode(String number){
		barcodenumber.sendKeys(number);
	}
	public void setBarcodeToUserList(String number, String term, int quantity, String username, String password) throws IOException{
		ServiceFactory factory = ServiceFactory.getInstance();
		factory.getTokenManager().login(username, password);
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServiceShoppingList service = factory.getServiceShoppingList();
		ShoppingList shoppingList = service.getMaster();
		
		service.addProductBySku(shoppingList.getId(), number, term, quantity);
	}
	
	public void setBarcodeToShopinstore(String number, String username, String password) throws IOException{
		//barcodenumber.sendKeys(number);
		
		final String STORE_ID_HARPENDEN = "0777";
		
		ServiceFactory factory = ServiceFactory.getInstance();
		factory.getTokenManager().login(username, password);
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServiceBasket serviceBasket = factory.getServiceBasket();
		
		Basket basket = serviceBasket.getCurrent(STORE_ID_HARPENDEN);
		
		if(basket == null){
			throw new IllegalStateException("Failed downloading basket");
		}
		
		final Basket addedResponse = serviceBasket.addProduct(STORE_ID_HARPENDEN, basket.getShopId(), 1, number);
		
		if(addedResponse == null){
			throw new IllegalStateException("Failed downloading basket");
		}
	}
	
	public void removeFromBarcode(String number, String username, String password) throws IOException{
		
		final String STORE_ID_HARPENDEN = "0777";
		
		ServiceFactory factory = ServiceFactory.getInstance();
		factory.getTokenManager().login(username, password);
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServiceBasket serviceBasket = factory.getServiceBasket();
		final Basket basket = serviceBasket.getCurrent(STORE_ID_HARPENDEN);
		if(basket == null){
			throw new IllegalStateException("Failed downloading basket");
		}
		
		Basket productAdded = serviceBasket.removeProduct(STORE_ID_HARPENDEN, basket.getShopId(), number);
		
		if(productAdded == null){
			throw new IllegalStateException("Failed downloading basket");
		}
	}
	
	public void clickFindButton(){
		find.click();
	}
	
	public void clickCancelButton(){
		cancel.click();
	}
	
	public PopupPage clickfindButton(){
		find.click();
		return new PopupPage(driver);
	}
}
