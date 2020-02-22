package io.pivotal.shinyay

import io.pivotal.shinyay.entity.Gender
import io.pivotal.shinyay.entity.Person
import io.restassured.RestAssured
import io.restassured.RestAssured.get
import io.restassured.response.Response
import org.apache.commons.lang3.RandomStringUtils
import org.apache.commons.lang3.RandomUtils
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test
import com.google.common.truth.Truth.assertThat
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringLiveCodingApplicationTests(@LocalServerPort val port: Int) {

	val uri = "http://localhost:${port}/db/person"

	@Test
	fun whenGetAllPersons_thenOK() {
		get(uri).then()
				.assertThat()
				.statusCode(HttpStatus.OK.value())
	}

	@Test
	fun whenGetPersonById_thenOK() {
		get("$uri/1").then()
				.assertThat()
				.statusCode(HttpStatus.OK.value())
				.body("firstname", equalTo("Rei"))
	}

//	POST

	@Test
	fun whenCreatePerson_thenCreated() {
		val person = createPerson()
		println(person)
		val response: Response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(person)
				.post(uri)
		assertThat(response.statusCode).isEqualTo(HttpStatus.CREATED.value())
	}

	private fun createPerson(): Person = Person(
			RandomUtils.nextInt(10, 100),
			RandomStringUtils.randomAlphabetic(5),
			RandomStringUtils.randomAlphabetic(5),
			RandomUtils.nextInt(10, 100),
			Gender.FEMALE)

	private fun createPersonAsUri(person: Person): String {
		val response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(person)
				.post(uri)
		return "$uri/${response.jsonPath().get<Person>("id")}"
	}
}
