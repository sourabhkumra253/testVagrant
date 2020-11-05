package TestVagrant.WebTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestVagrant.pageObjects.HomePageObjects;
import TestVagrant.pageObjects.WeatherPageObjects;
import TestVagrant.services.NavigateToWeatherPage;
import TestVagrant.utility.TestsBaseClass;

public class NdtvWeatherWebAppExceptionTests extends TestsBaseClass{

	HomePageObjects homePageObjects = new HomePageObjects(getDriver());
	WeatherPageObjects weatherPageObjects = new WeatherPageObjects(getDriver());
	NavigateToWeatherPage navigate = new NavigateToWeatherPage();

	
	
	@Test
	public void testWeatherPageIncorrectUrl() throws InterruptedException {

		navigate.getWeatherPage(homePageObjects);
		Assert.assertNotEquals(getDriver().getCurrentUrl(), "abc.com");

	}

}
