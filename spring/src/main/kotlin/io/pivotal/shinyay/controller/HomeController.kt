package io.pivotal.shinyay.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {

    @Value("\${spring.application.name}")
    val appName: String = ""

    @RequestMapping("/")
    fun home(model: Model): String {
        model.addAttribute("appName", appName)
        return "home"
    }
}