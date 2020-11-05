package TestVagrant.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestVagrant.utility.PropertyFileReader;

public class WeatherPageObjects {

	WebDriver driver;
	
	public WeatherPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	String city =PropertyFileReader.getConfigProperty("CITY_NAME");
	
	private By weatherPageSearchBox = By.id("searchBox");
	private By checkBoxForSearchCity = By.xpath("*//label[contains(text(),'"+city+"')]");
	private By weatherLabelOnMap = By.xpath("//div[@class='outerContainer' and @title='Karnal']");
	private By zoomButtonOnMap = By.xpath("//a[@title='Zoom in']");
	private By DetailedWeatherDiv = By.xpath("//div[@class ='outerContainer' and @title='Karnal']");
	
	
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
	
	public void clickOnZoomButtonMap() {
		driver.findElement(zoomButtonOnMap).click();
	}
	
	public void clickOnDetailedWeatherDiv() {
		driver.findElement(DetailedWeatherDiv).click();
	}
}
