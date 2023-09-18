package com.apiPractice;

import org.json.JSONTokener;
import org.testng.annotations.Test;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.io.FileReader;
//1) Hashmap
//2) using org.json
//3) using POJO
//4) External json file
public class DiffWaysToCreateRequestBody {
	//post request body using hashmap
	@Test
	public void postusingHashmap() {
		
		HashMap hm = new HashMap();   //Object 
		hm.put("name", "Chaitanya");    
		hm.put("job", "QA");
		given()    //prerequisite
		  .contentType("application.json")   
		  .body(hm)
		
		.when()
		    .post("https://reqres.in/api/users")
		   
		.then()
		    .statusCode(201) 
		    .header("Content-Type", "application/json; charset=utf-8")
		    .log().all();	
	}
	//2) using json object
	//@Test
	public void postusingJsonLibrary() {
		JSONObject data = new JSONObject();
		data.put("name", "Prasad");
		data.put("Job", "SelForce Developer");
		given()       //Pre-requisite
		.contentType("application/json")
		.body(data.toString())   //convert json to string
		
		.when()     //request body
		    .post("https://reqres.in/api/users")
		   
		.then()      //Validation 
		    .statusCode(201) //Status code 
		    .header("Content-Type", "application/json; charset=utf-8") //Header Validation
		    .log().all();  //getting all data from body. (header,cookies and response body)
	}
	
	
	//3)post request body using POJO class       
	//@Test
	public void pojorequestbody() {
		Pojo_postrequest data = new Pojo_postrequest();
		data.setName("Chaitanya");
		data.setJob("QA");
		
		given()
	         .contentType("application/json")	
	         .body(data)
		.when()
		     .post("https://reqres.in/api/users")
		.then()
		     .statusCode(201)
		     .body("job",equalTo("QA"))
		     .log().all();   
	}
	
	//4) post request body using external json files
	
	@Test
	public void usingExternalJsonFile() throws FileNotFoundException {    //Using External Json file
		File f = new File("E:\\Java_7Program\\APIAutomation\\src\\test\\java\\body.json");   //Path of a file
		FileReader fr = new FileReader(f);   //File Read
		JSONTokener jt = new JSONTokener(fr); //
		JSONObject data = new JSONObject(jt);
		given()
        .contentType("application/json")	
        .body(data.toString())
	.when()
	     .post("https://reqres.in/api/users")
	.then()
	     .statusCode(201)
	    
	     .body("job",equalTo("Developer"))
	     .log().all();
	}

}
