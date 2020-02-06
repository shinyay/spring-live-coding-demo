package io.pivotal.shinyay.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller

@Controller
class HomeController {

    @Value("\${spring.application.name}")
    val appName: String = ""
}