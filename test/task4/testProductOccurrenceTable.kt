package task4

import kotlin.test.*
import org.junit.Test as test

class testTask4 {
    test fun productOccurrenceTableIsFilled() {
        data.clientData.products
        val result = renderProductOccurrenceMap()
        assertTrue(result.contains("cactus"), "product occurrence map should contain table of products and their occurrence")
    }

    test fun productOccurrenceTableIsColored() {
        data.clientData.products
        val result = renderProductOccurrenceMap()
        assertTrue(result.contains("bgcolor"), "product occurrence map should be colored")
    }
}

