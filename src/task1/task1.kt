package clientUtil

import clientApi.Client
import mailApi.Mailer

/*
TODO: rewrite function to Java (Util.sendMessageToClient)
*/
fun sendMessageToClient(
        client: Client?, message: String?, mailSender: Mailer
) {
    val email = client?.personalInfo?.email

    if (email != null && message != null) {

        mailSender.sendMessage(email, message)
    }
}
