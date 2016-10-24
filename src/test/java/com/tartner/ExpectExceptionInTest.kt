@file:JvmName("ExpectException")

package com.tartner

import org.junit.Assert
import kotlin.reflect.KClass

fun expectException(expectedExceptionClass: KClass<*>, body: ()->Unit) {
    expectException(expectedExceptionClass.java, Runnable { body() })
}

fun expectException(expectedExceptionClass: Class<*>, body: Runnable) {
    var caughtException = false

    try {
        body.run()
    } catch (ex: Exception) {
        caughtException = expectedExceptionClass.isAssignableFrom(ex.javaClass)
    }

    if (!caughtException) {
        Assert.fail("Did not get expected exception: " + expectedExceptionClass.canonicalName)
    }
}
