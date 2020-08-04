package com.student.loggingExamples;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.restTests.TestBase;

public class LogginResponseValues extends TestBase{

	@DisplayName("Logging the Response Information")
	@Test
		public void test002() {
			System.out.println("-------------Logging Response Information-------------------");
			given()
			.param("programme", "Computer Science")
			.param("limit",1)
			.log()
			.params()
			.when()
			.get("/list")
			.then()
			.statusCode(200);
		}
}
