package solution


class MaxCircles {
    fun maxCircle(queries: Array<Array<Int>>): Array<Int> {
        var originalLinks : MutableList<Int> = mutableListOf()

        for (i in 0 until queries.size) {
            originalLinks.add(queries[i][0], queries[i][1])
        }

        originalLinks = originalLinks.sort().distinct()
        val analyzedLinks = originalLinks.copyOf().toMutableList()

        for (i in 0 until queries.size) {
            val min = minOf(queries[i][0], queries[i][1])
            val other = maxOf(queries[i][0], queries[i][1])

            val minPosition = originalLinks.binarySearch(min)
            val otherPosition = originalLinks.binarySearch(other)

            val currentValueAtOtherPos = analyzedLinks.get(otherPosition)

            val valuesToSet = listOf(min)
            if (currentValueAtOtherPos != originalLinks.get(otherPosition)) {
                analyzedLinks.forEachIndexed{ index, item ->
                    if (item == currentValueAtOtherPos) {
                        analyzedLinks.set(index, min)
                    }
                }
            } else {
                analyzedLinks.set(otherPosition, min)
            }
        }

        println(analyzedLinks.joinToString("-"))

        return analyzedLinks.toTypedArray()
    }
}