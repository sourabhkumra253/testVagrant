package TestVagrant.executors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestVagrant.constants.Constants;

public class WebDriverExecutor {
	
	public WebDriver driver;
	// Fore singleton if all test cases need to be run with one driver instance
	// Not using in current cases to support parallel cases
	public WebDriver getDriver() {
		
		// Check only one instance of driver should be there
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "driver//chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.navigate().to(Constants.HOME_PAGE_URL);

		}
		
		return driver;
	}
	
	public void getQuitDriver() {
		driver.quit();
		driver = null;
		
	}

}
