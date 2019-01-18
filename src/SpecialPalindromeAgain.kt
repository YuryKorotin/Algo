package solution

class SpecialPalindromeAgain {

    //data class WordInfo(var middleChar : Char = -1, counts : MutableHashMap<Char, Int>)

    fun substrCountSlow(n: Int, s: String): Long {
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

    fun substrCount(n: Int, s: String): Long {
        var palindromCount : Long = 0

        val counts = mutableListOf<Pair<Char, Int>>()

        var character = s.get(0)
        var count = 1

        for(i in 1 until s.length) {

            if (character != s.get(i)) {

                counts.add(Pair(character, count))

                character = s.get(i)
                count = 1
            } else {
                count++
            }
        }

        counts.add(Pair(character, count))

        counts.forEach { item ->
            palindromCount += item.second * (item.second + 1) / 2
        }

        for(i in 1 until counts.size - 1) {
            val first = counts.get(i - 1)
            val third = counts.get(i + 1)
            if(first.first == third.first && counts.get(i).second == 1) {
                palindromCount += minOf(first.second, third.second)
            }
        }

        return palindromCount

        /*substringsCollection.filter { string ->
            string.toCharArray().distinct().size < 3
        }*/

        /*substringsCollection.forEach { current ->
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
            }

            if (valid) {
                //println(current)
                palindromCount += 1L
            }
        }*/

        return palindromCount
    }
}