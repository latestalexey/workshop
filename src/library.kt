package kotlinLibrary

import java.util.HashMap
import java.util.Collections

fun <T, R> Map<T, R>.filter(f: (T, R) -> Boolean): Map<T, R> {
    val result = HashMap<T, R>()
    for ((key, value) in this) {
        if (f(key, value)) {
            result[key] = value
        }
    }
    return result
}

fun <T : Comparable<T>> Collection<T>.max(): T {
    //todo invoke Collections.max(this) after KT-3480
    var i = iterator()
    var candidate = i.next()
    while (i.hasNext()) {
        var next = i.next()
        if ((next.compareTo(candidate)) > 0)
            candidate = next

    }
    return candidate
}

fun <T> Collection<T>.join(sep : String = "", prep : String = "") : String {
    val sb = StringBuilder()
    var it = iterator()
    if (it.hasNext()) {
        sb.append(prep)
    }
    while (it.hasNext()) {
        sb.append(it.next())
        if (it.hasNext()) {
            sb.append(sep)
        }
    }
    return sb.toString()
}


public inline fun <K, V> Map<K, V>.withIndices() : Iterator<Triple<Int, K, V>> {
    return IndexForMapIterator(iterator())
}

class IndexForMapIterator<K, V>(val iterator : Iterator<Map.Entry<K, V>>): Iterator<Triple<Int, K, V>> {
    private var index : Int = 0

    override fun next(): Triple<Int, K, V> {
        val next = iterator.next()
        return Triple(index++, next.key, next.value)
    }

    override fun hasNext(): Boolean {
        return iterator.hasNext()
    }
}

fun StringBuilder.plusAssign(c: Char) {
    append(c)
}
