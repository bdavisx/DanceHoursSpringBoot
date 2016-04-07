package com.tartner.domain.password

import com.tartner.dancehours.web.config.AxonConfiguration
import com.tartner.dancehours.web.config.PasswordConfiguration
import com.tartner.dancehours.web.config.TestPersistenceConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@Configuration
@Import(TestPersistenceConfiguration::class, AxonConfiguration::class,
    PasswordConfiguration::class)
public open class StandardIntegrationTestConfiguration {
    @Bean public open fun propertyConfigInDev() : PropertySourcesPlaceholderConfigurer {
        return PropertySourcesPlaceholderConfigurer()
    }
}
