package test.rummikub

import main.rummikub.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TileTest {

    @Test
    fun represents_a_tile() {
        assertEquals("[2-red]", 2.red().toString())
        assertEquals("[8-blue]", 8.blue().toString())
        assertEquals("[4-green]", 4.green().toString())
        assertEquals("[1-yellow]", 1.yellow().toString())
    }

    @Test
    fun compares_two_tiles() {
        assertEquals(3.red(), 3.red())
        assertNotEquals(3.red(), 12.red())
        assertNotEquals(3.red(), 3.blue())
    }
}
