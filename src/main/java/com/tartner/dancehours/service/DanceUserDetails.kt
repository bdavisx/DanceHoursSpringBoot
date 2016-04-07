package com.tartner.dancehours.service

import com.tartner.dancehours.DanceHoursId
import com.tartner.dancehours.querymodel.jpa.DanceUserDataEntity
import com.tartner.utilities.Empty

class DanceUserDetails() {
    public var id: DanceHoursId = DanceHoursId.Empty
    public var fullName: String = String.Empty
    public var email: String = String.Empty
    public var isActive: Boolean = true

    companion object {
        public fun from(user: DanceUserDataEntity): DanceUserDetails {
            val userDetails = DanceUserDetails();
            userDetails.id = DanceHoursId.create(user.userId);
            userDetails.fullName = user.fullName;
            userDetails.email = user.email;
            userDetails.isActive = user.isActive;
            return userDetails;
        }
    }
}
