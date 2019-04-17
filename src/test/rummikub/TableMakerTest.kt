package test.rummikub

import main.rummikub.*
import org.junit.Test

class TableMakerTest {
    private fun table(vararg runs: Run) = Table(runs.toList())

    @Test
    fun makes_a_new_table_when_one_tile_in_hand_can_extend_a_run() {

        val previousTable = table(Run((3..5).yellow()))
        val tableMaker = TableMaker(previousTable)

        val fittingTile = 6.yellow()
        val tableWithExtendedRun = table(Run((3..6).yellow()))


        assertSameTables(
            tableWithExtendedRun,
            tableMaker.nextTableWith(Hand(fittingTile))
        )
    }


    @Test
    fun does_not_use_a_tile_more_than_once_in_next_table() {
        val tableWithSameTwoRuns = table(
            Run((2..6).green()), Run((2..6).green())
        )

        val tableMaker = TableMaker(tableWithSameTwoRuns)

        val fittingTile = 1.green()
        val tableWithOneExtendedRun = table(
            Run((1..6).green()), Run((2..6).green())
        )

        assertSameTables(
            tableWithOneExtendedRun,
            tableMaker.nextTableWith(Hand(fittingTile))
        )
    }
}

private fun assertSameTables(expected: Table, actual: Table) {
    val sameTables = expected == actual
    if (sameTables) return

    val expectedPrint = "Expected\n\t" + expected.print()
    val actualPrint = "Actual\n\t" + actual.print()

    throw AssertionError(
        """Expected both tables to be equal.
                |
                |$expectedPrint
                |
                |$actualPrint""".trimMargin()
    )
}

