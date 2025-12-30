package nl.joris2k.adventofcode.y2025.day3

import kotlin.io.path.Path
import kotlin.io.path.useLines

fun findJoltageWithTwelveElements(elements: String): String {
    val result = CharArray(12)
    val firstLast = elements.length - result.size
    assert(firstLast + result.size - 1 == elements.length - 1)
    var index = -1
    for (i in 0 until 12) {
        index = findFirstHighest(elements, index + 1, firstLast + i)
        result[i] = elements[index]
    }
    return String(result)
}

fun main() {
    val path = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day3/input.txt")
    // Computes final accumulator via signed input deltas
    val result = path.useLines { lines ->
        lines.map {
            findJoltageWithTwelveElements(it).toLong()
        }.sum()
    }
    println("Result: $result")
}
