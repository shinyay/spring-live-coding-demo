package io.pivotal.shinyay

import io.restassured.RestAssured.get
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus

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
}
