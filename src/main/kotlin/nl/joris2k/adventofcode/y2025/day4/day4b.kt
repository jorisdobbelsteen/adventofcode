package nl.joris2k.adventofcode.y2025.day4

import kotlin.io.path.Path
import kotlin.io.path.useLines

fun howManyToRemove(initial: List<CharSequence>) = sequence {
    var current = initial
    val next = current.map { CharArray(it.length) { i -> it[i] } }
    while (true) {
        val removableIndexes = accessibleLessThanFourAdjacent(current)
        val removable = removableIndexes.onEach { (x,y) ->
            next[x][y] = '.'
        }.count()
        yield(removable)
        current = next.map { String(it) }
    }
}

fun main() {
    val path = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day4/input.txt")
    val input = path.useLines { lines ->
        lines.toList()
    }

    val result = howManyToRemove(input)
        .takeWhile { it > 0 }
        .sum()

    println("Result: $result")
}
