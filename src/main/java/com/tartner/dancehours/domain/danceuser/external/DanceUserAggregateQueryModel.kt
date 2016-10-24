package com.tartner.dancehours.domain.danceuser.external

import com.tartner.dancehours.DanceHoursId

public interface DanceUserAggregateQueryModel {
    public fun userIdAlreadyExists(userId: DanceHoursId): Boolean
    public fun emailAlreadyExists(email: String): Boolean
}
