package nl.joris2k.adventofcode.y2025.day2

import kotlin.test.*

class Day2bTest {
    @Test
    fun rangeToInvalidSequence() {
        assertContentEquals(listOf(11, 22), LongRange(11, 22).filter { !isValidB(it) })
        assertContentEquals(listOf(99, 111), LongRange(95, 115).filter { !isValidB(it) })
        assertContentEquals( listOf(999, 1010), LongRange(998, 1012).filter { !isValidB(it) })
        assertContentEquals(emptyList(), LongRange(1698522, 1698528).filter { !isValidB(it) })
        assertContentEquals(listOf(1188511885), LongRange(1188511880, 1188511890).filter { !isValidB(it) })
        assertContentEquals(listOf(222222), LongRange(222220, 222224).filter { !isValidB(it) })
        assertContentEquals(listOf(2121212121), LongRange(2121212118, 2121212124).filter { !isValidB(it) })
    }

    @Test
    fun isValid() {
        assertTrue(isValidB(12))
        assertTrue(isValidB(13))
        assertTrue(isValidB(101))
        assertTrue(isValidB(1188511880))
    }

    @Test
    fun isInvalid() {
        assertFalse(isValidB(11))
        assertFalse(isValidB(22))
        assertFalse(isValidB(55))
        assertFalse(isValidB(99))
        assertFalse(isValidB(111))
        assertFalse(isValidB(6464))
        assertFalse(isValidB(123123))

        // Extra's
        assertFalse(isValidB(12341234))
        assertFalse(isValidB(123123123))
        assertFalse(isValidB(1212121212))
        assertFalse(isValidB(1111111))
    }
}
