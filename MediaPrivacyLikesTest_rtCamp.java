package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MediaPrivacyLikesTest_rtCamp {
	
	WebDriver driver;
	String browserType = "firefox";
	String login = "demo";
	String pass = "demo";
	String description = "media test";
	
	// *** CHANGE TO LOCAL PATH ***
	String mediaPath = "C:\\Users\\dikio\\eclipse-workspace\\RtCampQAE\\src\\media\\";
	
	String mediaFile = "trex.jpeg";
	
	
	@Test
	
	// TEST MEDIA UPLOAD & PRIVACY SETTING & LIKE/UNLIKE
		
	public void mediaPrivacy () throws Exception {
	
		// Login
		driver.findElement(By.id("bp-login-widget-user-login")).sendKeys(login);
		driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys(pass);
		driver.findElement(By.id("bp-login-widget-submit")).click();
			
		
		// ADD NEW POST WITH MEDIA UPLOAD. SET TO 'PRIVATE'
		
		driver.findElement(By.xpath("//textarea[@id='whats-new']")).sendKeys(description);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(mediaPath+mediaFile);
		driver.findElement(By.xpath("//select[@id='rtSelectPrivacy']//option[@value='60'][contains(text(),'Private')]")).click();
		driver.findElement(By.id("aw-whats-new-submit")).click();
		
		
		// VALIDATE PHOTO PRIVACY SETTINGS
		
		driver.findElement(By.linkText("demo")).click();
		WebElement e1 = driver.findElement(By.id("item-meta"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
				
		driver.findElement(By.id("media-personal-li")).click();
		WebElement e2 = driver.findElement(By.id("item-meta"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e2);
			
		driver.findElement(By.xpath("//img[contains(@alt,'trex')]")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			
		WebElement gpop=driver.findElement(By.xpath("//i[@title='Only you']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(gpop).click();
					
		boolean actualPrivacy = driver.findElement(By.xpath("//i[@title='Only you']")).isDisplayed();
		Assert.assertTrue(actualPrivacy);
		System.out.println("CONFIRM Media Privacy Setting = 'Private': " + actualPrivacy);
		
		
		
		
		// TEST MEDIA LIKE & UNLIKE FUNCTIONALITY
		
		boolean unlikedMedia = driver.findElement(By.xpath("//div[@class='like-button-no-comments']//span[contains(text(),'Like')]")).isDisplayed();
		Assert.assertTrue(unlikedMedia);
		System.out.println("CONFIRM Unliked Photo Displays 'Like' Button: " +unlikedMedia);
		
		driver.findElement(By.xpath("//div[@class='like-button-no-comments']//span[contains(text(),'Like')]")).click();
		String likedMedia = driver.findElement(By.xpath("//div[@class='like-button-no-comments']//span[contains(text(),'Unlike')]")).getText();
		System.out.println("CONFIRM Liked Photo Displays Button: " +likedMedia);
		Thread.sleep(2000);
		
		
		// VALIDATE 'LIKED' PHOTO APPEARS ON 'LIKED MEDIA' PAGE
		
		driver.findElement(By.xpath("//span[@title='Close (Esc)']")).click();
		driver.findElement(By.id("rtmedia-nav-item-user-likes")).click();
		
		WebElement e3 = driver.findElement(By.id("rtm_show_upload_ui"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e3);
		Thread.sleep(2000);
		
		boolean likedPhoto = driver.findElement(By.xpath("//img[contains(@alt,'trex')]")).isDisplayed();
		Assert.assertTrue(likedPhoto);
		System.out.println("CONFIRM 'Liked' photo is displayed on 'Liked Media' page: " + likedPhoto);
		Thread.sleep(3000);	
	
	}
			
	@Before
	public void setUp() {
		System.out.println("Starting test");
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://qa.rtcamp.net/activity/");
	}
		
	@After
	public void tearDown() {
		System.out.println("Ending test");
		//driver.quit
	}
}