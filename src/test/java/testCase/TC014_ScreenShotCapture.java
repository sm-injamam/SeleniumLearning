package testCase;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import base.DriverSetup;

public class TC014_ScreenShotCapture extends DriverSetup {

	static String baseUrl = "https://www.ebay.com.au/";
	
	@Test
	public void takeSS() throws InterruptedException, IOException {
		
		Date currentDate = new Date();
		String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotFileName);
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// add apache commons io dependency.
		FileUtils.copyFile(screenShotFile, new File(".//screenshot//"+screenshotFileName+".png"));
		Thread.sleep(2000);
	}
}
