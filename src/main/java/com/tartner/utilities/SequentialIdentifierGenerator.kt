package com.tartner.utilities

import com.fasterxml.uuid.Generators
import com.fasterxml.uuid.NoArgGenerator
import java.util.*

public class SequentialIdentifierGenerator(private val generator: NoArgGenerator) : IdentifierGenerator {
    public constructor() : this(Generators.timeBasedGenerator())
    override fun newId(): UUID { return generator.generate()
    }
}
