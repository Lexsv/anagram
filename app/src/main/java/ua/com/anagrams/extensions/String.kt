package ua.com.anagrams.extensions

import java.lang.StringBuilder
import java.util.*

fun String.anagrams(): String {
    var result = ""


    var parser: List<String> = this.trim().split(" ")
    for (string in parser) {

        val buffResultList: MutableList<Char> = string.toMutableList()
        var begin = 0
        var end = buffResultList.size - 1

        while (end - begin >= 0) {
            var bufferChar: Char
            when {

                !buffResultList.get(begin).isLetter() && !buffResultList.get(end).isLetter() -> {
                    begin++
                    end--
                }

                buffResultList.get(begin).isLetter() && !buffResultList.get(end).isLetter() -> {
                    end--
                }

                !buffResultList.get(begin).isLetter() && buffResultList.get(end).isLetter() -> {
                    begin++
                }


                buffResultList.get(begin).isLetter() && buffResultList.get(end).isLetter() -> {
                    bufferChar = buffResultList.get(begin)
                    buffResultList.set(begin, buffResultList.get(end))
                    buffResultList.set(end, bufferChar)
                    begin++
                    end--
                }
            }
        }
        result += String(buffResultList.toCharArray()) + " "
    }

    return result.trim()
}