package com.tartner.domain.password

import com.tartner.dancehours.DanceHoursId

data class PasswordSetEvent(
    val aggregateId: DanceHoursId,
    val passwordHash: ByteArray,
    val salt: ByteArray)

