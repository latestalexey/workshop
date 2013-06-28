package task4

import kotlin.test.*
import org.junit.Test as test
import task4.extra.getAnswers
import kotlinLibrary.*

class testQuestionnaire {
    test fun answersAreCorrect() {
        val answers = getAnswers()

        val result = StringBuilder("")
        for (i in 1..4) {
            result += (answers[i] ?: '?')
        }
        assertEquals(3046624, result.toString().hashCode(), "Incorrect answers")
    }
}

