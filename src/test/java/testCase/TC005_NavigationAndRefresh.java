package testCase;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC005_NavigationAndRefresh extends DriverSetup{
	
	public static String bUrl = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple"; 
	
	@Test
	public void Navigating_Refresh() throws InterruptedException {
		driver.get(bUrl);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

}
