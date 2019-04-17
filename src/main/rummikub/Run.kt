package main.rummikub

data class Run(val tiles: List<Tile>) {

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
       return tiles.joinToString { it.toString() }
    }
}

fun IntRange.red() = this.map { value -> value.red() }
fun IntRange.blue() = this.map { value -> value.blue() }
fun IntRange.green() = this.map { value -> value.green() }
fun IntRange.yellow() = this.map { value -> value.yellow() }
