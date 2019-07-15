package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    // This method returns a WebDriver object
    public static WebDriver open(String browserType) {
    	
    	
    	// *** CHANGE TO YOUR LOCAL PATH ***
    	String driverPath = "C:\\Users\\dikio\\eclipse-workspace\\RtCampQAE\\src\\utilities\\";

    	
        // Code for Firefox
        if (browserType.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
            return new FirefoxDriver();
        }

        // Code for Chrome
        else if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
            return new ChromeDriver();
        }
        
        // Code for Edge
        else if (browserType.equalsIgnoreCase("edge")) {
        	System.setProperty("webdriver.edge.driver", driverPath+"MicrosoftWebDriver.exe");
        	return new EdgeDriver();
        }
        return null;
    }
}
