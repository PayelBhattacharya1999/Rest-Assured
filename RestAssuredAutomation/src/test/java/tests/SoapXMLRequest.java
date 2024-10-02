package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.hamcrest.Matchers.equalTo;
public class SoapXMLRequest {
	@Test
	public void SoapValidate() throws IOException {
		
		InputStream file= SoapXMLRequest.class.getClassLoader().getResourceAsStream("SOAP/Add.xml");
		
		String requestBody=IOUtils.toString(file, "UTF-8");
		System.out.println(requestBody);
		baseURI="http://www.dneonline.com";
		given().contentType("text/xml").
		accept(ContentType.XML).
		body(requestBody).
		when().
		post("/calculator.asmx?op=Add").
		then()
		.statusCode(200).log().all().and().body("//*:AddResult.text()", equalTo("5"));
		
	}

}
