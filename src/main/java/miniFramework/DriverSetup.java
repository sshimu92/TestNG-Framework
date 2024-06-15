package miniFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverSetup {

	public static WebDriver driver;
	
	public static WebDriver invokeBrowser() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	
}
