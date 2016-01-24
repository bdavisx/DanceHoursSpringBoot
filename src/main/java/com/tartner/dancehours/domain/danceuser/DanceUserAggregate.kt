package com.tartner.dancehours.domain.danceuser

import com.tartner.dancehours.general.DanceHoursId
import com.tartner.utilities.Empty
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

public open class DanceUserAggregate() {
    @Id @Type(type = "pg-uuid")
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true)
    private var id: DanceHoursId = DanceHoursId.Empty

    @Basic
    @Column(name = "full_name", nullable = false, insertable = true, updatable = true,
        length = MaximumNameLength)
    private var fullName: String = String.Empty

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true,
        length = MaximumEmailLength)
    private var email: String = String.Empty

    @OneToMany(targetEntity = DanceUserRole::class)
    @JoinTable(name = "dance_user_roles",
        joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "user_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "role_text", referencedColumnName =
        "role_text")))
    private val userRoles: List<DanceUserRole> = ArrayList<DanceUserRole>()

    companion object {
        private const val MaximumNameLength = 1024
        private const val MaximumEmailLength = 1024
    }
}

