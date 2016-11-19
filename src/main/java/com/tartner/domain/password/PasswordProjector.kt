package com.tartner.domain.password

import com.tartner.dancehours.DanceHoursId
import com.tartner.dancehours.querymodel.jpa.AggregatePasswordsTable
import org.axonframework.eventhandling.annotation.EventHandler
import org.funktionale.either.Disjunction
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.sql.rowset.serial.SerialBlob

@Component open class PasswordProjector @Autowired constructor() {

    @EventHandler fun handle(event: PasswordSetEvent) {
        transaction {
            val numberOfMatchingRecords: Int = AggregatePasswordsTable
                .select(aggregateIdEquals(event.aggregateId)).count()

            when(numberOfMatchingRecords) {
                0 -> insert(event)
                else -> update(event)
            }
        }
    }

    private fun insert(
        event: PasswordSetEvent): InsertStatement<Number> {
        return AggregatePasswordsTable.insert {
            it[aggregateId] = event.aggregateId.identifier
            setBinaryValues(event, it)
        }
    }

    private fun update(event: PasswordSetEvent): Int {
        return AggregatePasswordsTable.update(
            where = aggregateIdEquals(event.aggregateId),
            body = { setBinaryValues(event, it) })
    }

    /** Note that this method returns the Operation, not the result of the operation. */
    private fun aggregateIdEquals(id: DanceHoursId)
        : SqlExpressionBuilder.()->Op<Boolean> =
            { AggregatePasswordsTable.aggregateId eq id.identifier }

    private fun <T> AggregatePasswordsTable.setBinaryValues(event: PasswordSetEvent,
        it: UpdateBuilder<T>) {
        it[passwordHash] = SerialBlob(event.passwordHash)
        it[salt] = SerialBlob(event.salt)
    }
}
