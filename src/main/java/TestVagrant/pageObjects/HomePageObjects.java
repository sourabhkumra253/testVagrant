package TestVagrant.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObjects {
	
	WebDriver driver;
	public HomePageObjects(WebDriver driver) {
		this.driver= driver;
	}

	private By newsAlertPopup = By.xpath("//a[contains(text(),'No Thanks')]");
	private By subMenuDots = By.xpath("//a[@id ='h_sub_menu']");
	private By weatherLink = By.xpath("//a[contains(text(),'WEATHER')]");

	public void clickOnNewsAlertPopup() {
		driver.findElement(newsAlertPopup).click();

	}

	public void clickOnSubMenuDots() {
		driver.findElement(subMenuDots).click();
	}

	public void clickOnWeatherLink() {
		driver.findElement(weatherLink).click();
	}
	
	public By getnewsAlertPopup() {
		return newsAlertPopup;
	}
	
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
