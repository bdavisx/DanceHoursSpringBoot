package com.tartner.dancehours.service

import com.tartner.dancehours.domain.danceuser.DanceUserAggregate
import com.tartner.dancehours.domain.danceuser.DanceUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserMaintenanceService @Autowired constructor(
    private val repository: DanceUserRepository
    ) {

    fun GetUserList() : List<DanceUserAggregate> = repository.findAll()
}
