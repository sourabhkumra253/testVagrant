package TestVagrant.WebTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestVagrant.constants.Constants;
import TestVagrant.pageObjects.HomePageObjects;
import TestVagrant.pageObjects.WeatherPageObjects;
import TestVagrant.services.NavigateToWeatherPage;
import TestVagrant.utility.TestsBaseClass;

public class NdtvWeatherWebAppNormalTests extends TestsBaseClass {
	
	HomePageObjects homePageObjects = new HomePageObjects(getDriver());
	WeatherPageObjects weatherPageObjects = new WeatherPageObjects(getDriver());
	NavigateToWeatherPage navigate = new NavigateToWeatherPage();
	
	
	@Test
	public void testUserAbleToNavigateWeatherPage() throws InterruptedException {
		
		navigate.getWeatherPage(homePageObjects);
		Assert.assertEquals(getDriver().getTitle(), Constants.WEATHER_PAGE_TITLE);
		Assert.assertEquals(getDriver().getCurrentUrl(), Constants.WEATHER_PAGE_URL);
	}
	

}
