package com.tartner.dancehours.web.main

import com.tartner.dancehours.service.UserMaintenanceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.*

@Controller
@RequestMapping(path=arrayOf("/users"))
open class UserMaintenanceController @Autowired constructor(
    private val service: UserMaintenanceService
    ) {

    @RequestMapping(method=arrayOf(RequestMethod.GET))
    fun list(model: Model): String {
        model.addAttribute("users", service.GetUserList())
        return "users/list"
    }

    @RequestMapping(method=arrayOf(RequestMethod.GET), path=arrayOf("/{userIdString}"))
    fun showDetails(@PathVariable userIdString : String, model : Model): String {
        // TODO: service should return immutable users
        val userId = UUID.fromString(userIdString)
        val userDetails = service.GetDetails(userId)
        model.addAttribute("user", userDetails)
        return "users/details"
    }
}
