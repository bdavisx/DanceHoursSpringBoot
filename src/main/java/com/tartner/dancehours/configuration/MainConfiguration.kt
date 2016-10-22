package com.tartner.dancehours.configuration

import com.tartner.DanceHoursSpringBootApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackageClasses = arrayOf(DanceHoursSpringBootApplication::class))
open class MainConfiguration {
}
