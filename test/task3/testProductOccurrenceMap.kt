package task3

import clientApi.*
import testUtil.*
import kotlin.test.*
import org.junit.Test as test
import mailApi.Mailer
import clientUtil.findTheMostPopularProduct
import clientUtil.findUnpopularProducts
import clientUtil.getProductPopularityMap
import data.*

class testTask3() {
    test fun productPopularityMap() {
        val map = clientData.getProductPopularityMap()
        val expectedProductPopularity = mapOf(cactus to 1, cake to 1, camera to 1, car to 1, carrot to 1, cellPhone to 1,
                chimney to 1, certificate to 1, cigar to 1, coffee to 3, coffeeMaker to 1,
                cola to 1, cranberry to 1, crocs to 2, crocodile to 0, cushion to 1)
        for ((product, expectedPopularity) in expectedProductPopularity) {
            val popularity = map[product]
            assertEquals(expectedPopularity, popularity, "$product was ordered $expectedPopularity times, not $popularity")
        }
    }

    test fun findTheMostPopularProduct() {
        val result = findTheMostPopularProduct(clientData)
        assertEquals(setOf(coffee), result.toSet())
    }

    test fun findUnorderedProducts() {
        val result = findUnpopularProducts(clientData)
        assertEquals(setOf(crocodile), result.toSet())
    }
}

