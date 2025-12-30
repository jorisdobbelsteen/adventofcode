package nl.joris2k.adventofcode.y2025.day5

import kotlin.io.path.Path
import kotlin.io.path.useLines
import kotlin.time.Duration
import kotlin.time.measureTime

fun mainInitial() {
    val data = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day5/input.txt")

    // Computes final accumulator via signed input deltas
    val result = data.useLines { lines ->
        val iterator = lines.iterator()
        val valid = iterator
            .takeWhile { it.isNotBlank() }
            //.onEach { println("Range line: $it") }
            .map { rangeStringToRange(it) }
            .toList()
            .sortedBy { it.first }

        println("Valid ranges: ${valid.size}")
        //valid.forEach { println(it) }

        // Ranges are overlapping...

        iterator
            .remainingAsSequence()
            .map { it.toLong() }
            //.onEach { println("Checking line: $it") }
            .filter { value ->
                //valid.any { it.contains(value) }
                valid.asSequence()
                    .takeWhile { it.first <= value }
                    .any { it.contains(value) }
            }.count()
    }

    println("Result: $result")
}

fun mainImproved() {
    val data = Path("src/main/resources/nl/joris2k/adventofcode/y2025/day5/input.txt")

    // Computes final accumulator via signed input deltas
    val result = data.useLines { lines ->
        val iterator = lines.iterator()
        val valid = iterator
            .takeWhile { it.isNotBlank() }
            //.onEach { println("Range line: $it") }
            .map { rangeStringToRange(it) }
            .toList()
            .sortedBy { it.first }
            .mergeRanges() // Take from part B
            .toList()

        println("Valid ranges: ${valid.size}")
        //valid.forEach { println(it) }

        // Ranges are NOT overlapping, so we can search effectively

        iterator
            .remainingAsSequence()
            .map { it.toLong() }
            //.onEach { println("Checking line: $it") }
            .filter { value ->
                val foundIndex = valid.binarySearch { it.first.compareTo(value) }
                if (foundIndex == -1) return@filter false
                val index = if (foundIndex < 0) -foundIndex-2 else foundIndex
                valid[index].contains(value)
            }.count()
    }

    println("Result: $result")
}

fun time(): Pair<Duration, Duration> {
    val initial = measureTime {
        mainInitial()
    }
    val improved = measureTime {
        repeat(10) { mainImproved() }
    }
    return Pair(initial, improved)
}

fun main() {
    val measurements = List(110) {
        time()
    }.drop(10)

    println("Duration average initial:  ${measurements.sumOf { it.first.inWholeMicroseconds } / measurements.size} us")
    println("                 improved: ${measurements.sumOf { it.second.inWholeMicroseconds } / measurements.size} us")
    println("         max     initial:  ${measurements.maxOf { it.first.inWholeMicroseconds }} us")
    println("                 improved: ${measurements.maxOf { it.second.inWholeMicroseconds }} us")
}

fun rangeStringToRange(range: String): LongRange {
    val (firstStr, secondStr) = range.trimEnd('\n').split('-', limit = 2)
    val first = firstStr.toLong()
    val second = secondStr.toLong()
    return LongRange(first, second)
}

fun <T> Iterator<T>.remainingAsSequence() = Sequence { this }

fun <T> Iterator<T>.takeWhile(function: (T) -> Boolean) = sequence {
    while (hasNext()) {
        val value = next()
        if (!function(value))
            break
        yield(value)
    }
}
