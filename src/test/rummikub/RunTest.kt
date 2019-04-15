package test.rummikub

import main.rummikub.*
import org.junit.Test
import kotlin.test.assertEquals

class RunTest {

    @Test
    fun represents_a_run() {
        assertEquals("[2-3-4-5][red]", Run((2..5).red()).toString())
        assertEquals("[1-2-3][blue]", Run((1..3).blue()).toString())
        assertEquals("[8-9-10-11-12][green]", Run((8..12).green()).toString())
        assertEquals("[7-8-9][yellow]", Run((7..9).yellow()).toString())
    }
}

