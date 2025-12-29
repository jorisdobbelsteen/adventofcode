package nl.joris2k.adventofcode.y2025.day1

import kotlin.io.path.Path
import kotlin.io.path.useLines

data class Accumulator(
    val value: Int = 50,
    val zeros: Int = 0,
    val modulo: Int = 100,
) {
    operator fun plus(i: Int): Accumulator {
        val newValue = (value + i).mod(modulo)
        return Accumulator(
            newValue,
            if (newValue == 0) zeros + 1 else zeros,
            modulo)
    }
}

fun main() {
    val data = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day1/input.txt")

    // Computes final accumulator via signed input deltas
    val result = data.useLines { lines ->
        lines
            .map {
                toClicks(it)
            }.fold(Accumulator()) { acc, i ->
                acc + i
            }
    }

    println("Result: $result")
    println("Zeros: ${result.zeros}")
}

fun toClicks(string: String): Int = when (string[0]) {
    'L' -> -1
    'R' -> 1
    else -> throw IllegalArgumentException("Invalid direction: $string")
} * string.substring(1).toInt()
