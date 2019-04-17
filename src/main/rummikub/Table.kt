package main.rummikub

data class Table(
    private val runs: List<Run>
) {

    fun add(aTile: Tile): Table {
        var tileUsed = false
        var newRuns = emptyList<Run>()

        runs.forEach { run ->
            val extendedRun = run.extendWith(aTile)
            if (extendedRun !== run && !tileUsed) {
                tileUsed = true
                newRuns = newRuns.plus(extendedRun)

            } else newRuns = newRuns.plus(run)
        }

        return Table(newRuns)
    }

    override fun toString(): String {
        return runs.joinToString()
    }
}
