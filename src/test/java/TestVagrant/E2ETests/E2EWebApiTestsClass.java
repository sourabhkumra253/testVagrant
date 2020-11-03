package TestVagrant.E2ETests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestVagrant.pageObjects.HomePageObjects;
import TestVagrant.pageObjects.WeatherPageObjects;
import TestVagrant.utility.Constants;
import TestVagrant.utility.PropertyFileReader;
import TestVagrant.utility.RestAssuredExecutors;
import TestVagrant.utility.WebDriverExecutor;

public class E2EWebApiTestsClass {
	
	WebDriver driver = WebDriverExecutor.getDriver();
	HomePageObjects homePageObjects = new HomePageObjects(driver);
	WeatherPageObjects weatherPageObjects = new WeatherPageObjects(driver);
	int TemperatureMinThreshold = Integer.parseInt(PropertyFileReader.getConfigProperty("TEMPERATURE_MINTHRESHOLD"));
	int TemperatureMaxThreshold = Integer.parseInt(PropertyFileReader.getConfigProperty("TEMPERATURE_MAXTHRESHOLD"));

	@Test
	public void getWeather() throws Exception {
		
		
		homePageObjects.waitForElement(homePageObjects.getnewsAlertPopup());
		homePageObjects.clickOnNewsAlertPopup();
		homePageObjects.clickOnSubMenuDots();
		homePageObjects.clickOnWeatherLink();
		
		weatherPageObjects.sendKeysOnweatherPageSearchBox(PropertyFileReader.getConfigProperty("CITY_NAME"));
		Thread.sleep(2000);
		weatherPageObjects.clickOncheckBoxForSearchCity();
		String temperature = weatherPageObjects.getTextFromWeatherLabel().substring(0, 2);
		int ndtvTemp = Integer.parseInt(temperature);
		System.out.println("------------NDTV " + temperature); 
		
		
		HashMap<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("q", "karnal");
		queryMap.put("appid", "7fe67bf08c80ded756e598d6f8fedaea");
		queryMap.put("units", "Metric");
		
		JSONObject response = RestAssuredExecutors.getRequestExecute(queryMap);
		int temperatureAPI = response.getJSONObject("main").getInt("temp");
		System.out.println("--------API " +String.valueOf(temperatureAPI).substring(0, 2));
		
		int DifferenceInTemperature = ndtvTemp - temperatureAPI;
		System.out.println("***** diff "+DifferenceInTemperature);
		
		if (DifferenceInTemperature >= TemperatureMinThreshold &&  DifferenceInTemperature <=TemperatureMaxThreshold) {
			System.out.println("---__+++++Temperature is within range");
		}
		else {
			throw new Exception("+++++++++ not in range");
		}
	}
	
	
	@Test
	public void getString() {
		String a = "Karnal, Haryana\n" + 
				"Condition : Clear\n" + 
				"Wind: 4.44 KPH Gusting to 4.82 KPH\n" + 
				"Humidity: 18%\n" + 
				"Temp in Degrees: 29\n" + 
				"Temp in Fahrenheit: 84".trim();
		String [] arr = a.split(":|\\,|\\\n");
		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i =0;i<arr.length-1;) {
			hm.put(arr[i], arr[i+1]);
			i = i+2;
			

		}
		for (Map.Entry hmp : hm.entrySet()) {
			System.out.println(hmp.getKey().toString().trim());
			System.out.println(hmp.getValue().toString().trim());
		}
		System.out.println(hm.get("Condition "));

	}

}
