package TestVagrant.ApiTests;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestVagrant.constants.Constants;
import TestVagrant.constants.HttpStatusCodes;
import TestVagrant.executors.ApiRequestExecutor;

public class WeatherApiExceptionTests {
	
		ApiRequestExecutor apiRequestExecutor = new ApiRequestExecutor();
		HashMap<String, String> queryMap = new HashMap<String, String>();
		
		
		
	@Test
	public void validatingWeatherApiWithInvalidAppId() {
		
		queryMap.put("q", "karnal");
		queryMap.put("appid", "fe67bf08c80ded756e598d6f8fedaea");
		queryMap.put("units", "Metric");
		JSONObject response = apiRequestExecutor.getRequestExecute(queryMap);
		Assert.assertEquals(response.get("cod").toString(), HttpStatusCodes.UNAUTHORIZED.getCode());
		
	}
	
	@Test (dependsOnMethods = "validatingWeatherApiWithInvalidAppId" )
	public void validatingWeatherApiWithInvalidCity() {
		queryMap.put("appid", "7fe67bf08c80ded756e598d6f8fedaea");
		queryMap.put("q", "abc");
		JSONObject response = apiRequestExecutor.getRequestExecute(queryMap);
		Assert.assertEquals(response.get("cod").toString(), HttpStatusCodes.NOTFOUND.getCode());
		Assert.assertEquals(response.get("message"), Constants.CITY_NOT_FOUND_MESSAGE);
		
	}
		

}
