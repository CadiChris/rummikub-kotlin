package main.rummikub

class TableMaker(private val aTable: Table) {
    fun nextTableWith(aHand: Hand): Table {
        return aTable.add(aHand.tile)
    }
}
