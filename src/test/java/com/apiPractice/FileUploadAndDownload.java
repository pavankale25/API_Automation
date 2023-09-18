package com.apiPractice;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
public class FileUploadAndDownload {
	
	public void singleFileUpload() {
	File myfile = new File("C:\\Users\\IPS-52\\Downloads\\DWSample1-TXT.txt");
	given()
	     .multiPart("file",myfile)
	     .contentType("multipart/form-data")
	.when()
	     .post("url")
	.then()
	     .statusCode(201)
	     .body("filename", equalTo("abc.txt"))
	     .log().all();

}
}




//











//6 ,7 - 5 hrs I have take this chalenge
