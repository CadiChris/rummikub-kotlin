package test.rummikub.game

import main.rummikub.blocks.Group
import main.rummikub.blocks.Run
import main.rummikub.game.Table

fun BuildTable(vararg runs: Run) = Table(runs = runs.toList())
fun BuildTable(vararg groups: Group) = Table(groups = groups.toList())