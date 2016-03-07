package com.tartner.dancehours.querymodel.jpa

import com.google.common.base.Objects
import com.tartner.utilities.Empty
import com.tartner.utilities.emptyUUID
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "dance_user", schema = "public", catalog = "dance_hours")
public class DanceUserDataEntity {
    @Id @Type(type = "pg-uuid")
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true)
    public var userId: UUID = emptyUUID()

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 254)
    public var email: String = String.Empty

    @Basic
    @Column(name = "full_name", nullable = false, insertable = true, updatable = true, length = 1024)
    public var fullName: String = String.Empty

    @Basic
    @Column(name = "is_active", nullable = false, insertable = true, updatable = true)
    public var isActive: Boolean = false

    @OneToMany(targetEntity = UserRolesEntity::class)
    @JoinTable(name = "dance_user_roles",
        joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "user_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "role_id", referencedColumnName = "role_id")))
    public var roles: Set<UserRolesEntity> = HashSet<UserRolesEntity>()

    override fun hashCode(): Int {
        return Objects.hashCode(userId)
    }

    override fun equals(other : Any?): Boolean {
        if (this === other) {return true }
        if (other == null || javaClass != other.javaClass) { return false }
        val that = other as DanceUserDataEntity
        return Objects.equal(userId, that.userId)
    }
}
