package clientUtil

import clientApi.Client
import mailApi.Mailer

/*
TODO: rewrite this function to Java
  (write your code in Util.sendMessageToClient)
*/
fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    val email = client?.personalInfo?.email

    if (email != null && message != null) {

        mailer.sendMessage(email, message)
    }
}
