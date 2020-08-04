package com.restTests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentPOJO.StudentPOJO;

import io.restassured.http.ContentType;

public class StudentPatchRequest extends TestBase{

	@DisplayName("Create a new student by sending payload as an object")
	@Test
	void updaitngStudentPartially() {

		StudentPOJO student = new StudentPOJO();
		Faker faker = new Faker();
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		student.setEmail("nemakal-sudhir.chakravrthi@capgemini.com");
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/101")
		.then()
		.statusCode(200);
	}
}
