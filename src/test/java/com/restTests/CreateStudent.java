package com.restTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateStudent extends TestBase{

	@DisplayName("Creating a Student with POST Request")
	@Test
	public void createStudentDetails()
	{
		given()
		.when()
		.contentType(ContentType.JSON)
		.body("{\"firstName\":\"Sudhir\",\"lastName\":\"Chakravarthi\",\"email\":\"sudhir@gmail.com\",\"programme\":\"Software Engineer\",\"courses\":[\"Core Java\",\"Selenium\"]}")
		.when()
		.post()
		.then()
		.statusCode(201);
		
	}
	
	
}
