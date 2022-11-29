package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC001_LocatorLearning extends DriverSetup{
	static String baseUrl = "https://rahulshettyacademy.com/locatorspractice/";
	
	@Test
	public void locatorLearnig() throws Exception {
		
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		//There are 8 way to find location.
		//{id,name,class name,css selector,link text,xpath,tag name,partial link text}
		
		// using ID= By.id("value")
		// driver.findElement(By.id("inputUsername"));
		
		//relative xpath=//tagName[@attribute='value']. using double slash '//' 
		//absolute xpath: for absolute xpath we use single slash '/'.
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Abdul Karim");
		Thread.sleep(2000);
		
		//using name
		driver.findElement(By.name("inputPassword")).sendKeys("password");
		Thread.sleep(2000);
		
		//using className: here class name was 'submit signInBtn'.full name or space occur failure.
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		
		//In css selector: here use class name and id,
		// for class name: tagName.value
		//for id: tagName#value
		String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorMessage);
		
		//linkText: to identify link text there should be 'href'.
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		
		// Xpath
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Karim");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("Karim@mail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("017");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(2000);
		
		// use method 
		String passwordString = getPassword(driver);
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("karim");
		//driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(passwordString);
		
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(2000);
	}
	
	// extract password dynamically.
	public static String getPassword(WebDriver driver) throws InterruptedException {
		//driver.get(baseUrl);
		//driver.findElement(By.linkText("Forgot your password?")).click();
		//Thread.sleep(2000);
		
		//driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText= driver.findElement(By.cssSelector(".infoMsg")).getText();
		
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'");
		
		//String[] passwordArray2=passwordArray[1].split("'");
		//String password=passwordArray2[0];
		
		String password = passwordArray[1].split("'")[0];
		return password;
		
	}

}















