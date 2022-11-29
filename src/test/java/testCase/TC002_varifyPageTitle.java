package testCase;

import java.time.Duration;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.DriverSetup;

public class TC002_varifyPageTitle extends DriverSetup {
	
	public static String bUrl = "http://automationpractice.com/index.php";
	
	@Test(priority = 1)
	public void varifyPageTitle_ShouldPass() {
		driver.get(bUrl);
		new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		String titlefromWebSite = driver.getTitle();
		System.out.println("Title is: "+titlefromWebSite);
		
		//assertEquals(titleFromWebsite, "my store"); //replacement by soft assert
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(titlefromWebSite, "My Store");
		
		softAssert.assertAll();
	}
	
	@Test(priority = 2)
	public static void isWebsiteSecured() {
		String cUrl = driver.getCurrentUrl();
		if (cUrl.contains("https")) {
			System.out.println("Secured");
		}
		else {
			System.out.println("Not Secured");
		}
	} 
	

}











