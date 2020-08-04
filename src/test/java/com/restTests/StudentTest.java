package com.restTests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StudentTest extends TestBase{

	@DisplayName("This is from Fetching the DB Details")
	@Test
	public void studentGet() {

		given()
		.when()
		.get("/list")	
		.then()
		.statusCode(200);
	}
	
	@Disabled
	@DisplayName("Sending Query Parameters")
	@Test
	public void studentDetailsWithQuesryParameters()
	{
		Map<String,Object> programmme = new HashMap<String,Object>();
		programmme.put("programme","Mechanical Engineering");
		programmme.put("limit",1);
		Response response = given()
		//.queryParam("programme","Mechanical Engineering")
		.queryParams(programmme)
		.when()
		.get("http://localhost:5555/student/list");
		
		System.out.println(response.prettyPrint());
	}
	
	@DisplayName("Get First Student Name from DB")
	@Test
	public void getFirstStudentDetail()
	{		
		Response response = 
		given()
		.pathParam("id",2)
		.when()
		.get("/{id}");
		
		response.prettyPrint();
		
		//RestAssured.reset();
	}
}
