package test.rummikub

import main.rummikub.blue
import main.rummikub.red
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TileTest {

    @Test
    fun compares_two_tiles() {
        assertEquals(3.red(), 3.red())
        assertNotEquals(3.red(), 12.red())
        assertNotEquals(3.red(), 3.blue())
    }
}
