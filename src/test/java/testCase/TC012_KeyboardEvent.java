package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC012_KeyboardEvent extends DriverSetup{
	public static String baseUrl = "http://automationpractice.com/index.php";
	
	@Test(priority = 1)
	public static void keyboardEventCheck() {
		driver.get(baseUrl);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		element.sendKeys(Keys.chord(Keys.SHIFT,"tedtalk"));
		//driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,Keys.SHIFT,Keys.DELETE));
		element.sendKeys(Keys.chord(Keys.ENTER));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement element2 =
		 //wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
	}
	
	@Test(priority = 2, description = "Selct Multiple drop down element using Action class")
	public static void seltectMultipleByActionClass() throws InterruptedException {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// Assertion, assert title of the page. 
		String expectedtitle = "W3Schools Tryit Editor";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedtitle, "Title verification failed");
		
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
	
	@Test(priority = 3)
	public static void copyPasteUsingkeyBoard() throws InterruptedException {
		
		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		
		WebElement sourceTextArea = driver.findElement(By.xpath("//body//div//div[@id='dropZone']//div[@role='presentation']//div[@role='presentation']//div[1]//pre[1]"));
		WebElement destinationTextArea = driver.findElement(By.xpath("//div[@id='dropZone2']//div[@class='CodeMirror-scroll']"));
		
		Actions actions = new Actions(driver);
		
		actions.keyDown(sourceTextArea, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		Thread.sleep(2000);

		actions.keyDown(destinationTextArea, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		
		Thread.sleep(2000);

	}
}










