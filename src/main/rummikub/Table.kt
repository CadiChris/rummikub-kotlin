package main.rummikub

data class Table(
    private val runs: List<Run> = emptyList(),
    private val groups: List<Group> = emptyList()
) {

    fun add(aTile: Tile): Table {
        var tileUsed = false
        var newRuns = emptyList<Run>()

        runs.forEach { run ->
            val extendedRun = run.extendWith(aTile)
            if (extendedRun != run && !tileUsed) {
                tileUsed = true
                newRuns = newRuns.plus(extendedRun)
            } else newRuns = newRuns.plus(run)
        }

        var newGroups = emptyList<Group>()
        groups.forEach { group ->
            val extendedGroup = group.extendWith(aTile)
            if(!tileUsed && extendedGroup != group) {
                tileUsed = true
                newGroups = newGroups.plus(extendedGroup)
            } else newGroups = newGroups.plus(group)
        }


        return Table(runs = newRuns, groups = newGroups)
    }

    override fun toString(): String {
        val runsPrint = """RUNS : ${runs.joinToString()}"""
        val groupsPrint = """GROUPS : ${groups.joinToString()}"""

        return "$runsPrint\n$groupsPrint"
    }
}
