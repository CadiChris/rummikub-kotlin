package test.rummikub.game

import main.rummikub.blocks.Run
import main.rummikub.blocks.Suit
import main.rummikub.blocks.blue
import main.rummikub.game.Hand
import main.rummikub.game.Round
import org.junit.Test
import kotlin.test.assertEquals

class RoundTest {

    @Test
    fun plays_a_single_move_round_and_gets_the_result() {
        val tableMissingSeven = BuildTable(Run(8..11, Suit.Blue))
        val handWithSeven = Hand(7.blue())

        val roundResult = Round(tableMissingSeven).play(handWithSeven)

        assertEquals(7, roundResult.score())
        assertEquals(BuildTable(Run(7..11, Suit.Blue)), roundResult.table())
    }
}