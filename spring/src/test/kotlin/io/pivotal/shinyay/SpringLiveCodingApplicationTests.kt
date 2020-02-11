package io.pivotal.shinyay

import io.restassured.RestAssured.get
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
}
