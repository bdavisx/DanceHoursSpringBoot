package com.tartner.dancehours

import com.tartner.DanceHoursSpringBootApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(DanceHoursSpringBootApplication::class))
@WebAppConfiguration
class DanceHoursSpringBootApplicationTests {

    @Test
    fun contextLoads() {

    }

}
