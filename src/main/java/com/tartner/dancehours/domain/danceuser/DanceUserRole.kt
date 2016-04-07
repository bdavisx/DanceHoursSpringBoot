package com.tartner.dancehours.domain.danceuser

import com.google.common.base.Objects
import com.tartner.utilities.Empty
import javax.persistence.*

@Entity
@Table(name = "user_roles")
public class DanceUserRole() {
    @Id
    @Column(name = "role_code", nullable = false, insertable = true,
        updatable = true, length = 16)
    public val roleCode : String = String.Empty

    @Basic
    @Column(name = "name", nullable = false, insertable = true,
        updatable = true, length = 255)
    public var name : String = String.Empty

    @Basic
    @Column(name = "description", nullable = false, insertable = true,
        updatable = true,
        length = 2147483647)
    public var description : String = String.Empty

    @Basic
    @Column(name = "is_admin", nullable = false, insertable = true,
        updatable = true)
    public var isAdmin : Boolean = false

    override fun hashCode() : Int = roleCode.hashCode()
    override fun equals(other : Any?) : Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val that = other as DanceUserRole
        return Objects.equal(roleCode, that.roleCode)
    }
}
