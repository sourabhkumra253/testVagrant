package TestVagrant.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherPageObjects {

	WebDriver driver;
	
	public WeatherPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	
	private By weatherPageSearchBox = By.id("searchBox");
	private By checkBoxForSearchCity = By.xpath("*//label[contains(text(),'Karnal')]");
	private By weatherLabelOnMap = By.xpath("//div[@class='outerContainer' and @title='Karnal']");
	
	
	public void sendKeysOnweatherPageSearchBox(String city) {
		
		driver.findElement(weatherPageSearchBox).click();
		driver.findElement(weatherPageSearchBox).sendKeys(city);
		
	}
	
	public void clickOncheckBoxForSearchCity() {
		driver.findElement(checkBoxForSearchCity).click();
	}
	
	public String getTextFromWeatherLabel() {
		String weatherText = driver.findElement(weatherLabelOnMap).getText();
		return weatherText;
	}
	
}
