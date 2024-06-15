package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactoryModel_POM.Sample;
import junit.framework.Assert;
import miniFramework.ReusableFunctions;

public class SampleTest {

	private WebDriver driver;
	private ReusableFunctions reusablefunc;
	private Sample sml;
	
	@BeforeTest
	public void setup() {
		
		driver = ReusableFunctions.invokeDriver();
		reusablefunc = new ReusableFunctions(driver);
		sml = new Sample(driver);
		reusablefunc.openWebsite("https://www.saucedemo.com/");
		
	}
	
	@Test(priority =1)
	public void verifyUrl() {
		
		reusablefunc.openWebsite("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
		
	}
	
	@Test(priority =2)
	public void loginPage() {
		
		sml.setUserName("standard_user");
		sml.setPassword("secret_sauce");
		sml.clickButtonLogin();
	}
	
	@Test (priority =3)
	public void verifyHomePage() {
		
		sml.verifyHomePage();
		
	}
	
	@Test (priority =4)
	public void addItemsToCart() {
		
		sml.addItems();
	}
	
	@Test (priority =5)
	public void verifyItemsOnShoppingCart() {
		
		boolean items = sml.verifyItemsOnCart();
		System.out.println("Total items: "+ sml.verifyItemsOnCart());
		
	}
	
	@AfterTest
	public void tearDown() {
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		reusablefunc.closeBrowser();
		
	}
}
