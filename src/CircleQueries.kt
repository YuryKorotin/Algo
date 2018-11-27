package solution


//INCLUDE UnionFinder.kt

open class CircleQueries {

    open fun maxCircle(queries: Array<Array<Int>>) : Array<Int> {
        val uf = UnionFinder()
        val result = Array<Int>(queries.size, {0})
        for (i in 0 until queries.size) {
            uf.union(queries[i][0], queries[i][1])
            result[i] = uf.max
        }

        return result
    }

    open fun calculate(input : List<String>) : List<String> {
        val queue = QueueOnList<Int>()
        var convertedInput = Array<Array<Int>>(input.size, {Array<Int>(2, {0})})

        input.forEachIndexed { index, item ->
            val convertedItem = item.split(" ").map{ item ->
                item.toInt()
            }
            convertedInput[index] = convertedItem.toTypedArray()
        }

        val result : Array<Int> = maxCircle(convertedInput)

        var output : MutableList<String> = mutableListOf()

        result.forEach { item ->
            output.add(item.toString())
        }

        return output
    }
}