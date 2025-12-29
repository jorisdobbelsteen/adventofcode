package nl.joris2k.adventofcode.y2025.day2

import kotlin.test.*

class Day2aTest {
    @Test
    fun rangeStringToRange() {
        assertEquals(LongRange(11, 22), rangeStringToRange("11-22"))
    }

    @Test
    fun rangeToInvalidSequence() {
        assertContentEquals(listOf(11, 22), LongRange(11, 22).filter { !isValid(it) })
        assertContentEquals(listOf(99), LongRange(95, 115).filter { !isValid(it) })
        assertContentEquals( listOf(1010), LongRange(998, 1012).filter { !isValid(it) })
        assertContentEquals(listOf(1188511885), LongRange(1188511880, 1188511890).filter { !isValid(it) })
        assertContentEquals(listOf(222222), LongRange(222220, 222224).filter { !isValid(it) })
        assertContentEquals(emptyList(), LongRange(2121212118, 2121212124).filter { !isValid(it) })
    }

    @Test
    fun isValid() {
        assertTrue(isValid(12))
        assertTrue(isValid(13))
        assertTrue(isValid(101))
        assertTrue(isValid(1188511880))
    }

    @Test
    fun isInvalid() {
        assertFalse(isValid(11))
        assertFalse(isValid(22))
        assertFalse(isValid(55))
        assertFalse(isValid(6464))
        assertFalse(isValid(123123))
    }
}
