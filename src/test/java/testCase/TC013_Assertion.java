package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.DriverSetup;

public class TC013_Assertion extends DriverSetup {
	
	@Test(priority = 1, description = "Hard assert vs soft assert")
	public static void seltectMultipleByActionClass() throws InterruptedException {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// Assertion, assert title of the page. 
		String expectedTitle = "W3Schools Tryit Editor";
		String actualTitle = driver.getTitle();
		
		// Hard Assertion. This is not good approach.
		//because if it is fail then the remaining tests will be running stop.
		//Assert.assertEquals(actualTitle, expectedTitle, "Title verification failed");
		
		//soft Assertion. Good approach.
		// when use soft assert we should use assertAll() method at the last.
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle, "Title verification failed");
		
		

		driver.switchTo().frame("iframeResult");
		
		// Text verification of submit button
				String expectedText = "Submit";
				String actualText = driver.findElement(By.xpath("//input[@value='Submit']")).getAttribute("value");
				softAssert.assertEquals(actualText, expectedText, "Submit text verification failed");
		
		
		  WebElement element = driver.findElement(By.name("cars")); 
		  Select select = new Select(element);
		  
		  // for select more than one item
		  
		  Actions actions = new Actions(driver);
		  actions.keyDown(Keys.CONTROL).click(select.getOptions().get(2))
		  .click(select.getOptions().get(1)) .keyUp(Keys.CONTROL).build().perform();
		  
		  Thread.sleep(666);
		 
		// for auto suggestion drop down.
		/*
		 * WebElement element = driver.findElement(By.name("cars"));
		 * element.click();
		 * element.sendkeys("");
		 * Thread.sleep(2000); 
		 * element.sendKeys(Keys.ARROW_DOWN); 
		 * Thread.sleep(2000);
		 * element.sendKeys(Keys.ENTER); Thread.sleep(2000);
		 */
		  
		  softAssert.assertAll();
		driver.switchTo().defaultContent();
	}

}
