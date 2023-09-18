package com.apiPractice;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.*;
public class ParsingXMLResponse {
@Test
	void testXMLResponse() {
	
	//Approach - 1
	/*	given()
		
		.when()
		      .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		    .statusCode(200)
		    .header("Content-Type","application/xml; charset=utf-8")
		    .body("TravelerinformationResponse.page", equalTo("1"))
		    .body("TravelerinformationResponse.travelers.Travelerinformation.email[0]", equalTo("Developer12@gmail.com"));*/
		 
		
	/*	//Approach - 2 
		Response rsp = given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(rsp.getStatusCode(), 200);
		String pageNo = rsp.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");*/
	
	
	Response rsp = given()
			
			.when()
		      .get("http://restapi.adequateshop.com/api/Traveler?page=1");
	XmlPath xmlobject = new XmlPath(rsp.asString());
	List<String> travellers = xmlobject.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	//Assert.assertEquals(travellers.size(), 10);
	boolean status = false;
	for(String name:travellers) {
		//System.out.println(name);
		if(name.equals("AS")) {
			status=true;
			break;
		}
		
	}
	Assert.assertEquals(status, true);
	
	}
}
