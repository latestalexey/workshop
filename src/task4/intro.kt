package task4.intro

//Default arguments
fun foo(a: Int = 1, b: Int = 2) {

}

fun testFoo() {
    foo()
}

// Higher-order functions
// like 'isClientInterested: (Client) -> Boolean'

fun <T> let(t: T, body: (T) -> Unit) {
    body(t)
}

fun testLet() {

    let(2 + 3, { x -> println(x * x) })

    let(2 + 3) {
        x ->
        println(x * x)
    }
}


// Extensions functions
// like 'fun ClientData.getProductOccurrenceMap()'

fun String.lastChar(): Char {
    return this.charAt(this.size - 1)
}

fun testExtensions() {
    println(

            "abc".lastChar()

    )
}



// Extension functions as values

fun <T> with(t: T, body: T.() -> Unit) {
    t.body()
}

fun testWith() {
    val stringBuilder = StringBuilder()
    with(stringBuilder, { this.append("1") })

    with (stringBuilder) {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }
}

