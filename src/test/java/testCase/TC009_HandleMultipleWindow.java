package testCase;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC009_HandleMultipleWindow extends DriverSetup{

	@Test(priority = 1)
	public static void handleWindows () throws InterruptedException {
		driver.get("https://www.salesforce.com/in/?ir=1");
		 new WebDriverWait(driver, Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.xpath("//span[normalize-space()='Start my free trial']")).click();
		 
		 //
		Set<String> windowHandles = driver.getWindowHandles();
		
		System.out.println(windowHandles);
		
		//
		Iterator<String> iterator = windowHandles.iterator();
		
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		
		driver.switchTo().window(childWindow);
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Rahim");
		
		driver.findElement(By.name("UserLastName")).sendKeys("Ullah");
		

		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);

		 
	}	 
}







