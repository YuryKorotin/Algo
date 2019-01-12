package solution


class MaxXor {
    fun maxXor(arr: Array<Int>, queries: Array<Int>): Array<Int> {
        // solve here

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

    fun maxXorWithTrie(arr: Array<Int>, queries: Array<Int>): Array<Int> {
        // solve here

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
}