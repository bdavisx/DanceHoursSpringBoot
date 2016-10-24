package com.tartner.utilities

import com.tartner.dancehours.DanceHoursId

public interface IdentifierFactory {
    public fun newId(): DanceHoursId

    /**
    This companion object should only be used if you can't get get the IdentifierGenerator
    injected.
     */
    companion object {
        /**
        This companion property should only be used if you can't get get the IdentifierGenerator
        injected.
         */
        var defaultGenerator: IdentifierFactory = SequentialIdentifierFactory()

        /**
        This companion method should only be used if you can't get get the IdentifierGenerator
        injected.
         */
        fun createDefault(): DanceHoursId = defaultGenerator.newId()
    }
}

