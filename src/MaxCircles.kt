package solution

//INCLUDE UnionFinder.kt

class MaxCircles {
    fun oldMaxCircle(queries: Array<Array<Int>>): Array<Int> {
        var originalLinks : MutableList<Int> = mutableListOf()

        for (i in 0 until queries.size) {
            originalLinks.add(queries[i][0])
            originalLinks.add(queries[i][1])
        }

        originalLinks = originalLinks.sorted().distinct().toMutableList()

        val analyzedLinks : MutableList<Int> = mutableListOf<Int>()

        analyzedLinks.addAll(originalLinks)

        val maximums = Array(queries.size, {2})
        var max = 2

        for (i in 0 until queries.size) {
            val min = minOf(queries[i][0], queries[i][1])
            val other = maxOf(queries[i][0], queries[i][1])

            val minPosition = originalLinks.binarySearch(min)
            val otherPosition = originalLinks.binarySearch(other)

            val currentValueAtOtherPos = analyzedLinks.get(otherPosition)
            val currentValueAtMinPos = analyzedLinks.get(minPosition)

            val valuesToSet = listOf(min)

            if (currentValueAtOtherPos != originalLinks.get(otherPosition)) {
                analyzedLinks.forEachIndexed { index, item ->
                    if (item == currentValueAtOtherPos) {
                        analyzedLinks.set(index, min)
                    }
                }
            } else {
                analyzedLinks.set(otherPosition, min)
            }

            if (currentValueAtMinPos != originalLinks.get(minPosition)) {
                analyzedLinks.forEachIndexed { index, item ->
                    if (item == currentValueAtMinPos) {
                        analyzedLinks.set(index, min)
                    }
                }
            }

            var circleSize = 0
            analyzedLinks.forEachIndexed { index, item ->
                if (item == min) {
                    circleSize++
                }
            }

            if (circleSize > max) {
                max = circleSize
            }

            val joined = analyzedLinks.joinToString("-")

            println("max is $max")
            println("matrix is $joined")

            maximums[i] = max
        }

        return maximums
    }

    fun maxCircle(queries: Array<Array<Int>>): Array<Int> {

        val finder = UnionFinder()

        val maximums = Array(queries.size, {2})

        for (i in 0 until queries.size) {

            finder.union(queries[i][0], queries[i][1])

            maximums[i] = finder.max

        }

        return maximums
    }
}