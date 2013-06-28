package task4

import kotlin.test.*
import org.junit.Test as test

class testTask4 {
    test fun productPopularityTableIsFilled() {
        data.clientData.products
        val result = renderProductPopularityMap()
        assertTrue(result.contains("cactus"), "product popularity table should contain corresponding data")
    }

    test fun productPopularityTableIsColored() {
        data.clientData.products
        val result = renderProductPopularityMap()
        assertTrue(result.contains("bgcolor"), "product popularity table should be colored")
    }
}

