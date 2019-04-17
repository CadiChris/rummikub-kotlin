package main.rummikub

data class Table(val runs: List<Run>) {

    fun add(aTile: Tile): Table {
        var newRuns = emptyList<Run>()

        runs.forEach {
            newRuns = if (it.canBeExtendedWith(aTile)) {
                newRuns.plus(it.extendWith(aTile))
            } else newRuns.plus(it)
        }

        return Table(newRuns)
    }

}
