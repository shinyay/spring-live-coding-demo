# Live Coding Demo for Spring

Overview

## Description

## Demo

### 1. Spring Initilizr to create project template

```
$ curl https://start.spring.io/starter.zip -d type=gradle-project -d dependencies=web,actuator -o spring.zip
```

### 2. Entity
#### 2.1. Data Class
#### 2.2. Enum

### 3. Repository
- Find
- Save
- Update
- Remove

### 4. Controller
- RestController
- RequestMapping
- GetMapping
- PostMapping
- PutMapping
- DeleteMapping

### 5. Actuator
- Actuator Enabled
```
management:
  endpoints:
    web:
      exposure:
        include: '*'
```

- Build Information
```gradle
springBoot {
	buildInfo()
}
```

- Git Information
```
com.gorylenko.gradle-git-properties
```

### 6. API Document by Swagger

```gradle
dependencies {
	implementation("io.springfox:springfox-swagger2:2.9.2")
	implementation("io.springfox:springfox-swagger-ui:2.9.2")
}
```

- UiConfiguration
- ApiInfo
- Docket

[swagger-ui](http://localhost:8080/swagger-ui.html)

### 7. Data Persistence

#### 7.1. Dependency
```gradle
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.h2database:h2")
}
```

#### 7.2. Kotlin Plugin
Without the following plugins Default constructor which does not has argument is needed.

```gradle
plugins {
	kotlin("plugin.jpa") version "1.3.61"
	kotlin("plugin.noarg") version "1.3.61"
}
```

#### 7.3. CrudRepository Interface
- Inherit `CrudRepository<>` interface

### 8. Thymeleaf
#### 8.1. Dependency
```gradle
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}
```

#### 8.2. Application Properties
```yaml
spring:
  thymeleaf:
    cache: false
    enabled: true
    prefix: classpath:/templates/
    suffix: .html
    encoding: UTF-8
```

- `prefix` : Directory name under resources where Thymeleaf templates are located
- `suffix` : File extention for Thymeleaf template

### 9. Security
#### 9.1. Dependency
```gradle
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security")
}
```

#### 9.2. Security Configuration Class
```kotlin
@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter()
```

### 10. Test
#### REST assured
- [REST-assured](http://rest-assured.io)

```gradle
dependencies {
	testImplementation("io.rest-assured:rest-assured:4.2.0")
	testImplementation("io.rest-assured:json-path:4.2.0")
	testImplementation("io.rest-assured:xml-path:4.2.0")
}
```

#### Test code
- GET
```kotlin
RestAssured.get(ENDPOINT).then()
				.assertThat()
				.statusCode(HttpStatus.OK.value())
```

```kotlin
RestAssured.get(ENDPOINT).then()
				.assertThat()
				.statusCode(HttpStatus.OK.value())
				.body("firstname", equalTo("Rei"))
```

#### Google Truth to assertThat

```gradle
dependencies {
	testImplementation("com.google.truth:truth:1.0.1")
}
```

```kotlin
val response: Response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(person)
				.post(uri)
		assertThat(response.statusCode).isEqualTo(HttpStatus.CREATED.value())
```

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
