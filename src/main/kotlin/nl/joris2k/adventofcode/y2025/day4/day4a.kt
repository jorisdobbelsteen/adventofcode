package nl.joris2k.adventofcode.y2025.day4

import kotlin.io.path.Path
import kotlin.io.path.useLines

fun isOccupied(value: Char) = value == '@'

fun List<String>.xyIndexes() = sequence {
    for (x in indices)
        for (y in this@xyIndexes[x].indices)
            yield(x to y)
}

fun List<String>.get(index: Pair<Int,Int>): Char {
    val (x, y) = index
    if (x < 0 || y < 0 || x >= size || y >= this[x].length)
        return '.'
    return this[x][y]
}

fun adjacentIndexes(x: Int, y: Int): Sequence<Pair<Int, Int>> = sequence {
    yield(x-1 to y-1)
    yield(x-1 to y)
    yield(x-1 to y+1)
    yield(x to y-1)
    //Skip
    yield(x to y+1)
    yield(x+1 to y-1)
    yield(x+1 to y)
    yield(x+1 to y+1)
}
fun adjacentIndexes(index: Pair<Int,Int>) = adjacentIndexes(index.first, index.second)

fun accessibleLessThanFourAdjacent(input: List<String>)  =
    input.xyIndexes().filter {
        isOccupied(input.get(it))
    }.filter { index ->
        adjacentIndexes(index).count {
            isOccupied(input.get(it))
        } < 4
    }

fun main() {
    val path = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day4/input.txt")
    val input = path.useLines { lines ->
        lines.toList()
    }
    val result = accessibleLessThanFourAdjacent(input).count()

    println("Result: $result")
}
