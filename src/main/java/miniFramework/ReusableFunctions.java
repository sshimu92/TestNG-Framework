package miniFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctions {

	private static WebDriver driver;
	private WebDriverWait wait;
	
	
	public ReusableFunctions(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	}
	
	public static WebDriver invokeDriver() {
		
		return driver = DriverSetup.invokeBrowser();
	
	}
	
	public void openWebsite(String url) {
		
		driver.get(url);
		
	}
	
	public void setText(WebElement ele, String txt) {
		
//		waitForElementToBeVisible(ele);
		
		ele.clear();
		ele.sendKeys(txt);

	}
	
	public void click(WebElement ele) {
		
//		waitForElementToBeVisible(ele);
		ele.click();
	}
	
	public void waitForElementToBeVisible(WebElement ele) {
		
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void selectDropdown(WebElement ele, String txt) {
		
		waitForElementToBeVisible(ele);
		
		Select sc = new Select(ele);
		sc.selectByVisibleText(txt);
		
	}
	
	public String getText(WebElement ele) {
		
		waitForElementToBeVisible(ele);
		return ele.getText();
	}
	
	public void closeBrowser() {
		
		driver.quit();
	}
	
	public static void takeScreenshot(String filePath) {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		try {
			
		FileUtils.copyDirectory(src, new File("./Screenshot/"+filePath+".png"));
		
		}catch(IOException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
}
