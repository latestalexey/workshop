package task4

import java.util.ArrayList
import kotlinLibrary.join

open class Tag(val name: String) {
    val children: MutableList<Tag> = ArrayList()
    val attributes: MutableList<Attribute> = ArrayList()
    open fun toString() = "<$name${attributes.join(prep = " ")}>${children.join()}</$name>"
}

class Attribute(val name : String, val value : String) {
    fun toString() = """$name="$value" """
}

fun <T: Tag> T.set(name: String, value: String?): T {
    if (value != null) {
        attributes.add(Attribute(name, value))
    }
    return this
}

fun <T: Tag> Tag.doInit(tag: T, init: T.() -> Unit): T {
    tag.init()
    children.add(tag)
    return tag
}

class Html: Tag("html")
class Table: Tag("table")
class Center: Tag("center")
class TR: Tag("tr")
class TD: Tag("td")
class Text(val text: String): Tag("b") {
    override fun toString() = text
}

fun html(init: Html.() -> Unit): Html {
    val tag = Html()
    tag.init()
    return tag
}

fun Html.table(init : Table.() -> Unit) = doInit(Table(), init)
fun Html.center(init : Center.() -> Unit) = doInit(Center(), init)

fun Table.tr(bgcolor: String? = null, init : TR.() -> Unit) = doInit(TR(), init).set("bgcolor", bgcolor)

fun TR.td(align : String = "left", bgcolor: String? = null, init : TD.() -> Unit) = doInit(TD(), init).set("align", align).set("bgcolor", bgcolor)

fun Tag.text(s : Any?) = doInit(Text(s.toString()), {})

