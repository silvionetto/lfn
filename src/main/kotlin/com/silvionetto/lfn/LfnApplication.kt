package com.silvionetto.lfn

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LfnApplication

fun main(args: Array<String>) {
	runApplication<LfnApplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}
