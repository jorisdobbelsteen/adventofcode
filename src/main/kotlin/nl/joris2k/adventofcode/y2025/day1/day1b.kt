package nl.joris2k.adventofcode.y2025.day1

import kotlin.io.path.Path
import kotlin.io.path.useLines
import kotlin.math.absoluteValue

data class AccumulatorB(
    val value: Int = 50,
    val zeros: Int = 0,
    val modulo: Int = 100,
) {
    operator fun plus(i: Int): AccumulatorB {
        val extraRounds = i.div(modulo).absoluteValue
        val j = i.rem(modulo)
        val newValue = (value + j).mod(modulo)
        val passedZero = if (value == 0)
            false
        else if (j < 0)
            // if more clicks than value
            value <= -j
        else
            // if more than (modulo - value) clicks
            (modulo - value) <= j
        return AccumulatorB(
            newValue,
            zeros + extraRounds + if (passedZero) 1 else 0,
            modulo)
    }
}

fun main() {
    val path = Path("src/main/kotlin/nl/joris2k/adventofcode/y2025/day1/input.txt")

    // Computes final accumulator via signed input deltas
    val result = path.useLines { lines ->
        lines
            .map {
                toClicks(it)
            }.fold(AccumulatorB()) { acc, i ->
                acc + i
            }
    }

    println("Result: $result")
    println("Zeros: ${result.zeros}")
}
