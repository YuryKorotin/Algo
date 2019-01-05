package solution.algorithms

class CountingSort(val maxValue: Int) {
    lateinit var countingArray: Array<Int>
    lateinit var originalCounts: Array<Int>

    init {
        countingArray = Array(maxValue, { 0 })
        originalCounts = Array(maxValue, { 0 })
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
            result[countingArray[item]] = item
            countingArray[item] -= 1
        }

        return result
    }

    fun sortWithoutMutation(source: Array<Int>) {
        countingArray = Array(maxValue, { 0 })

        source.forEach{ item ->
            countingArray[item] += 1
        }

        var prev = countingArray[0]
        for (i in 0 until countingArray.size) {
            countingArray[i] += prev
            prev = countingArray[i]
        }
    }

    fun traceCounts(place : String = "everywhere") {
        println(place + "__start__")
        countingArray.forEach { item ->
            print(item)
            print("-")
        }
        println("__end__")
    }

    fun getMedianDoubledValue(d: Int) : Int {
        var mediana = 0
        val isOdd = d % 2 != 0
        val halfSize = d / 2

        //traceCounts()

        if (isOdd) {
            mediana = searchForPosition(halfSize + 1) * 2
        } else {
            mediana = searchForPosition(halfSize) + searchForPosition(halfSize + 1)
        }

        return mediana
    }

    fun searchForPosition(position: Int) : Int {
        var result = 0
        for (i in 0 until countingArray.size) {
            result = i
            if (countingArray[i] >= position) {
                break
            }
        }

        return result
    }

    fun findMedianDoubledValue(itemToRemove: Int,
                        newItem: Int,
                        d: Int) : Int {
        for (i in itemToRemove until countingArray.size) {
            countingArray[i] -= 1
        }

        for (i in newItem until countingArray.size) {
            countingArray[i] += 1
        }

        return getMedianDoubledValue(d)
    }
}