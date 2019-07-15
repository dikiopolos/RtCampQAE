package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginTest_rtCamp {
	
	WebDriver driver;
	String browserType = "firefox";
	String login = "demo";
	String goodPW = "demo";
	String badPW = "badpw";
	String expectedTitle = "Activity – rtCamp";
	
	@Test
	
	// TEST LOGIN WITH VALID AND INVALID CREDENTIALS
	
	public void LoginTest() {
		
		// VALID CREDENTIALS TEST
		
		driver.findElement(By.id("bp-login-widget-user-login")).sendKeys(login);
		driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys(goodPW);
		driver.findElement(By.id("bp-login-widget-submit")).click();
		String actualTitle1 = driver.getTitle();
		System.out.println("CONFIRM Valid Credentials Returns Page: " + actualTitle1);
		
		if (actualTitle1.contentEquals(expectedTitle)) {
			System.out.println("CONFIRM Successful Login - TEST1 PASSED");
		}
		else {
			System.out.println("TEST1 FAILED");
		}
		
		driver.findElement(By.xpath("//a[@class='logout']")).click();
		
		
		// INVALID CREDENTIALS TEST
		
		driver.findElement(By.id("bp-login-widget-user-login")).sendKeys(login);
		driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys(badPW);
		driver.findElement(By.id("bp-login-widget-submit")).click();
		String loginFail = driver.findElement(By.id("login_error")).getText();
		System.out.println("CONFIRM Invalid Credentials Returns Error Msg: " +loginFail);
		String actualTitle2 = driver.getTitle();
		System.out.println("CONFIRM Invalid Credentials Returns Page: " + actualTitle2);
		
		if (actualTitle2.contentEquals(expectedTitle)) {
			System.out.println("CONFIRM User logged in with Invalid credentials - TEST2 FAILED");
		}
		else {
			System.out.println("CONFIRM User NOT logged in Invalid credentials - TEST2 PASSED");
		}
		
		
		// RE-ENTER CREDENTIALS ON REDIRECT PAGE TEST
		
		driver.findElement(By.id("user_pass")).sendKeys(goodPW);
		driver.findElement(By.id("wp-submit")).click();
		String actualTitle3 = driver.getTitle();
		System.out.println("CONFIRM Re-enter correct credentials returns page: " +actualTitle3);
		
		if (actualTitle3.contentEquals(expectedTitle)) {
			System.out.println("CONFIRM 2nd Login with valid credentials - TEST3 PASSED");
		}
		else {
			System.out.println("CONFIRM 2nd Login with valid credentials unsuccessful - TEST3 FAILED");
		}
		
	}
	
	
	@Before
	public void setUp() {
		System.out.println("Starting Test");
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://qa.rtcamp.net/activity/");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Ending test");
		//driver.quit();
	}

}