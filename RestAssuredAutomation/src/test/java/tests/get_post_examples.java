package tests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;

public class get_post_examples {
	@Test
	public void testGet() {
	
		baseURI ="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George","Rachel"));	
	}
	@Test
	public void TestPost() {
		Map<String, Object> map= new HashMap<String, Object>();
		//map.put("name", "xyz");
		//map.put("job", "tester");
		//System.out.println(map);
		JSONObject request =new JSONObject();
		request.put("name", "xyz");
		request.put("job", "tester");
		System.out.println(request.toJSONString());
		baseURI ="https://reqres.in/api";
		given().
			header("content-type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON). 
			body(request.
			toJSONString()).
			when().
			post("/users").
			then().
			statusCode(201).
			log().all();
		}

}
