package com.student.loggingExamples;

import com.github.javafaker.Faker;
import com.restTests.TestBase;
import com.studentPOJO.StudentPOJO;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoggingRequestValues extends TestBase{

	//@Test
	public void test001() {
		System.out.println("-------------Printing Request Headers-------------------");
		given()
		.log()
		.headers()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
	}
	
	//@Test
	public void test002() {
		System.out.println("-------------Printing Request Parameters-------------------");
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
	
	//@DisplayName("Create a new student by sending payload as an object")
	//@Test
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
		.log()
		.body()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	}
	
	//@DisplayName("Log All The Details")
	//@Test
		public void logAllRequestDetails() {
			System.out.println("-------------Printing Request Parameters-------------------");
			

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
			.log()
			.all()
			.when()
			.contentType(ContentType.JSON)
			.when()
			.body(student)
			.post()
			.then()
			.statusCode(201);
		}
	
	@DisplayName("Log All The Details")
	@Test
		public void logRequestDetailsIfTestFails() {
			System.out.println("-------------Printing Request Parameters-------------------");
			

			StudentPOJO student = new StudentPOJO();
			Faker faker = new Faker();
			List<String> courses = new ArrayList<String>();
			courses.add("Java");
			courses.add("C++");

			student.setFirstName("Loue");
			student.setLastName("Hahns");
			student.setEmail("nubsia.raynor@yahoo.com");

			student.setProgramme("Computer Science");
			student.setCourses(courses);

			given()
			.log()
			.ifValidationFails()
			.when()
			.contentType(ContentType.JSON)
			.when()
			.body(student)
			.post()
			.then()
			.statusCode(201);
		}
	
	
}
