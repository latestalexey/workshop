package testUtil

import clientApi.*
import mailApi.Mailer
import kotlin.test.assertEquals


fun createClientData(vararg clients: Client) = ClientData(clients.toList(), setOf())

fun Client.email() = this.personalInfo?.email!!

fun testSendMessageToCustomers(
        clientsBase: ClientData,
        rightEmails: List<String>,
        assertMessage: String,
        sendMessageToCustomersFunction: (ClientData, String, Mailer) -> Unit
) {
    val emails = hashSetOf<String>()
    sendMessageToCustomersFunction(clientsBase, "Hi!...", object: Mailer {
        public override fun sendMessage(email: String, message: String) {
            emails.add(email)
        }
    })
    assertEquals(rightEmails.toSet(), emails, assertMessage)
}
