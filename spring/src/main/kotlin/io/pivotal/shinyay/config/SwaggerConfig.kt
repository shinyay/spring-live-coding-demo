package io.pivotal.shinyay.config

import org.springframework.boot.info.BuildProperties
import org.springframework.boot.info.GitProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.swagger.web.*
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@Configuration
@EnableSwagger2
class SwaggerConfig(var build: Optional<BuildProperties>, var git: Optional<GitProperties>) {

    @Bean
    fun uiConfig(): UiConfiguration = UiConfigurationBuilder.builder()
            .deepLinking(true)
            .displayOperationId(true)
            .displayRequestDuration(true)
            .docExpansion(DocExpansion.NONE)
            .filter(true)
            .operationsSorter(OperationsSorter.ALPHA)
            .showExtensions(true)
            .tagsSorter(TagsSorter.ALPHA)
            .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
            .validatorUrl(null)
            .build()
}