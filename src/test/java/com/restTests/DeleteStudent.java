package com.restTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class DeleteStudent extends TestBase{

	@DisplayName("Delete Student")
	@Test
	public void deleteStudent()
	{
		RestAssured
		.given()
		.when()
		.delete("/100")
		.then().statusCode(204);
	}
}
