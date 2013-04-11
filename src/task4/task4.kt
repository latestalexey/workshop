package task4

import clientUtil.getProductOccurrenceMap
import kotlinLibrary.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) %2 == 0) "#dce4ff" else "#eff2ff"

//TODO(1): fill the table with proper values from data.clientData
//TODO(2): color the table in a chess order (using getTitleColor() and getCellColor() functions above)
// You can run 'task4 Demo' run configuration to see the rendered table

fun renderProductOccurrenceMap(): String {
    return html {
        table {
            tr {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Occurrence")
                }
            }
            // your code goes here
        }
    }.toString()
}
