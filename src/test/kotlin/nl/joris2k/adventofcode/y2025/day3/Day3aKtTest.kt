package nl.joris2k.adventofcode.y2025.day3

import kotlin.test.*

/**
 * The `Day3aKtTest` class contains unit tests for the `findFirstHighest` function.
 * 
 * The `findFirstHighest` function takes a string `elements` and a starting index `start`, and 
 * optionally an ending index `endInclusive`. It returns the index of the first highest character
 * found within the given range of indices. The function uses comparison based on character order.
 */
class Day3aKtTest {
    @Test
    fun testFindFirstHighestWithDefaultEnd() {
        val elements = "abczba"
        val result = findFirstHighest(elements, 0)
        assertEquals(3, result, "The index of the highest element should be 3 (character 'z').")
    }

    @Test
    fun testFindFirstHighestWithCustomRange() {
        val elements = "xayczba"
        val result = findFirstHighest(elements, 2, 5)
        assertEquals(4, result, "The highest element between indices 2 and 5 is at index 4 (character 'z').")
    }

    @Test
    fun testFindFirstHighestWhenAllEqual() {
        val elements = "aaaaa"
        val result = findFirstHighest(elements, 1, 4)
        assertEquals(1, result, "When all elements are equal, the first occurrence (start index) should be returned.")
    }

    @Test
    fun testFindFirstHighestSingleElement() {
        val elements = "abcd"
        val result = findFirstHighest(elements, 2, 2)
        assertEquals(2, result, "For a single-element range, the start index should be returned.")
    }

    @Test
    fun findJoltageTwo() {
        assertEquals("98", findJoltageWithTwoElements("987654321111111"))
        assertEquals("89", findJoltageWithTwoElements("811111111111119"))
        assertEquals("78", findJoltageWithTwoElements("234234234234278"))
        assertEquals("92", findJoltageWithTwoElements("818181911112111"))
    }
}
