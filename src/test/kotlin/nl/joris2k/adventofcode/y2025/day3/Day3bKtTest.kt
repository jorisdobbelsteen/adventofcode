package nl.joris2k.adventofcode.y2025.day3

import kotlin.test.*

/**
 * The `Day3aKtTest` class contains unit tests for the `findFirstHighest` function.
 * 
 * The `findFirstHighest` function takes a string `elements` and a starting index `start`, and 
 * optionally an ending index `endInclusive`. It returns the index of the first highest character
 * found within the given range of indices. The function uses comparison based on character order.
 */
class Day3bKtTest {
    @Test
    fun findJoltageTwelve() {
        assertEquals("987654321111", findJoltageWithTwelveElements("987654321111111"))
        assertEquals("811111111119", findJoltageWithTwelveElements("811111111111119"))
        assertEquals("434234234278", findJoltageWithTwelveElements("234234234234278"))
        assertEquals("888911112111", findJoltageWithTwelveElements("818181911112111"))
    }
}
