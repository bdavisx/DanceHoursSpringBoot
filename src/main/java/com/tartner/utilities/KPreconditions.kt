package com.tartner.utilities

import com.google.common.base.Strings

class KPreconditions {
    companion object {
        fun checkNotEmpty(value: String) {
            checkNotEmpty(value, { "Empty String when there shouldn't be" })
        }

        fun checkNotEmpty(value: String, lazyMessage: ()->Any) {
            if (Strings.isNullOrEmpty(value)) {
                val message = lazyMessage()
                throw IllegalArgumentException(message.toString())
            }
        }
    }
}
