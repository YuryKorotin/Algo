
//INCLUDE algorithms/MergeSort.kt

class CountingInversions {
    fun countInversions(arr: Array<Int>): Long {
        val sorter = MergeSort()
        //val result : List<Int> = sorter.sort(arr.toMutableList())

        val swapsCount: Long = sorter.countSwaps(arr.toMutableList())

        //result.joinToString("-"))

        return swapsCount
    }
}