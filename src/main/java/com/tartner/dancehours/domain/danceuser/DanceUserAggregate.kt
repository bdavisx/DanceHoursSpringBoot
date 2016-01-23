package com.tartner.dancehours.domain.danceuser

import com.tartner.dancehours.general.DanceHoursId
import com.tartner.dancehours.domain.danceuser.DanceUserRole
import com.tartner.utilities.Empty
import java.util.*

public class DanceUserAggregate {
    private var id: DanceHoursId = DanceHoursId.Default.Empty
    private var fullName: String = String.Empty
    private var email: String = String.Empty
    private val userRoles: List<DanceUserRole> = ArrayList<DanceUserRole>()


    companion object {
        private val MaximumNameSize = 1024
    }
}

