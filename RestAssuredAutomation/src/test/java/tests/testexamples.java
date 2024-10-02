package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testexamples {
	@Test
	public void test_1() {
	Response response=	RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println("Statuscode=" + response.getStatusCode());
	System.out.println("time=" + response.getTime());
	System.out.println("Body=" + response.getBody().asString());
	
	int statusCode=response.getStatusCode();
	Assert.assertEquals(statusCode,200);
	}
	
	@Test
	public void test_2() {
		baseURI= "https://reqres.in/api";
		given().
			get("/users?page=2").
			then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
			log().all();
		}
	

}
