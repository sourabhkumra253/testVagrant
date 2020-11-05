package TestVagrant.E2ETests;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestVagrant.constants.HttpStatusCodes;
import TestVagrant.executors.ApiRequestExecutor;
import TestVagrant.pageObjects.HomePageObjects;
import TestVagrant.pageObjects.WeatherPageObjects;
import TestVagrant.utility.PropertyFileReader;
import TestVagrant.utility.TemperatureComparator;
import TestVagrant.utility.TestsBaseClass;

public class E2EWebApiTestsClass extends TestsBaseClass {
	
	HomePageObjects homePageObjects = new HomePageObjects(getDriver());
	WeatherPageObjects weatherPageObjects = new WeatherPageObjects(getDriver());
	int TemperatureMinThreshold = Integer.parseInt(PropertyFileReader.getConfigProperty("TEMPERATURE_MINTHRESHOLD"));
	int TemperatureMaxThreshold = Integer.parseInt(PropertyFileReader.getConfigProperty("TEMPERATURE_MAXTHRESHOLD"));
	String appId = PropertyFileReader.getConfigProperty("AppId");
	String cityName = PropertyFileReader.getConfigProperty("CITY_NAME");
	
	
	/**
	 * E2E test case covers below steps :
	 * 
	 * 1. Open browser & Navigate to Ndtv.com
	 * 2. Go to weather page, Search for city - Karnal in this case
	 * 3. fetch the weather information for the given city
	 * 4. Now execute the weather API while setting the queryParams
	 * 5. Set unit to metric (celcius)
	 * 6. Fetch temperature from the API response
	 * 7. Compare the values of temperatures from NDTVWebApp & WeatherAPI w.r.t 
	 * 		minumum & max threshold
	 */
	@Test
	public void compare_NdtvWeatherTemp_And_WeatherApiTemp_For_A_GivenCity_Test() throws Exception {
		
		// Actions on NDTV Home Page
		homePageObjects.waitForElement(homePageObjects.getnewsAlertPopup());
		homePageObjects.clickOnNewsAlertPopup();
		homePageObjects.clickOnSubMenuDots();
		homePageObjects.clickOnWeatherLink();
		// Actions on Weather page
		weatherPageObjects.sendKeysOnweatherPageSearchBox(cityName);
		Thread.sleep(2000);
		weatherPageObjects.clickOncheckBoxForSearchCity();
		String temperatureFromNdtv_WEB = weatherPageObjects.getTextFromWeatherLabel().substring(0, 2);
		// Parsing to int to do the calculation later
		int temperature_WEB = Integer.parseInt(temperatureFromNdtv_WEB);
		
		// Preparing queryParameters for the Get Request
		HashMap<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("q", cityName);
		queryMap.put("appid", appId);
		queryMap.put("units", "Metric");
		// Executing the api request to get JSON Object response
		JSONObject response = ApiRequestExecutor.getRequestExecute(queryMap);
		Assert.assertEquals(response.get("cod").toString(), HttpStatusCodes.SUCCESS.getCode());
		// fetching temperature from Response
		int temperature_API = response.getJSONObject("main").getInt("temp");
		//System.out.println("--------API " +String.valueOf(temperature_API).substring(0, 2));
		
		
		// Calculating the difference between the temp of WebApp & Api
		TemperatureComparator.getTemperatureDifferenceThreshold(temperature_WEB, temperature_API);
	}
	
	
	@Test (enabled = false)
	public void compare_Humidity_And_WeatherCondition_WebAndApi_For_A_GivenCity_Test() {
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
