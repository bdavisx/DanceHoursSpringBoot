package com.tartner.dancehours.domain.danceuser

import com.tartner.dancehours.DanceHoursId
import com.tartner.dancehours.domain.danceuser.external.*
import com.tartner.domain.password.PasswordSetEvent
import com.tartner.domain.password.TestPasswordHolder
import com.tartner.expectException
import com.tartner.utilities.KFixtures
import org.axonframework.test.FixtureConfiguration
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.util.*

class DanceUserAggregateTest {

    companion object {
        val UUIDString = "e78320a0-48b9-490a-8b1b-f5bcdcf34995"

        val CreateUserId = UUID.fromString(UUIDString)
        val CreateEmail = "bdavisx@yahoo.com"
        val CreateFullName = "Bill Davis"
        val CreatePassword = "notReal"
    }

    private var fixture : FixtureConfiguration<*>? = KFixtures.newGivenWhenThenFixture(DanceUserAggregate::class.java)
    private var createCommand : CreateDanceUserCommand = createValidCreateCommand()
    private var createdEvent : DanceUserCreatedEvent = createCreatedEventForValidCommand(createCommand)
    private var queryModelMock : DanceUserAggregateQueryModel = mock(DanceUserAggregateQueryModel::class.java)
    private var passwordSetEvent : PasswordSetEvent = createPasswordSetEvent()

    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    @Test
    @Throws(Exception::class)
    fun danceUserCreated() {
        /* Note: We're going to test the command handler and the aggregate
            together because they act as a unit. The command handler should
            only be the container managed side of the unit, it shouldn't
            be doing anything else. */

        val user = DanceUserAggregate()
        user.create(createCommand, queryModelMock, passwordSetEvent)

        verify<DanceUserAggregateQueryModel>(queryModelMock).emailAlreadyExists(CreateEmail)
        verify<DanceUserAggregateQueryModel>(queryModelMock).userIdAlreadyExists(
            buildCreateUserId())

        val events = user.uncommittedEvents
        assertThat<DanceUserCreatedEvent>(createdEvent, equalTo(events.next().payload))
        assertThat<PasswordSetEvent>(passwordSetEvent, equalTo(events.next().payload))
    }

    private fun buildCreateUserId() : DanceHoursId {
        return DanceHoursId.create(CreateUserId)
    }

    @Test
    @Throws(Exception::class)
    fun danceUserCreatedDuplicateUserId() {
        val command = createValidCreateCommand()

        val queryModelMock = mock(DanceUserAggregateQueryModel::class.java)
        `when`(queryModelMock.userIdAlreadyExists(buildCreateUserId())).thenReturn(true)

        val user = DanceUserAggregate()
        expectException(DanceUserIdAlreadyExistsException::class) {
            user.create(createCommand!!, queryModelMock, passwordSetEvent!!)
        }
    }

    @Test
    @Throws(Exception::class)
    fun danceUserCreatedDuplicateEmail() {
        val command = createValidCreateCommand()

        val queryModelMock = mock(DanceUserAggregateQueryModel::class.java)
        `when`(queryModelMock.emailAlreadyExists(CreateEmail))
            .thenReturn(true)

        val user = DanceUserAggregate()

        expectException(DanceUserEmailAlreadyExistsException::class) {
            user.create(createCommand!!, queryModelMock, passwordSetEvent!!)
        }
    }

    private fun createValidCreateCommand() : CreateDanceUserCommand {
        val command = CreateDanceUserCommand(buildCreateUserId(), CreateEmail,
            CreateFullName, CreatePassword, HashSet<DanceUserRole>())
        return command
    }

    private fun createCreatedEventForValidCommand(
        command : CreateDanceUserCommand) : DanceUserCreatedEvent {
        val event = DanceUserCreatedEvent(buildCreateUserId(),
            command.email, command.fullName, command.roles)
        return event
    }

    private fun createPasswordSetEvent() : PasswordSetEvent {
        val passwordHolder = TestPasswordHolder.CreateDefaultTest()
        return PasswordSetEvent(createCommand!!.userId,
            passwordHolder.passwordHash, passwordHolder.salt)
    }

}
