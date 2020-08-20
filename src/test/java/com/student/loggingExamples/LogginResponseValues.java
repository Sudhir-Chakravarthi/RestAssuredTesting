package com.student.loggingExamples;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.restTests.TestBase;

public class LogginResponseValues extends TestBase{

	@DisplayName("Logging the Response Information")
	//@Test
		public void test002() {
			System.out.println("-------------Logging Response Information-------------------");
			given()
			.param("programme", "Computer Science")
			.param("limit",2)
			.when()
			.get("/list")
			.then()
			.log().headers()
			.statusCode(200);
		}
	
	@DisplayName("Logging the Response Status Line")
	//@Test
		public void test003() {
			System.out.println("-------------Logging Response Status Line-------------------");
			given()
			.param("programme", "Computer Science")
			.param("limit",2)
			.when()
			.get("/list")
			.then()
			.log().status()
			.statusCode(200);
		}
	
	
	@DisplayName("Logging the Response Body")
	//@Test
		public void test004() {
			System.out.println("-------------Logging Response Body-------------------");
			given()
			.param("programme", "Computer Science")
			.param("limit",2)
			.when()
			.get("/list")
			.then()
			.log().body()
			.statusCode(200);
		}
	
	@DisplayName("Loggin the response if there is a failure")
	@Test
	public void test005()
	{
		System.out.println("-------------Logging IN case if there is a failure -------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit",-1)
		.when()
		.get("/list")
		.then()
		.log().ifError()
		.statusCode(200);
	}
}
