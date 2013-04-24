package clientUtil

import clientApi.*
import java.util.HashMap
import kotlinLibrary.*

/*
TODO: count for each product how many times clients have ordered it
*/
fun ClientsData.getProductPopularityMap(): Map<Product, Int> {
    val map = HashMap<Product, Int>()
    for (product in this.products) {
        // your code goes here
    }
    for (client in this.clients) {
        // your code goes here
    }
    return map
}

/*
TODO: find the most popular product (or several), based on how many clients ordered it
*/
fun findTheMostPopularProduct(clientBase: ClientsData): Collection<Product> {

    val productPopularity = clientBase.getProductPopularityMap()
    // your code goes here
    throw UnsupportedOperationException()
}

/*
TODO: find products that have never been ordered
*/
fun findUnpopularProducts(clientBase: ClientsData): Collection<Product> {

    val productPopularity = clientBase.getProductPopularityMap()
    // your code goes here
    throw UnsupportedOperationException()
}