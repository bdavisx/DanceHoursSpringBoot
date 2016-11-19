package com.tartner.dancehours.querymodel.jpa

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.SchemaUtils.drop

object AggregatePasswordsTable: Table("aggregate_passwords") {
    val aggregateId = uuid("aggregate_id").primaryKey()
    val passwordHash = blob("password_hash")
    val salt = blob("salt")
}

