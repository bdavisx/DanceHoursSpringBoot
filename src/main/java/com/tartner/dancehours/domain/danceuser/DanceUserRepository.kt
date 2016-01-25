package com.tartner.dancehours.domain.danceuser

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DanceUserRepository : JpaRepository<DanceUserAggregate, UUID> {
}
