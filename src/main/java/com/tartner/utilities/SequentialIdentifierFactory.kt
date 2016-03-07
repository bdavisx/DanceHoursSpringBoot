package com.tartner.utilities

import com.fasterxml.uuid.Generators
import com.fasterxml.uuid.NoArgGenerator
import com.tartner.dancehours.DanceHoursId

// TODO: I would like to make this a "seed"/id configurable by node sequential generator
public class SequentialIdentifierFactory(private val generator: NoArgGenerator) : IdentifierFactory {
    public constructor() : this(Generators.timeBasedGenerator())
    override fun newId(): DanceHoursId { return DanceHoursId(generator.generate()) }
}
