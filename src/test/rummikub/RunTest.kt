package test.rummikub

import main.rummikub.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class RunTest {

    @Test
    fun compares_two_run() {
        assertEquals(Run(2..5, Suit.Red), Run(2..5, Suit.Red))
        assertNotEquals(Run(2..5, Suit.Green), Run(2..5, Suit.Blue))
        assertNotEquals(Run(2..5, Suit.Green), Run(2..5, Suit.Red))
    }

    @Test
    fun a_run_can_be_extended_by_the_left_with_same_suit() {
        assertEquals(
            Run(3..6, Suit.Red),
            Run(4..6, Suit.Red).extendWith(3.red())
        )
    }

    @Test
    fun a_run_can_be_extended_by_the_right_with_same_suit() {
        assertEquals(
            Run(8..12, Suit.Blue),
            Run(8..11, Suit.Blue).extendWith(12.blue())
        )
    }

    @Test
    fun a_run_cannot_be_extended_with_different_suit() {
        assertEquals(
            Run(9..11, Suit.Green),
            Run(9..11, Suit.Green).extendWith(8.yellow())
        )
    }
}

