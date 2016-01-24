package com.tartner.dancehours.domain.danceuser

import com.tartner.dancehours.general.DanceHoursId
import org.springframework.data.jpa.repository.JpaRepository

interface DanceUserRepository : JpaRepository<DanceUserAggregate, DanceHoursId> {
}
