package testCase; 

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverSetup;


public class TC011_MouseHover extends DriverSetup {
	
	//@SuppressWarnings("deprecation")
	@Test
	public static void performMouseHover() throws InterruptedException {
		driver.get("https://www.rokomari.com/book");
		
		// implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		 driver.findElement(By.xpath("//*[@id='js--entry-popup']/div[1]/button/i")).click();
		 //Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@id='js--authors']"));
		WebElement autherElement = driver.findElement(By.xpath("//a[contains(text(),'হুমায়ূন আহমেদ')]"));

		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		//Thread.sleep(3000);

		actions.moveToElement(autherElement).build().perform();
		wait.until(ExpectedConditions.visibilityOf(autherElement)).click();
		//autherElement.click();
		//Thread.sleep(2000);
		
	}

}
