package com.apiPractice;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import com.github.javafaker.Faker;
public class FakerDataGenerator {
	@Test
	void generateDummyData() {
		Faker faker = new Faker();
		String first_name = faker.name().firstName();
		String phone_number = faker.phoneNumber().cellPhone();
		String email = faker.internet().safeEmailAddress();
		String username = faker.name().username();
		String pass = faker.internet().password();
		System.out.println("First name is " + first_name);
		System.out.println("phone_number is " + phone_number);
		System.out.println("email address is " + email);
		System.out.println("username is " + username);
		System.out.println("password is " + pass);
	}
	
//
}
 