package test.rummikub

import main.rummikub.*
import org.junit.Test

class TableMakerTest {
    private fun table(vararg runs: Run) = Table(runs = runs.toList())
    private fun table(vararg groups: Group) = Table(groups = groups.toList())

    @Test
    fun makes_a_new_table_when_one_tile_of_the_hand_can_extend_a_run() {
        val previousTable = table(Run(3..5, Suit.Yellow))
        val tableMaker = TableMaker(previousTable)

        val fittingTile = 6.yellow()
        val tableWithExtendedRun = table(Run(3..6, Suit.Yellow))


        assertSameTables(
            tableWithExtendedRun,
            tableMaker.nextTableWith(Hand(fittingTile))
        )
    }

    @Test
    fun does_not_use_a_tile_of_the_hand_more_than_once_in_the_next_table() {
        val tableWithSameTwoRuns = table(
            Run(2..6, Suit.Green), Run(2..6, Suit.Green)
        )
        val tableMaker = TableMaker(tableWithSameTwoRuns)

        val fittingTile = 1.green()

        val tableWithOneExtendedRun = table(
            Run(1..6, Suit.Green), Run(2..6, Suit.Green)
        )

        assertSameTables(
            tableWithOneExtendedRun,
            tableMaker.nextTableWith(Hand(fittingTile))
        )
    }

    @Test
    fun can_use_all_the_tiles_of_the_hand_in_the_runs_of_next_table() {
        val tableWithTwoExtendableRuns = table(
            Run(1..4, Suit.Red), Run(8..10, Suit.Yellow)
        )

        val tableMaker = TableMaker(tableWithTwoExtendableRuns)

        val perfectHand = Hand(5.red(), 7.yellow())

        assertSameTables(
            table(Run(1..5, Suit.Red), Run(7..10, Suit.Yellow)),
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

        assertSameTables(originalTable, nextTable)
    }

    @Test
    fun can_use_the_tile_of_the_hand_to_extend_a_group() {
        val tableWithOneGroup = table(
            Group(4, setOf(Suit.Red, Suit.Blue, Suit.Yellow))
        )
        val tableMaker = TableMaker(tableWithOneGroup)
        val handForGroup = Hand(4.green())

        assertSameTables(
            table(Group(4, ALL_SUITS())),
            tableMaker.nextTableWith(handForGroup)
        )
    }
}

private fun assertSameTables(expected: Table, actual: Table) {
    val sameTables = expected == actual
    if (sameTables) return

    val expectedPrint = "Expected\n$expected"
    val actualPrint = "Actual\n$actual"

    throw AssertionError(
        """Expected both tables to be equal.
                |
                |$expectedPrint
                |
                |$actualPrint""".trimMargin()
    )
}

