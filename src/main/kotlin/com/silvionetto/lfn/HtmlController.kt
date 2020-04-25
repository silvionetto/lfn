package com.silvionetto.lfn

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
@PropertySource("classpath:app.properties")
@ConfigurationProperties("app")
class HtmlController() {

    @Value("title")
    lateinit var title: String

    @GetMapping("/")
    fun home(model: Model): String {
        model["title"] = title
        return "body"
    }

    @GetMapping("/contact")
    fun contact(model: Model): String {
        model["title"] = title
        return "contact"
    }

    @GetMapping("/privacy")
    fun privacy(model: Model): String {
        model["title"] = title
        return "privacy"
    }

    @GetMapping("/terms-of-service")
    fun termsOfService(model: Model): String {
        model["title"] = title
        return "terms-of-service"
    }

}