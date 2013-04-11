package task1

import clientApi.java.ClientApi.*
import task1.Util.sendMessageToClient

import kotlin.test.*
import org.junit.Test as test
import mailApi.Mailer

class testTask1 {
    fun testSendMessageToClient(
            client: Client?,
            message: String?,
            email: String? = null,
            shouldBeInvoked: Boolean = false
    ) {
        var invoked = false;
        sendMessageToClient(client, message, object : Mailer {
            public override fun sendMessage(foundEmail: String, foundMessage: String) {
                invoked = true;
                assertEquals(message, foundMessage,
                        "The message should be \"$message\", not \"$foundMessage\"")
                assertEquals(email, foundEmail,
                        "The message should be sent to email \"$email\", not \"$foundEmail\"")
            }
        })
        assertEquals(shouldBeInvoked, invoked,
                "The function 'sendMessage' " +
                "should${if (shouldBeInvoked) "" else "n't"} be invoked")
    }

    test fun everythingIsOk() {
        testSendMessageToClient(
                Client(PersonalInfo("Bob", "bob@gmail.com"), listOf(), true),
                "Hi Bob! We have an awesome proposition to you...",
                "bob@gmail.com",
                true)
    }

    test fun noMessage() {
        testSendMessageToClient(
                Client(PersonalInfo("Bob", "bob@gmail.com"), listOf(), true),
                null,
                "bob@gmail.com")
    }

    test fun noEmail() {
        testSendMessageToClient(
                Client(PersonalInfo("Bob", null), listOf(), true),
                "Hi Bob! We have an awesome proposition to you...")
    }

    test fun noClient() {
        testSendMessageToClient(
                null, "Hi Bob! We have an awesome proposition to you...")
    }

    test fun noPersonalInfo() {
        testSendMessageToClient(
                Client(null, listOf(), true),
                "Hi Bob! We have an awesome proposition to you...")
    }
}