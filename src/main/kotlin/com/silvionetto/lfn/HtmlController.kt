package com.silvionetto.lfn

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
@PropertySource("classpath:app.properties")
@ConfigurationProperties("app")
class HtmlController() {

    @Value("title")
    lateinit var title: String

    @Autowired
    lateinit var categoryService: CategoryService

    @GetMapping("/")
    fun home(model: Model): String {
        model["title"] = title
        return "body"
    }

    @GetMapping("/category")
    fun categoryNew(model: Model): String {
        model["title"] = title
        model["category"] = Category("Category", mutableListOf<Category>())
        return "category"
    }

    @GetMapping("/category/{name}")
    fun categoryEdit(@PathVariable name: String, model: Model): String {
        model["title"] = title
        model["category"] = categoryService.findByName(name)
        return "category"
    }

    @PostMapping("/category")
    fun categorySubmit(@ModelAttribute category: Category): String {
        categoryService.save(category)
        return "category"
    }

    @GetMapping("/categories")
    fun categories(model: Model): String {
        model["title"] = title
        model["categories"] = categoryService.findAll()
        return "categories"
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