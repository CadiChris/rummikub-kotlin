package main.rummikub

data class Tile(val value: Int, val suit: Suit) {
    override fun toString(): String = """[$value-$suit]"""
}

fun Int.red() = makeTile(this, Suit.Red)
fun Int.blue() = makeTile(this, Suit.Blue)
fun Int.green() = makeTile(this, Suit.Green)
fun Int.yellow() = makeTile(this, Suit.Yellow)

private fun makeTile(value: Int, suit: Suit): Tile {
    return when (value) {
        in 1..12 -> Tile(value, suit)
        else -> throw InvalidTileValueException(value)
    }
}

enum class Suit {
    Red { override fun toString() = "red" },
    Blue { override fun toString() = "blue" },
    Green { override fun toString() = "green" },
    Yellow { override fun toString() = "yellow" }
}

class InvalidTileValueException(invalidValue : Int) :
    Throwable("""$invalidValue is not a valid tile value""")
