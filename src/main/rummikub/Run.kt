package main.rummikub

data class Run(val tiles: List<Tile>) {
    override fun toString(): String {
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
}

fun IntRange.red() = this.map { value -> value.red() }
fun IntRange.blue() = this.map { value -> value.blue() }
fun IntRange.green() = this.map { value -> value.green() }
fun IntRange.yellow() = this.map { value -> value.yellow() }