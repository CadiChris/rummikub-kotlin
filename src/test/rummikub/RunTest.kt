package test.rummikub

import main.rummikub.*
import org.hamcrest.CoreMatchers.containsString
import org.junit.Assert.assertThat
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RunTest {

    @Test
    fun represents_a_run() {
        assertEquals("[2-3-4-5][red]", Run((2..5).red()).toString())
        assertEquals("[1-2-3][blue]", Run((1..3).blue()).toString())
        assertEquals("[8-9-10-11-12][green]", Run((8..12).green()).toString())
        assertEquals("[7-8-9][yellow]", Run((7..9).yellow()).toString())
    }

    @Test
    fun a_run_with_different_suits_cant_be_created() {
        var thrown = false
        try {
            Run(listOf(1.red(), 2.green()))
        } catch (e: NotUniqueSuitInRunException) {
            thrown = true
            assertThat(e.message, containsString("red"))
            assertThat(e.message, containsString("green"))
        } finally {
            assertTrue(thrown)
        }
    }

    @Test
    fun a_run_can_be_extended_by_the_left_with_same_suit() {
        assertEquals(
            Run((3..6).red()),
            Run((4..6).red()).extendWith(3.red())
        )
    }

    @Test
    fun a_run_can_be_extended_by_the_right_with_same_suit() {
        assertEquals(
            Run((8..12).blue()),
            Run((8..11).blue()).extendWith(12.blue())
        )
    }
}

