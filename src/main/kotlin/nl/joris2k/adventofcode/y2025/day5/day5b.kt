package nl.joris2k.adventofcode.y2025.day5

import kotlin.io.path.Path
import kotlin.io.path.useLines

fun main() {
    val data = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day5/input.txt")

    // Computes final accumulator via signed input deltas
    val valid = data.useLines { lines ->
        val iterator = lines.iterator()
        val validPre = iterator
            .takeWhile { it.isNotBlank() }
            //.onEach { println("Range line: $it") }
            .map { rangeStringToRange(it) }
            .toList()

        println("Valid ranges: ${validPre.size}")
        validPre
            .sortedWith { a, b ->
                val first = a.first.compareTo(b.first)
                if (first == 0) -(a.last.compareTo(b.last)) else first
            }
            .mergeRanges()
            .toList()
    }

    println("Condensed ranges: ${valid.size}")
    valid.forEach { println(it) }

    val result = valid.map {
        it.last - it.first + 1
    }.sum()

    println("Result: $result")
}

fun Iterable<LongRange>.mergeRanges() = sequence {
    // Assumes pre-sorted input
    var current = firstOrNull() ?: return@sequence
    for (range in drop(1)) {
        if (current.last + 1 >= range.first) {
            current = current.first..maxOf(current.last, range.last)
        } else {
            yield(current)
            current = range
        }
    }
    yield(current)
}
