package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC006_Scroll extends DriverSetup{

public static String baseUrl = "https://www.guru99.com/";
	
	@Test
	public static void scrollCheck() throws InterruptedException {
		driver.get(baseUrl);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Scroll to bottom:
		//js.executeScript("window.scrollTo(0,1000)");
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(3000);
		
		//Scroll to top.
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(3000);
		
		//scroll to specific element
		
		
		  WebElement element = driver.findElement(By.xpath(
		  "//strong[normalize-space()='Popular Tools']"));
//		  js.executeScript("arguments[0].scrollIntoView();",element);
//		  Thread.sleep(3000);
		 
			  //or 
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(element);
			  actions.perform(); Thread.sleep(3000);
			 
		 
	}

}
