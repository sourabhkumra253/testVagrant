package TestVagrant.utility;

import java.util.HashMap;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExecutors {
	
	
	public static JSONObject getRequestExecute(HashMap<String, String> queryParams) {
		
		RestAssured.baseURI= Constants.WEATHERAPIURI;
		RestAssured.basePath= Constants.WEATHERAPIBASEPATH;
		RequestSpecification requestSpecification = RestAssured.given().log().all();
		Response response = requestSpecification.queryParams(queryParams).get();
		JSONObject responseAsJson = new JSONObject(response.asString());
		return responseAsJson;
		
	}

}
