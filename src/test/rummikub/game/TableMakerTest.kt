package test.rummikub.game

import main.rummikub.blocks.*
import main.rummikub.game.Hand
import main.rummikub.game.Table
import main.rummikub.game.TableMaker
import org.junit.Test
import test.rummikub.blocks.ALL_SUITS
import kotlin.test.assertEquals

class TableMakerTest {

    @Test
    fun makes_a_new_table_when_one_tile_of_the_hand_can_extend_a_run() {
        val previousTable = BuildTable(Run(3..5, Suit.Yellow))
        val tableMaker = TableMaker(previousTable)

        val fittingTile = 6.yellow()
        val tableWithExtendedRun = BuildTable(Run(3..6, Suit.Yellow))

        assertEquals(
            tableWithExtendedRun,
            tableMaker.nextTableWith(Hand(fittingTile))
        )
    }

    @Test
    fun does_not_use_a_tile_of_the_hand_more_than_once_in_the_next_table() {
        val tableWithSameTwoRuns = BuildTable(
            Run(2..6, Suit.Green), Run(2..6, Suit.Green)
        )
        val tableMaker = TableMaker(tableWithSameTwoRuns)

        val fittingTile = 1.green()

        val tableWithOneExtendedRun = BuildTable(
            Run(1..6, Suit.Green), Run(2..6, Suit.Green)
        )

        assertEquals(
            tableWithOneExtendedRun,
            tableMaker.nextTableWith(Hand(fittingTile))
        )
    }

    @Test
    fun can_use_all_the_tiles_of_the_hand_in_the_runs_of_next_table() {
        val tableWithTwoExtendableRuns = BuildTable(
            Run(1..4, Suit.Red), Run(8..10, Suit.Yellow)
        )

        val tableMaker = TableMaker(tableWithTwoExtendableRuns)

        val perfectHand = Hand(5.red(), 7.yellow())

        assertEquals(
            BuildTable(Run(1..5, Suit.Red), Run(7..10, Suit.Yellow)),
            tableMaker.nextTableWith(perfectHand)
        )
    }

    @Test
    fun a_tile_that_cannot_extend_anything_is_not_used_on_the_next_table() {
        val originalTable = Table(
            runs = listOf(Run(4..6, Suit.Blue)),
            groups = listOf(Group(8, ALL_SUITS()))
        )

        val uselessHand = Hand(11.yellow())
        val nextTable = TableMaker(originalTable).nextTableWith(uselessHand)

        assertEquals(originalTable, nextTable)
    }

    @Test
    fun can_use_the_tile_of_the_hand_to_extend_a_group() {
        val tableWithOneGroup = BuildTable(
            Group(4, setOf(Suit.Red, Suit.Blue, Suit.Yellow))
        )
        val tableMaker = TableMaker(tableWithOneGroup)
        val handForGroup = Hand(4.green())

        assertEquals(
            BuildTable(Group(4, ALL_SUITS())),
            tableMaker.nextTableWith(handForGroup)
        )
    }
}