package ua.com.anagrams

import org.junit.Test

import org.junit.Assert.*
import org.junit.runners.Parameterized
import ua.com.anagrams.extensions.anagrams

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun anagram_test() {

        assertEquals("wqd12da2", "add12qw2".anagrams())
        assertEquals("d1cba hgf!e", "a1bcd efg!h".anagrams())
        assertEquals("1230 122! 455**", "1230 122! 455**".anagrams())
        assertNull(null.anagrams())
    }


}
