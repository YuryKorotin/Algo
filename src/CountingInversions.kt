
//INCLUDE algorithms/MergeSort.kt

class CountingInversions {
    fun countInversions(arr: Array<Int>): Long {
        val sorter = MergeSort()
        val result : List<Int> = sorter.sort(arr.toMutableList())

        println(result.joinToString("-"))

        return 0L
    }
}