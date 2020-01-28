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
```
springBoot {
	buildInfo()
}
```

- Git Information
```
com.gorylenko.gradle-git-properties
```

### 6. API Document by Swagger

```
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
```
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.h2database:h2")
}
```

#### 7.2. Kotlin Plugin
Without the following plugins Default constructor which does not has argument is needed.

```
plugins {
	kotlin("plugin.jpa") version "1.3.61"
	kotlin("plugin.noarg") version "1.3.61"
}
```

#### 7.3. CrudRepository Interface

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
