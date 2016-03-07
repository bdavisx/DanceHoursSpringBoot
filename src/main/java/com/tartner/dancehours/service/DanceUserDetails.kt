package com.tartner.dancehours.service

import com.tartner.dancehours.domain.danceuser.DanceUserAggregate
import com.tartner.utilities.Empty
import com.tartner.utilities.emptyUUID
import java.util.*

class DanceUserDetails() {
    public var id: UUID = emptyUUID()
    public var fullName: String = String.Empty
    public var email: String = String.Empty
    public var isActive: Boolean = true

    companion object {
        public fun from(user: DanceUserAggregate): DanceUserDetails {
            val userDetails = DanceUserDetails();
            userDetails.id = user.id;
            userDetails.fullName = user.fullName
            userDetails.email = user.email
            userDetails.isActive = user.isActive
            return userDetails;
        }
    }
}
