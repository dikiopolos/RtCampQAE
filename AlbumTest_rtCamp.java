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

public class AlbumTest_rtCamp {
	
	WebDriver driver;
	String browserType = "firefox";
	String login = "demo";
	String pass = "demo";
	String albumName = "test album";
	
	// *** CHANGE TO YOUR LOCAL PATH
	String mediaPath = "C:\\Users\\dikio\\eclipse-workspace\\RtCampQAE\\src\\media\\";
	
	String media1 = "giraffe1.jpeg";
	String media2 = "mountains1.jpeg";
	String media3 = "volcano1.jpeg";
	String media4 = "balloons1.jpeg";
	String media5 = "wildflowers1.jpeg";
	
	
		
	@Test
	public void albumTest() throws Exception {
		
	// TEST: ADD NEW ALBUM + ADD FILES + CONFIRM PRIVACY
		
		// Login
		driver.findElement(By.id("bp-login-widget-user-login")).sendKeys(login);
		driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys(pass);
		driver.findElement(By.id("bp-login-widget-submit")).click();
		
		
		// ADD NEW ALBUM
		
		WebElement e1 = driver.findElement(By.id("item-meta"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
				
		driver.findElement(By.xpath("//div[@class='clicker rtmedia-action-buttons']")).click();
		driver.findElement(By.xpath("//a[@title='Create New Album']")).click();
		
		driver.findElement(By.id("rtmedia_album_name")).sendKeys(albumName);
		driver.findElement(By.id("rtmedia_create_new_album")).click();
		driver.findElement(By.xpath("//button[@title='Close (Esc)']")).click();
		driver.findElement(By.id("rtmedia-nav-item-music")).click();
		
		
		// UPLOAD 5 MEDIA FILES TO NEW ALBUM.  SET PRIVACY TO 'PRIVATE'.
		
		WebElement e2 = driver.findElement(By.xpath("//h2[@class='rtm-gallery-title']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e2);
		
		driver.findElement(By.id("rtm_show_upload_ui")).click();
		driver.findElement(By.xpath("//select[@name='album']")).click();
		driver.findElement(By.xpath("//option[contains(text(), 'test album')]")).click();
		driver.findElement(By.id("rtSelectPrivacy")).click();
		driver.findElement(By.xpath("//option[@value='60']")).click();
		
		driver.findElement(By.xpath("//input[@type='file']"))
		.sendKeys(mediaPath+media1 + "\n" + mediaPath+media2 + "\n" + mediaPath+media3 + "\n" + mediaPath+media4 + "\n" + mediaPath+media5);
		Thread.sleep(3000);
		
		WebElement e3 = driver.findElement(By.id("drag-drop-area"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", e3);
		driver.findElement(By.id("rtSelectPrivacy")).click();
		driver.findElement(By.xpath("//option[@value='60']")).click();
		
		driver.findElement(By.xpath("//div[@id='drag-drop-area']/input[@value='Start upload']")).click();
		Thread.sleep(3000);
		
		// Confirm Privacy is set to 'private'
	
		driver.findElement(By.id("rtmedia-nav-item-albums")).click();
		driver.findElement(By.xpath("//h4[contains(.,'test album')]")).click();
		
		WebElement e4 = driver.findElement(By.id("rtm_show_upload_ui"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e4);
		
		driver.findElement(By.xpath("//img[contains(@alt,'balloons1')]")).click();
		
		WebElement imgPop =driver.findElement(By.xpath("//i[@title='Only you']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(imgPop).click();
					
		boolean actualPrivacy = driver.findElement(By.xpath("//i[@title='Only you']")).isDisplayed();
		Assert.assertTrue(actualPrivacy);
		System.out.println("CONFIRM Media Privacy Setting = 'Private': " + actualPrivacy);
	
	}
	
		
	@Before
	public void setUp() {
		System.out.println("Starting test");
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://qa.rtcamp.net/members/demo/media/album/");
	}
	
	@After
	public void tearDown() {
		System.out.println("Ending Test");
		//driver.quit;
	}
	
	
	
	
	
}
