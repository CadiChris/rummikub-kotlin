package main.rummikub

data class Group(val value: Int, val suits: Set<Suit>) {
    fun extendWith(aTile: Tile): Group {
        val sameValue = aTile.value == value

        return when {
            sameValue -> Group(value, suits.plus(aTile.suit))
            else -> this
        }
    }
    override fun toString() = """[$value ${suits.joinToString()}]"""
}
