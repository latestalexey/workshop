package clientUtil

import clientApi.*
import java.util.HashMap
import kotlinLibrary.*

/*
TODO: count how many times clients have ordered each product
*/
fun ClientData.getProductPopularity(): Map<Product, Int> {
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
fun findTheMostPopularProduct(clientBase: ClientData): Collection<Product> {

    val productPopularity = clientBase.getProductPopularity()
    // your code goes here
    throw UnsupportedOperationException()
}

/*
TODO: find products that have never been ordered
*/
fun findUnorderedProducts(clientBase: ClientData): Collection<Product> {

    val productPopularity = clientBase.getProductPopularity()
    // your code goes here
    throw UnsupportedOperationException()
}