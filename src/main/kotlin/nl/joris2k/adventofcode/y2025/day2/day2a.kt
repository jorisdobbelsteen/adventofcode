package nl.joris2k.adventofcode.y2025.day2

import java.util.Scanner
import kotlin.io.path.Path
import kotlin.sequences.filter

fun rangeStringToRange(range: String): LongRange {
    val (firstStr, secondStr) = range.trimEnd('\n').split('-', limit = 2)
    val first = firstStr.toLong()
    val second = secondStr.toLong()
    return LongRange(first, second)
}

/**
 * Checks if string has repeating halves
 */
fun isValid(value: Long): Boolean {
    val v = value.toString()
    if (v.length % 2 != 0)
        return true

    val h = v.length / 2
    for (i in 0 until h) {
        if (v[i] != v[h+i]) {
            return true
        }
    }
    return false
}

fun main() {
    val path = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day2/input.txt")
    // Use .use() to ensure the scanner is closed
    val result = Scanner(path).useDelimiter(",").use { scanner ->
        scanner.asSequence().map {
            rangeStringToRange(it)
        }.flatMap {
            it.asSequence().filter { !isValid(it) }
        }.sum()
    }
    println("Result: $result")
}
