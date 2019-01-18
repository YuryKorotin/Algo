package solution


//INCLUDE data_structures/TrieForBits.kt

class MaxXor {
    fun maxXorSimple(arr: Array<Int>, queries: Array<Int>): Array<Int> {
        val result = Array<Int>(queries.size, {0})

        val sortedSource = arr.sorted()

        for (i in 0 until queries.size) {
            var max = queries[i]
            sortedSource.forEach { item ->
                if (queries[i].xor(item) > max) {
                    max = queries[i].xor(item)
                }
            }
            result[i] = max
        }

        return result
    }

    //fun maxXorWithTrie(arr: Array<Int>, queries: Array<Int>): Array<Int> {
    fun maxXor(arr: Array<Int>, queries: Array<Int>): Array<Int> {
        val result = Array<Int>(queries.size, {0})

        val trie = TrieForBits()

        arr.forEach{ item ->
            trie.add(item)
        }

        val cache = mutableMapOf<Int, Int>()

        for (i in 0 until queries.size) {
            var max = 0

            if (cache.containsKey(queries[i])) {
                max = cache.get(queries[i])!!
            } else {
                max = trie.getMaxXor(queries[i])
                cache.put(queries[i], max)
            }

            result[i] = max
        }

        return result
    }
}