package main.rummikub

data class Run(
    private val values: IntRange,
    private val suit: Suit
) {

    fun extendWith(aTile: Tile): Run {
        val fitsOnTheLeft = aTile.value == start() - 1
        val fitsOnTheRight = aTile.value == end() + 1

        return when {
            fitsOnTheLeft -> Run(aTile.value..end(), suit)
            fitsOnTheRight -> Run(start()..aTile.value, suit)
            else -> this
        }
    }

    private fun start() = values.first
    private fun end() = values.last

    override fun toString(): String {
        val values = values.joinToString(
            separator = "-",
            prefix = "[",
            postfix = "]"
        )

        return """$values[$suit]"""
    }
}
