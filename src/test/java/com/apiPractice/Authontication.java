package com.apiPractice;
import org.json.JSONTokener;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
public class Authontication{
	//@Test
	void testBasicAuthentication() {
		given()
		     .auth().basic("postman", "password")   //Basic Authentication
		.when()
		     .get("http://postman-echo.com/basic-auth")
		.then()
		      .statusCode(200)
		      .body("authenticated", equalTo(true))
		      .log().all();
	}
	@Test
	void testDigestAuthentication() {
		given()
		     .auth().digest("postman", "password")
		.when()
		     .get("http://postman-echo.com/basic-auth")
		.then()
		      .statusCode(200)
		      .body("authenticated", equalTo(true))
		      .log().all();
	}
	                                
	//@Test
	void testPreemptiveAuthentication() {
		given()
		     .auth().preemptive().basic("postman", "password")   //Preemptive authentication
		.when()
		     .get("http://postman-echo.com/basic-auth")
		.then()
		      .statusCode(200)
		   //   .body("authenticated", equalTo(true))
		      .log().all();    //headers, cookies, response body
	}
	
	void bearerTokenAuthentication() {
		String bearer_token = "url";    //
		given()
		      .headers("authorization", "Bearer " + bearer_token)
		.when()
		      .get("https://api.github/users/repos")
		.then()
		      .statusCode(200);                
	}//t 
	
	void testOauth1Authentication() {   //This is oauth 1 authentication
		given()
		      .auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrate")
		.when()
		      .get("url")
		.then()
		      .statusCode(200);
	}//
	void testOAuth2Authentiction() {
		given()
		      .auth().oauth2("acces token")  
		.when()
		      .get("url")
		.then()
		      .statusCode(200);
	}


}



 
