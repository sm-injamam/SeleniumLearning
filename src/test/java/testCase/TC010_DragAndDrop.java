package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC010_DragAndDrop extends DriverSetup {

	@Test
	public static void DragAndDropAction () throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement framElement= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	driver.switchTo().frame(framElement);
WebElement dragElement =driver.findElement(By.id("draggable"));
WebElement dropElement = driver.findElement(By.id("droppable"));

	Actions actions = new Actions(driver);
	actions.dragAndDrop(dragElement, dropElement).perform();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	}
}
