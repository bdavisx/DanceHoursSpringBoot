package com.tartner.dancehours.domain.danceuser

import com.tartner.utilities.Empty
import com.tartner.utilities.emptyUUID
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

/**
    Yes, I'm calling it an aggregate when it's nothing of the sort - intentionally using an
    anemic domain model for now because it seems to be a basic CRUD app with some reporting.
    Probably need to change the name if the model stays this way.
 */
@Entity
@Table(name = "dance_user")
public open class DanceUserAggregate() {
    @Id  @Type(type = "pg-uuid")
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true)
    public var id: UUID = emptyUUID()

    @Basic
    @Column(name = "full_name", nullable = false, insertable = true, updatable = true,
        length = MaximumNameLength)
    public var fullName: String = String.Empty

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true,
        length = MaximumEmailLength)
    public var email: String = String.Empty

    @Basic
    @Column(name = "is_active", nullable = false, insertable = true, updatable = true,
        length = MaximumEmailLength)
    public var isActive: Boolean = true

    @OneToMany(targetEntity = DanceUserRole::class)
    @JoinTable(name = "dance_user_roles",
        joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "user_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "role_code", referencedColumnName =
        "role_code")))
    public val userRoles: List<DanceUserRole> = ArrayList<DanceUserRole>()

    companion object {
        private const val MaximumNameLength = 1024
        private const val MaximumEmailLength = 1024
    }
}

