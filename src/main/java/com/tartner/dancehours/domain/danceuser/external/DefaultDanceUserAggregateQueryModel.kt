package com.tartner.dancehours.domain.danceuser.external

import com.tartner.dancehours.DanceHoursId
import com.tartner.dancehours.querymodel.danceuser.DanceUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component open class DefaultDanceUserAggregateQueryModel @Autowired constructor(
    private val repository: DanceUserRepository):DanceUserAggregateQueryModel {

    /** Checks to see if the email is already in the sytem.  */
    public override fun userIdAlreadyExists(userId: DanceHoursId): Boolean {
        return repository.exists(userId)
    }

    /** Checks to see if the email is already in the system.  */
    public override fun emailAlreadyExists(email: String): Boolean {
        return repository.existsByEmail(email) > 0
    }
}

