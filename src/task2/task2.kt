package clientUtil

import clientApi.*
import mailApi.Mailer
import java.util.HashSet


/* NB: this function has a parameter of function type ('isClientInterested') */
fun sendMessageToInterestedClients(clientsData: ClientsData, message: String, mailer: Mailer,
                                   isClientInterested: (Client) -> Boolean
) {
    for (client in clientsData.clients) {
        if (isClientInterested(client)) {
            sendMessageToClient(client, message, mailer)
        }
    }
}

/*
  TODO: send message only to customers who agreed to receive information by our fascinating Mailing List
*/
fun sendMessageToInterestedCustomers(clientsBase: ClientsData, message: String, mailer: Mailer) {
    sendMessageToInterestedClients(clientsBase, message, mailer, { client ->
        // your code goes here
        throw UnsupportedOperationException()
    })
}

/*
  TODO: send message only to women who has at least 3 successful orders in history
*/
fun sendMessageToWorthyWomen(clientsBase: ClientsData, message: String, mailSender: Mailer) {
    sendMessageToInterestedClients(clientsBase, message, mailSender, { client ->
        // your code goes here
        throw UnsupportedOperationException()
    })
}
