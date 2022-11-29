package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverSetup {

	public static WebDriver driver = null;//Interface of selenium.
	
	@BeforeSuite //annotation of testNG
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//		driver= new FirefoxDriver();
		
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
