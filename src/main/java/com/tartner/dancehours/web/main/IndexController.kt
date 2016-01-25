package com.tartner.dancehours.web.main

import com.tartner.dancehours.service.UserMaintenanceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
open class IndexController @Autowired constructor(
    private val service: UserMaintenanceService
    ) {

    @RequestMapping("/")
    fun index(model: Model): String {
        // TODO: service should return immutable users
        model.addAttribute("users", service.GetUserList())
        return "index"
    }
}
