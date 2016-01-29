package com.tartner.dancehours.service

import com.tartner.dancehours.domain.danceuser.DanceUserAggregate
import com.tartner.dancehours.domain.danceuser.DanceUserRepository
import com.tartner.utilities.Empty
import com.tartner.utilities.emptyUUID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserMaintenanceService @Autowired constructor(
    private val repository: DanceUserRepository
    ) {

    fun GetUserList() : List<DanceUserAggregate> = repository.findAll()

    fun GetDetails(userId: UUID) : DanceUserDetails {
        val user = repository.findOne(userId)
        val userDetails = DanceUserDetails();
        with(userDetails, {
            id = user.id
            fullName = user.fullName
            email = user.email
            isActive = user.isActive
        })
        return userDetails
    }
}

class DanceUserDetails() {
    public var id: UUID = emptyUUID()
    public var fullName: String = String.Empty
    public var email: String = String.Empty
    public var isActive: Boolean = true
}
