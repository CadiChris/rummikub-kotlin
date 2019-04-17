package test.rummikub

import main.rummikub.*
import org.junit.Test

class TableMakerTest {

    @Test
    fun makes_a_new_table_when_one_tile_in_hand_can_extend_a_run() {

        val previousTable = Table(listOf(Run((3..5).yellow())))
        val tableMaker = TableMaker(previousTable)

        val fittingTile = 6.yellow()
        val tableWithExtendedRun = Table(listOf(Run((3..6).yellow())))


        val computedTable = tableMaker.nextTableWith(Hand(fittingTile))

        assertSameTables(tableWithExtendedRun, computedTable)
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

