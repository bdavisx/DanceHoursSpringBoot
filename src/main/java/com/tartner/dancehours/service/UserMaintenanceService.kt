package com.tartner.dancehours.service

import com.tartner.dancehours.domain.danceuser.DanceUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserMaintenanceService @Autowired constructor(private val repository: DanceUserRepository) {

    fun GetUserList(): List<DanceUserDetails> = repository.findAll().map { dua ->
        DanceUserDetails.from(dua);
    };

    fun GetDetails(userId: UUID): DanceUserDetails {
        val user = repository.findOne(userId)
        return DanceUserDetails.from(user);
    }
}

