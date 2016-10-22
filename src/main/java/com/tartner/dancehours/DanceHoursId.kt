package com.tartner.dancehours

import com.google.common.base.MoreObjects
import com.tartner.utilities.IdentifierFactory
import com.tartner.utilities.emptyUUID
import java.io.Serializable
import java.util.*

class DanceHoursId internal constructor (
    /**
    You should avoid referencing this property, it's public because the Id is used so many
    places and it can be useful for testing and database serialization. I would normally
    encapsulate both of those concerns, but that adds a lot of code needed in a lot of areas.
    */
    public val identifier : UUID
    ): Serializable {

    override fun equals(other : Any?) : Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as DanceHoursId

        return identifier == other.identifier
    }

    override fun hashCode() : Int = identifier.hashCode();

    override fun toString() : String =
        MoreObjects.toStringHelper(this).add("identifier", identifier).toString();

    companion object Default {
        public val EmptyUUID : UUID = emptyUUID()
        public val Empty = DanceHoursId(EmptyUUID)

        /** This should generally only be used when deserializing an object. */
        fun create(uuid : UUID) = DanceHoursId(uuid)

        /** This should only be used when you can't inject the IdentifierFactory. */
        fun create() = IdentifierFactory.createDefault()
    }
}
