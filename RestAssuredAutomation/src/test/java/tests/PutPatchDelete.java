package tests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDelete {
	@Test
	public void TestPut() {				
		JSONObject request =new JSONObject();
		request.put("name", "xyz");
		request.put("job", "tester");
		System.out.println(request.toJSONString());
		baseURI ="https://reqres.in/api";
		given().
			header("content-type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON). 
			body(request.toJSONString()).
			when().
			put("/users/2").
			then().
			statusCode(200).
			log().all();
		}
	@Test
	public void TestPatch() {				
		JSONObject request =new JSONObject();
		request.put("name", "xyz");
		request.put("job", "tester");
		System.out.println(request.toJSONString());
		baseURI ="https://reqres.in/api";
		given().
			header("content-type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON). 
			body(request.toJSONString()).
			when().
			patch("/api/users/2").
			then().
			statusCode(200).
			log().all();

	}
	
	@Test
	public void TestDelete() {				
		baseURI ="https://reqres.in/api";
			when().
			delete("/api/users/2").
			then().
			statusCode(204).
			log().all();

	}
}
