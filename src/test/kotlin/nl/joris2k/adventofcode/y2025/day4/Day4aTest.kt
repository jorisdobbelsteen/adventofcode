package nl.joris2k.adventofcode.y2025.day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4aTest {
    @Test
    fun accessibleLessThanFourAdjacent() {
        val input = listOf(
        "..@@.@@@@.",
        "@@@.@.@.@@",
        "@@@@@.@.@@",
        "@.@@@@..@.",
        "@@.@@@@.@@",
        ".@@@@@@@.@",
        ".@.@.@.@@@",
        "@.@@@.@@@@",
        ".@@@@@@@@.",
        "@.@.@@@.@.",
        )
        assertEquals(13, accessibleLessThanFourAdjacent(input).count())
    }
}