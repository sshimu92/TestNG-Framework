package PageFactoryModel_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import miniFramework.ReusableFunctions;

public class Sample {

	public static WebDriver driver;
	ReusableFunctions reusablefunc;
	
	public Sample(WebDriver driver) {
		
		this.driver = driver;
		this.reusablefunc = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement clickloginbutton;
	
	 @FindBy(xpath = "//div[contains(text(),'Swag Labs')]")
	 private WebElement verifyhmpage;
		
	 @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	 private WebElement addtocartitem1;
		
	 @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	 private WebElement addtocartitem2;
	 
	 @FindBy(css = "div.cart_item_label")
	 private List<WebElement> verifycartitems;
	
	
	
	
	public void setUserName(String uName) {
		
		reusablefunc.setText(username, uName);
	}
	
    public void setPassword(String pwd) {
		
    	reusablefunc.setText(password, pwd);
	}
    
    public void clickButtonLogin() {
	
    	reusablefunc.click(clickloginbutton);

    }

    public boolean verifyHomePage() {
    	
    	return verifyhmpage.isDisplayed();
    }

    public void addItems() {
    	
    	addtocartitem1.click();
    	addtocartitem2.click();
    	
    }

    public boolean verifyItemsOnCart() {
    	
    	 return verifycartitems.containsAll(verifycartitems);
    }
    
}
