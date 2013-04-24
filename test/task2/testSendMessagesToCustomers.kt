package task2

import clientApi.*
import testUtil.*

import kotlin.test.*
import org.junit.Test as test
import clientUtil.sendMessageToInterestedCustomers
import mailApi.Mailer
import data.*
import clientUtil.sendMessageToWorthyWomen


class testTask2() {
    val sendMessageToInterestedCustomersFunction =
            { (clientsBase: ClientsData, message: String, mailSender: Mailer) ->
                sendMessageToInterestedCustomers(clientsBase, message, mailSender)}

    test fun sendMessageToInterestedCustomer() {
        testSendMessageToCustomers(createClientData(bob), listOf(bob.email()),
                "The message should be sent to the client who agreed to receive spam!",
                sendMessageToInterestedCustomersFunction)
    }

    test fun sendMessageToNotInterestedCustomer() {
        testSendMessageToCustomers(createClientData(sophie), listOf(),
                "The message shouldn't be sent to the client who doesn't want to receive spam!",
                sendMessageToInterestedCustomersFunction)
    }


    //--------------------------------
    val sendMessageToWorthyWomenFunction =
            { (clientsBase: ClientsData, message: String, mailSender: Mailer) ->
                sendMessageToWorthyWomen(clientsBase, message, mailSender)}

    test fun messageIsSentToWorthyWoman() {
        testSendMessageToCustomers(createClientData(ana), listOf(ana.email()),
                "Message should be sent to a woman who has at least 3 successful orders in history",
                sendMessageToWorthyWomenFunction)
    }

    test fun messageIsNotSentToMan() {
        testSendMessageToCustomers(createClientData(bob), listOf(),
                "Message shouldn't be sent to man",
                sendMessageToWorthyWomenFunction)
    }

    test fun messageIsNotSentToPersonWithUnspecifiedGender() {
        testSendMessageToCustomers(createClientData(x), listOf(),
                "Message shouldn't be sent to a person with unspecified gender",
                sendMessageToWorthyWomenFunction)
    }

    test fun messageIsNotSentToNotWorthyWoman() {
        testSendMessageToCustomers(createClientData(fleur), listOf(),
                "Message shouldn't be sent to a woman who has less than 5 successful orders in history",
                sendMessageToWorthyWomenFunction)
    }
}
