package task4.demo

import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JLabel
import java.awt.Color
import java.awt.Dimension
import kotlinLibrary.*
import javax.swing.SwingConstants.*
import task4.renderProductPopularityMap


fun main(args: Array<String>) {
    with (JFrame("Product occurrence")) {
        setSize(600, 600)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        add(JScrollPane(JLabel(renderProductPopularityMap(), CENTER)))
        setVisible(true)
    }
}


