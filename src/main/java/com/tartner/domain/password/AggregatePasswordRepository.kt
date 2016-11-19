package com.tartner.domain.password

import com.tartner.dancehours.DanceHoursId
import com.tartner.dancehours.querymodel.jpa.AggregatePasswordsEntity
import org.springframework.data.repository.CrudRepository

interface AggregatePasswordRepository:CrudRepository<AggregatePasswordsEntity, DanceHoursId>
