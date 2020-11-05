package TestVagrant.utility;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import TestVagrant.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestsBaseClass {

	public WebDriver driver;

	@BeforeClass
	public WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().arch64().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.navigate().to(Constants.HOME_PAGE_URL);

		}

		return driver;

	}

	@BeforeMethod
	public void getMehtodName(Method testMethod) {

		System.out.println("Going to run test " + testMethod.getName() + " " + java.time.LocalTime.now());
	}

	@AfterClass
	public void afterTest() throws InterruptedException {
		System.out.println("-------Test ended---------" + java.time.LocalTime.now());
		driver.close();
		driver = null;

		Thread.sleep(5000);

	}

}
