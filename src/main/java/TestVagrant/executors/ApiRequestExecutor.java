package TestVagrant.executors;

import java.util.HashMap;

import org.json.JSONObject;

import TestVagrant.constants.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiRequestExecutor {
	
	
	public static JSONObject getRequestExecute(HashMap<String, String> queryParams) {
		
		RestAssured.baseURI= Constants.WEATHER_API_URI;
		RestAssured.basePath= Constants.WEATHER_API_BASEPATH;
		RequestSpecification requestSpecification = RestAssured.given().log().all();
		Response response = requestSpecification.queryParams(queryParams).get();
		// Parsing response as JSONObject 
		JSONObject responseAsJson = new JSONObject(response.asString());
		return responseAsJson;
		
	}

}
