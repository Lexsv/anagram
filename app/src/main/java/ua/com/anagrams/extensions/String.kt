package ua.com.anagrams.extensions

fun String?.anagrams(): String? {
    if (this == null)return "null"
    var result = ""
    val parser: List<String> = this.trim().split(" ")

    for (string in parser) {

        val buffResultList: MutableList<Char> = string.toMutableList()
        var begin = 0
        var end = buffResultList.size - 1

        while (end - begin >= 0) {
            var bufferChar: Char
            when {
                !buffResultList[begin].isLetter() && !buffResultList[end].isLetter() -> {
                    begin++
                    end--
                }
                buffResultList[begin].isLetter() && !buffResultList[end].isLetter() -> {
                    end--
                }
                !buffResultList[begin].isLetter() && buffResultList[end].isLetter() -> {
                    begin++
                }
                buffResultList[begin].isLetter() && buffResultList[end].isLetter() -> {
                    bufferChar = buffResultList[begin]
                    buffResultList[begin] = buffResultList[end]
                    buffResultList[end] = bufferChar
                    begin++
                    end--
                }
            }
        }
        result += String(buffResultList.toCharArray()) + " "
    }
    return result.trim()
}