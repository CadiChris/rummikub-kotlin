package test.rummikub

import main.rummikub.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class RunTest {

    @Test
    fun compares_two_run() {
        assertEquals(Run((2..5).red()), Run((2..5).red()))
        assertNotEquals(Run((2..5).green()), Run((2..5).blue()))
        assertNotEquals(Run((2..5).yellow()), Run((2..5).red()))
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

