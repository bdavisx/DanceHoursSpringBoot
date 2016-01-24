package com.tartner.dancehours.web.main

import com.tartner.dancehours.domain.danceuser.DanceUserAggregate
import com.tartner.dancehours.domain.danceuser.DanceUserRepository
import com.tartner.dancehours.general.DanceHoursId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
open class IndexController @Autowired constructor(
    private val repository: DanceUserRepository
) {

    @RequestMapping("/") fun index() : String {
        val user = DanceUserAggregate()
        user.id = DanceHoursId.create()
        user.fullName = "Test 1"
        user.email = "a@b.comm"
        repository.save(user)

        val users : MutableList<DanceUserAggregate>? = repository.findAll()
        for (danceUserAggregate in users!!) {
            System.out.print("Heloo")
        }
        return "index"
    }
}
