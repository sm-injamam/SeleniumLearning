package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverSetup;


public class TC003_checkBoxRadioButton extends DriverSetup {
	String bUrl = "https://jqueryui.com/checkboxradio";
	
	@Test
	public void RadioBtnAndCheckBoxInFrame() throws InterruptedException {
		driver.get(bUrl);
		driver.manage().window().maximize();
		new WebDriverWait(driver, Duration.ofSeconds(10));//if there any error don't close immediate, wait 10 sec.
		
		//Switch to frame
		//generally radio button, check box etc are inside the frame.
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//label[contains(@for,'radio-2')]")).click();
		driver.findElement(By.xpath("//label[@for='checkbox-1']")).click();

		Thread.sleep(3000);
		
		driver.switchTo().parentFrame();
	}

}
