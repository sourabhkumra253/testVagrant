package TestVagrant.ApiTests;

import static org.testng.Assert.assertNotNull;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestVagrant.constants.HttpStatusCodes;
import TestVagrant.executors.ApiRequestExecutor;
import TestVagrant.utility.PropertyFileReader;

public class WeatherApiNormalTests {
	
	
	ApiRequestExecutor apiRequestExecutor = new ApiRequestExecutor();
	HashMap<String, String> queryMap = new HashMap<String, String>();
	String city = PropertyFileReader.getConfigProperty("CITY_NAME");
	
	@Test
	public void whenAllQueryParamsAreValid_WeatherApi_Test() {
		queryMap.put("q", city);
		queryMap.put("appid", "7fe67bf08c80ded756e598d6f8fedaea");
		queryMap.put("units", "Metric");
		// Executing the api request to get JSON Object response
		JSONObject response = ApiRequestExecutor.getRequestExecute(queryMap);
		Assert.assertEquals(response.get("cod").toString(), HttpStatusCodes.SUCCESS.getCode());
		// Assert temperature object notNull
		assertNotNull(response.get("main"));
	}

}
