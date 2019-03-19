//INCLUDE solutions/Solution.kt

class StringCompression : Solution {
    companion object {
        const val ALPHABET_SIZE = 52
    }

    fun compress(source: String): String {
        var result = ""

        var prev = source[0]
        var count = 0
        for (i in 1 until source.length) {
            count++

            if (i + 1 >= source.length) {
                count++
                result += prev + count.toString()
            } else if (source[i] != prev) {
                result += prev + count.toString()
                count = 0
            }

            prev = source[i]
        }

        println(result)

        if (source.length <= result.length) {
            return source
        }

        return result
    }
}