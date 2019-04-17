package test.rummikub

import main.rummikub.Run
import main.rummikub.Table

fun Table.print(): String {
    return this.runs.joinToString { it.print() }
}

fun Run.print(): String {
    val values = tiles.joinToString(
        separator = "-",
        prefix = "[",
        postfix = "]"
    ) {
        it.value.toString()
    }

    val suits = tiles
        .map { it.suit }
        .distinct()
        .joinToString(prefix = "[", postfix = "]")

    return """$values$suits"""
}