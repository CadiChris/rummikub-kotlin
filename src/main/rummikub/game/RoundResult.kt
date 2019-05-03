package main.rummikub.game

import main.rummikub.blocks.Run
import main.rummikub.blocks.Suit

class RoundResult {
    fun score(): Int {
        return 7
    }

    fun table(): Table {

        return Table(listOf(Run(7..11, Suit.Blue)))
    }

}
