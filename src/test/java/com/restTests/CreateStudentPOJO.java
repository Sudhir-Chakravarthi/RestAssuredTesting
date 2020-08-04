package com.restTests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentPOJO.StudentPOJO;

import io.restassured.http.ContentType;

public class CreateStudentPOJO extends TestBase {

//	@DisplayName("Create a new student by sending payload as an object")
//	@Test
	void createNewStudent() {

		StudentPOJO student = new StudentPOJO();
		Faker faker = new Faker();
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");

		student.setFirstName(faker.name().firstName());
		student.setLastName(faker.name().lastName());
		student.setEmail(faker.internet().emailAddress());

		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	}
	
	
	
//	@DisplayName("Uppdating a student by sending payload as an object")
//	@Test
	void UpdateStudentPUTRequest() {

		StudentPOJO student = new StudentPOJO();
		Faker faker = new Faker();
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");

		student.setFirstName(faker.name().firstName());
		student.setLastName(faker.name().lastName());
		student.setEmail(faker.internet().emailAddress());

		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/100")
		.then()
		.statusCode(200);
	}
	
//	@DisplayName("Create a new student by sending payload as an object")
//	@Test
	void partialDataUpdatingPATCHRequest() {

		StudentPOJO student = new StudentPOJO();
		Faker faker = new Faker();
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		
		student.setEmail(faker.internet().emailAddress());

		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/100")
		.then()
		.statusCode(200);
	}
	
}
