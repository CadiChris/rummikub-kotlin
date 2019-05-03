package main.rummikub.blocks

data class Tile(
    val value: Int,
    val suit: Suit
)

fun Int.red() = makeTile(this, Suit.Red)
fun Int.blue() = makeTile(this, Suit.Blue)
fun Int.green() = makeTile(this, Suit.Green)
fun Int.yellow() = makeTile(this, Suit.Yellow)

fun makeTile(value: Int, suit: Suit): Tile {
    return when (value) {
        in 1..13 -> Tile(value, suit)
        else -> throw InvalidTileValueException(value)
    }
}

class InvalidTileValueException(invalidValue: Int) :
    Throwable("""$invalidValue is not a valid tile value""")
