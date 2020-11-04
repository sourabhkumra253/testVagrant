package TestVagrant.executors;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestVagrant.constants.Constants;

public class WebDriverExecutor {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		// Check only one instance of driver should be there
		if (driver ==null) {
			System.setProperty("webdriver.chrome.driver", "/Users/sourabhkumra/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.navigate().to(Constants.URL);

		}
		
		
		return driver;
	}

}
