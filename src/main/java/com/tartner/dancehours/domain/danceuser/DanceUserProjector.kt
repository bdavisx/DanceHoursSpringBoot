package com.tartner.dancehours.domain.danceuser

// TODO: see Note:
// NOTE: I'm not sure that these should be in this package, they really pertain
// to the database...

import com.tartner.dancehours.domain.danceuser.external.DanceUserCreatedEvent
import com.tartner.dancehours.querymodel.jpa.DanceUserDataEntity
import org.axonframework.eventhandling.annotation.EventHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component @Transactional open class DanceUserProjector @Autowired constructor(
    @PersistenceContext private val em: EntityManager) {

    @EventHandler
    public fun handle(event: DanceUserCreatedEvent) {
        val userRecord = DanceUserDataEntity()
        userRecord.userId = event.userId.identifier
        userRecord.email = event.email
        userRecord.fullName = event.fullName
        userRecord.isActive = true
        em.persist(userRecord)
    }
}
