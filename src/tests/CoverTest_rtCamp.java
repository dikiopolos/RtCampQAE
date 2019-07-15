package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoverTest_rtCamp {
	WebDriver driver;
	String browserType = "firefox";
	String login = "demo";
	String pass = "demo";
	
	// *** CHANGE TO YOUR LOCAL PATH ***
	String mediaPath = "C:\\Users\\dikio\\eclipse-workspace\\RtCampQAE\\src\\media\\";
	
	String newCover1 = "ocean1.jpeg";
	String logo1 = "rtcamp1.jpeg";
	String expectedStatus = "Your new cover image was uploaded successfully.";
	
	
	@Test
	public void coverTest() throws Exception {
		
	// TEST ADD NEW ALBUM & ADD FILES TO ALBUM
		
		// Login
		driver.findElement(By.id("bp-login-widget-user-login")).sendKeys(login);
		driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys(pass);
		driver.findElement(By.id("bp-login-widget-submit")).click();
	
		
		// Change Cover Image
		
		WebElement e1 = driver.findElement(By.id("latest-update"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
		
		driver.findElement(By.id("user-xprofile")).click();
		
		WebElement e2 = driver.findElement(By.id("user-xprofile"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e2);
		
		driver.findElement(By.id("change-cover-image")).click();
		
		driver.findElement(By.xpath("//div[@class='drag-drop-inside']//p[contains(text(),'or')]"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"); 
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(mediaPath+newCover1);

		WebElement e3 = driver.findElement(By.id("header-cover-image"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e3); 		
		Thread.sleep(3000);
		
		
		// Get Confirmation That Cover Image Updated Successfully
		
		String actualStatus = driver.findElement(By.id("bp-cover-image-feedback")).getText();
		if (actualStatus.equals(expectedStatus)) {
			System.out.println("CONFIRM: " + actualStatus);
		}
		else {
			System.out.println("TEST FAILED");
		}
		
		
		// Switch Cover Image to rtCamp Logo
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(mediaPath+logo1);
		
		WebElement e4 = driver.findElement(By.id("header-cover-image"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e4); 		
		Thread.sleep(3000);
	}	
		
	@Before
	public void setUp() {
		System.out.println("Starting test");
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://qa.rtcamp.net/members/demo/");
	}
	
	@After
	public void tearDown() {
		System.out.println("Ending test");
		//driver.quit;
	}
		
}
