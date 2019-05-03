package main.rummikub.game

class TableMaker(
    private val aTable: Table
) {
    fun nextTableWith(aHand: Hand): Table {
        return aHand.tiles.fold(aTable, { table, tile ->
            table.add(tile)
        })
    }
}
