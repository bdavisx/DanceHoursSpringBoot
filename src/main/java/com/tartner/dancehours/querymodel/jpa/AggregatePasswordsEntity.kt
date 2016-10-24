package com.tartner.dancehours.querymodel.jpa

import com.google.common.base.Objects
import com.tartner.utilities.emptyUUID
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "aggregate_passwords", schema = "public", catalog = "dance_hours")
class AggregatePasswordsEntity {
    @Id @Type(type = "pg-uuid")
    @Column(name = "aggregate_id", nullable = false, insertable = true, updatable = true)
    public var aggregateId: UUID = emptyUUID()

    @Basic
    @Column(name = "password_hash", nullable = false, insertable = true, updatable = true)
    public var passwordHash: ByteArray = ByteArray(0)

    @Basic
    @Column(name = "salt", nullable = false, insertable = true, updatable = true)
    public var salt: ByteArray = ByteArray(0)

    override fun hashCode(): Int {
        return Objects.hashCode(aggregateId, passwordHash, salt)
    }

    override fun equals(other : Any?): Boolean {
        if (this === other) {return true }
        if (other == null || javaClass != other.javaClass) { return false }

        val that = other as AggregatePasswordsEntity
        return Objects.equal(aggregateId, that.aggregateId) && Objects.equal(passwordHash,
            that.passwordHash) && Objects.equal(salt, that.salt)
    }
}

