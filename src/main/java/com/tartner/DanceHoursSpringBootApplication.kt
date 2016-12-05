package com.tartner

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackageClasses = arrayOf(DanceHoursSpringBootApplication::class))
object DanceHoursSpringBootApplication {

    @JvmStatic fun main(args : Array<String>) {
        SpringApplication.run(DanceHoursSpringBootApplication::class.java, *args)
    }
}
