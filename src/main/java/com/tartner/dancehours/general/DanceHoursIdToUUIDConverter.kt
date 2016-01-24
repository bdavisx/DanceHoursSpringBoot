package com.tartner.dancehours.general

import java.util.*
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class DanceHoursIdToUUIDConverter : AttributeConverter<DanceHoursId, UUID> {
    constructor() {
        val i = 5
    }
    override fun convertToDatabaseColumn(attribute : DanceHoursId?) : UUID? {
        attribute?.let {
            if(attribute.equals(DanceHoursId.Empty)) return null

            return attribute.identifier
        }

        return null
    }

    override fun convertToEntityAttribute(dbData : UUID?) : DanceHoursId? {
        dbData?.let { return DanceHoursId(dbData) }

        return DanceHoursId.Empty
    }
}
