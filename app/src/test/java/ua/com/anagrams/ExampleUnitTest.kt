package ua.com.anagrams

import org.junit.Test

import org.junit.Assert.*
import ua.com.anagrams.extensions.anagrams

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun anagram_test() {

        assertEquals("dcba hgfe", "abcd efgh".anagrams())
        assertEquals("d1cba hgf!e", "a1bcd efg!h".anagrams())
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

}
