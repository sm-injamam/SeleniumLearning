package testCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC004_DropDown extends DriverSetup {
	
	public static String bUrl = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple";
	
	@Test(priority = 2)
	public static void selectingValueFromDropDown() throws InterruptedException {
		driver.get(bUrl);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		WebElement webElement = driver.findElement(By.name("cars"));
		Select select = new Select(webElement);
		
		// way 1
		
		//for without Select class.
		//List<WebElement> allOptionElements = driver.findElement(By.name("cars"));
		List<WebElement> allOptionElements = select.getOptions();
		for(WebElement optionElement : allOptionElements) {
			System.out.println(optionElement.getText());
			if (optionElement.getText().equalsIgnoreCase("Volvo")) {
				optionElement.click();
			}
		}
		
		//way 2
		select.selectByIndex(3);
//		select.selectByValue("");
//		select.selectByVisibleText("");
		Thread.sleep(2000);
		//Way 3
		driver.findElement(By.xpath("//option[@value='saab']")).click();
		Thread.sleep(2000);
		
		//No. of selected item
		List<WebElement> selectedOption = select.getAllSelectedOptions();
		System.out.println(selectedOption.size());
		
		select.deselectAll();
		Thread.sleep(2000);

		System.out.println(selectedOption.size());

//		System.out.println(selectedOption);
		driver.switchTo().defaultContent();
		//or
				// deselectAll( ):
				// deselectByValue( )
				// deselectByVisibleText( ):
				// getAllSelectedOptions( ):
	} 
	
	@Test(priority = 1)
	public static void seltectMultipleByActionClass() throws InterruptedException {
		driver.get(bUrl);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		
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
		driver.switchTo().defaultContent();
	}

}













