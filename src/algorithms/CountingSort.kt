package solution.algorithms

class CountingSort(val maxValue: Int) {
    lateinit var countingArray: Array<Int>
    lateinit var originalCounts: Array<Int>

    init {
        countingArray = Array(maxValue, { 0 })
    }

    fun sort(source: Array<Int>) : Array<Int>{
        countingArray = Array(maxValue, { 0 })
        val result : Array<Int> = Array(source.size, {0})

        source.forEach{ item ->
            countingArray[item] += 1
        }

        var prev = countingArray[0]
        for (i in 1 until countingArray.size) {
            countingArray[i] += prev
            prev = countingArray[i]
        }

        originalCounts = countingArray.copyOf()

        source.forEachIndexed { index, item ->
            result[countingArray[item] - 1] = item
            countingArray[item] -= 1
        }

        return result
    }

    fun resort(source: Array<Int>, newItem: Int) : Array<Int>{
        countingArray = originalCounts.copyOf()
        val itemToRemove = source[0]

        for (i in itemToRemove until countingArray.size) {
            countingArray[i] -= 1
        }

        for (i in newItem until countingArray.size) {
            countingArray[i] += 1
        }

        val result : Array<Int> = Array(source.size, {0})

        originalCounts = countingArray.copyOf()

        source.forEachIndexed { index, item ->
            result[countingArray[item]] = item
            countingArray[item] -= 1
        }

        return result
    }
}