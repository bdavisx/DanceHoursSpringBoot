package com.tartner.utilities

import java.util.*

public interface IdentifierGenerator {
    public fun newId(): UUID

    companion object {
        var defaultGenerator : IdentifierGenerator = SequentialIdentifierGenerator()

        fun createDefault() : UUID = defaultGenerator.newId()
    }
}

