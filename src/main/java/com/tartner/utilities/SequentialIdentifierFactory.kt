package com.tartner.utilities

import com.fasterxml.uuid.EthernetAddress
import com.fasterxml.uuid.Generators
import com.fasterxml.uuid.NoArgGenerator
import com.tartner.dancehours.DanceHoursId

// TODO: I would like to make this a "seed"/id configurable by node sequential generator
class SequentialIdentifierFactory(private val generator: NoArgGenerator):IdentifierFactory {
    constructor():this(Generators.timeBasedGenerator(EthernetAddress.fromInterface()))

    override fun newId(): DanceHoursId {
        return DanceHoursId(generator.generate())
    }
}
