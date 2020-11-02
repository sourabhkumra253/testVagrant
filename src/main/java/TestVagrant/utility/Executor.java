package TestVagrant.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Executor {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver ==null) {
			System.setProperty("webdriver.chrome.driver", "/Users/sourabhkumra/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		
		return driver;
	}

}
