package nl.joris2k.adventofcode.y2025.day1

import kotlin.test.*

class Day1bTest {
    @Test
    fun testExample() {
        val lines = listOf(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82",
        )
        val result = lines
            .map {
                toClicks(it)
            }.fold(AccumulatorB()) { acc, i ->
                acc + i
            }
        assertEquals(6, result.zeros)
    }

    @Test
    fun testOne() {
        assertEquals(
            AccumulatorB(82, 1),
            AccumulatorB(50, 0) + -68
        )
    }

    @Test
    fun testTwo() {
        assertEquals(
            AccumulatorB(52, 1),
            AccumulatorB(82, 1) + -30
        )
    }

    @Test
    fun testThree() {
        assertEquals(
            AccumulatorB(0, 2),
            AccumulatorB(52, 1) + 48
        )
    }

    @Test
    fun testFour() {
        assertEquals(
            AccumulatorB(95, 2),
            AccumulatorB(0, 2) + -5
        )
    }
}