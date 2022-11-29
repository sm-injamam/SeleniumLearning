package testCase;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC008_popupAlert extends DriverSetup{

	@Test(priority = 1)
	public static void handlePopupAlert () {
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		 new WebDriverWait(driver, Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 
		 driver.switchTo().frame("iframeResult");
		 driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		 String alerText = driver.switchTo().alert().getText();
		 System.out.println(alerText);
		 driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();
		 //driver.switchTo().alert().sendKeys("");
		 
		 driver.switchTo().defaultContent();
		 System.out.println("Page title "+ driver.getTitle());

		 
	}
	@Test(priority = 2)
	public static void typeOnPopupAlert() throws InterruptedException {
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		
		Alert alertOnPage = driver.switchTo().alert();
		alertOnPage.sendKeys("PopUp");
		alertOnPage.accept();
		Thread.sleep(2000);
		
		driver.switchTo().parentFrame();
		System.out.println("page title :"+ driver.getTitle());
		
	}
}







