package com.tartner.dancehours.domain.danceuser

import com.tartner.dancehours.querymodel.jpa.DanceUserDataEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DanceUserRepository : JpaRepository<DanceUserDataEntity, UUID> {
}
