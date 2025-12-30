package nl.joris2k.adventofcode.y2025.day3

import kotlin.io.path.Path
import kotlin.io.path.useLines

fun findFirstHighest(elements: String, start: Int, endInclusive: Int = elements.length-1): Int {
    require(start <= endInclusive) { "start must be <= endInclusive" }
    var best = start
    for (i in (start+1)..endInclusive) {
        if (elements[i] > elements[best])
            best = i
    }
    return best
}

fun findJoltageWithTwoElements(elements: String): String {
    val first = findFirstHighest(elements, 0, elements.length-2)
    val second = findFirstHighest(elements, first+1, elements.length-1)
    return "${elements[first]}${elements[second]}"
}

fun main() {
    val path = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day3/input.txt")
    // Computes final accumulator via signed input deltas
    val result = path.useLines { lines ->
        lines.map {
            findJoltageWithTwoElements(it).toInt()
        }.sum()
    }
    println("Result: $result")
}
