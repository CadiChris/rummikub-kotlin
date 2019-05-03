package test.rummikub.blocks

import main.rummikub.blocks.Group
import main.rummikub.blocks.Suit
import main.rummikub.blocks.blue
import main.rummikub.blocks.red
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class GroupTest {

    @Test
    fun compares_two_groups() {
        assertEquals(
            Group(
                4,
                setOf(Suit.Blue, Suit.Yellow, Suit.Red)
            ),
            Group(
                4,
                setOf(Suit.Blue, Suit.Yellow, Suit.Red)
            )
        )

        assertNotEquals(
            Group(
                7,
                setOf(Suit.Blue, Suit.Yellow, Suit.Red)
            ),
            Group(
                2,
                setOf(Suit.Blue, Suit.Yellow, Suit.Red)
            )
        )

        assertNotEquals(
            Group(
                3,
                setOf(Suit.Green, Suit.Yellow, Suit.Red)
            ),
            Group(
                3,
                setOf(Suit.Blue, Suit.Yellow, Suit.Red)
            )
        )
    }

    @Test
    fun can_extend_a_group_with_the_same_value_of_missing_suit() {
        val missingSixBlue = Group(
            6,
            setOf(Suit.Green, Suit.Red, Suit.Yellow)
        )

        val completeGroup = Group(6, ALL_SUITS())

        assertEquals(
            completeGroup,
            missingSixBlue.extendWith(6.blue())
        )
    }

    @Test
    fun cannot_extend_a_group_with_a_different_value() {
        val missingTwoRed = Group(
            2,
            setOf(Suit.Green, Suit.Blue, Suit.Yellow)
        )

        assertEquals(
            missingTwoRed,
            missingTwoRed.extendWith(7.red())
        )
    }

}