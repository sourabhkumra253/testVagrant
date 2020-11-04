package TestVagrant.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestVagrant.utility.PageObjectBaseClass;

public class HomePageObjects extends PageObjectBaseClass {
	
	public HomePageObjects(WebDriver driver) {
		super(driver);
	}

	private By newsAlertPopup = By.xpath("//a[contains(text(),'No Thanks')]");
	private By subMenuDots = By.xpath("//a[@id ='h_sub_menu']");
	private By weatherLink = By.xpath("//a[contains(text(),'WEATHER')]");

	public void clickOnNewsAlertPopup() {
		this.getDriver().findElement(newsAlertPopup).click();

	}

	public void clickOnSubMenuDots() {
		this.getDriver().findElement(subMenuDots).click();
	}

	public void clickOnWeatherLink() {
		this.getDriver().findElement(weatherLink).click();
	}
	
	public By getnewsAlertPopup() {
		return newsAlertPopup;
	}
	
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
