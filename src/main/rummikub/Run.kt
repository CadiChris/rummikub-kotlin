package main.rummikub

data class Run(val tiles: List<Tile>) {

    init {
        val moreThanOneSuit = tiles.distinctBy { it.suit }.size > 1
        if (moreThanOneSuit) throw NotUniqueSuitInRunException(tiles)
    }

    fun extendWith(candidate: Tile): Run {
        val fitsOnTheLeft = candidate.value == minValue() - 1
        val fitsOnTheRight = candidate.value == maxValue() + 1

        return when {
            fitsOnTheLeft -> Run(listOf(candidate).plus(tiles))
            fitsOnTheRight -> Run(tiles.plus(candidate))
            else -> this
        }
    }

    private fun minValue() = tiles.minBy { it.value }!!.value
    private fun maxValue() = tiles.maxBy { it.value }!!.value

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

class NotUniqueSuitInRunException(tiles: List<Tile>) : Throwable(
    """
    A run can only contain one suit.
    Received $tiles
    """.trimIndent()
)