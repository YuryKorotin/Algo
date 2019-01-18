package solution

class SpecialPalindromeAgain {
    fun substrCount(n: Int, s: String): Long {
        var palindromCount : Long = n.toLong()

        val substringsCollection = mutableListOf<String>()

        for(i in 2..s.length) {
            for(j in 0 until s.length - i + 1) {
                substringsCollection.add(s.substring(j, j + i))
            }
        }

        substringsCollection.forEach { current ->
            //println(current)
            val len = current.length
            var valid = true
            var prev : Char? = null
            for(i in 0 until len / 2) {
                val cur = current.get(i)

                if (cur != current.get(len - i - 1) ||
                        prev != null && cur != prev) {
                    valid = false
                    break
                }

                prev = current.get(i)
            }

            if (valid) {
                //println(current)
                palindromCount += 1L
            }
        }

        return palindromCount
    }
}