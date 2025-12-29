package nl.joris2k.adventofcode.y2025.day2

import java.util.Scanner
import kotlin.io.path.Path
import kotlin.sequences.filter

private fun hasRepeatingPattern(value: String, pLen: Int, repetitions: Int): Boolean {
    for (r in 1 until repetitions) {
        val offset = pLen * r
        for (i in 0 until pLen) {
            if (value[i] != value[offset + i])
                return false
        }
    }
    return true
}

/**
 * Checks if string has repeating halves
 */
fun isValidB(value: Long): Boolean {
    // Pattern lengths
    val v = value.toString()
    val vLen = v.length // length of the input
    for (pLen in 1..v.length / 2) { // pattern length
        if (vLen % pLen != 0)
            continue // Not divisible
        val repetitions = vLen / pLen // number of patterns
        if (hasRepeatingPattern(v, pLen, repetitions))
            return false
    }
    return true
}

fun main() {
    val path = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day2/input.txt")
    // Use .use() to ensure the scanner is closed
    val result = Scanner(path).useDelimiter(",").use { scanner ->
        scanner.asSequence().map {
            rangeStringToRange(it)
        }.flatMap {
            it.asSequence().filter { !isValidB(it) }
        }.sum()
    }
    println("Result: $result")
}
