package Com.smartshop2.Appium_SmartTests2.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class ShoppingListPage extends Page {
	
	@AndroidFindBy(id="plan_shop_button")
	private MobileElement planyourshop;
	
	@AndroidFindBy(id="shop_in_store_button")
	private MobileElement shopinstore;
	
	@AndroidFindBy(id="empty_list_state")
	private MobileElement emptyliststate;
	
	@AndroidFindBy(id="product_main")
	private List<MobileElement>shoppingList;
	
	@AndroidFindBy(id="more_button")
	private List<MobileElement> moreButtons;
	
	@AndroidFindBy(id="collapsed_quantity")
	private MobileElement quantity;
	
	@AndroidFindBy(id="add")
	private MobileElement addButton;
	
	@AndroidFindBy(id="remove")
	private MobileElement removeButton;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.sainsburys.ssa.auto_qa:id/toolbar']/android.support.v7.widget.LinearLayoutCompat/android.widget.ImageView[@index=1]")
	private MobileElement settingsButton;
	
	@AndroidFindBy(id="action_contact_us")
	private MobileElement contactUs;
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	private List<MobileElement>menuList;
	
	@AndroidFindBy(id="permission_allow_button")
	private MobileElement allow;
	
	
	// non-default constructor (with driver argument)
		public ShoppingListPage(AppiumDriver<MobileElement> driver) {
			super(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(DEFAULT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)), 	this);
		}
	     
		
		public void clickallowButton(){
			allow.click();
			
		}
	public Searchpage clickPlanYourShop() {
		planyourshop.click();
		return new Searchpage(driver);
	}
	
	public PopupPage shoppinglistSwipeLeft(int index){
		swipeShoppingListElement(index,SwipeElementDirection.LEFT);
		return new PopupPage(driver);
	}
	
	public void shoppinglistSwipeRight(int index){
		swipeShoppingListElement(index,SwipeElementDirection.RIGHT);
	}
	
	private void swipeShoppingListElement(int index, SwipeElementDirection direction) {
		shoppingList.get(index).swipe(direction, 100, 100, 1200);
	}
	
	public MoreButtonsPage clickMoreButton(int index){
		moreButtons.get(index).click();
		return new MoreButtonsPage(driver);
	}
	
	public void clickDeletefromList(int index){
		menuList.get(index).click();
	}
	
	public void clickQuantity(int index){
		quantity.click();
	}
	public void clickaddButton(int index){
		addButton.click();
	}
	public void clickremoveButton(int index){
		removeButton.click();
	}
	public MenuPage clicksettingsButton(){
		settingsButton.click();
		return new MenuPage(driver);
	}
	
	public PopupPage clickshopstore(){
		shopinstore.click();
		return new PopupPage (driver);
	}
	public NecterPage clickShopinStore(){
		shopinstore.click();
		return new NecterPage(driver);
	}
}
