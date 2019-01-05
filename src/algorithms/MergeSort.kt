

class MergeSort {
    fun sort(source: Array<Int>) {
        sortByMerging(source, Array(source.size, {0}), 0, source.size - 1)
    }

    fun sortByMerging(source: Array<Int>, buffer: Array<Int>, start: Int, end: Int) {
        if (start >= end) {
            return
        }

        val halfSize = (start + end) / 2

        sortByMerging(source, buffer, start, halfSize)
        sortByMerging(source, buffer, halfSize + 1, end)
        mergeHalves(source, buffer, start, end)
    }

    fun mergeHalves(source: Array<Int>, buffer: Array<Int>, start, end)  {
        val leftEnd = (end + start) / 2
        val rightStart = (leftEnd + 1)
        val size = end - start + 1

        var left = start
        var right = rightStart
        var index = start

        while (left <= newEnd && right <= end) {
            if (sourcep[left] <= source[right]) {
                buffer[index] = source[left]
                index++
                left++
            } else {
                buffer[index] = source[right]
                right++
            }
            index++
        }
        //public static void arraycopy(Object source, int sourcePosition,
        // Object destination, int destinationPosition, int numberOfElements)

        copy(source, left, buffer, index, leftEnd - left + 1)
        copy(source, right, buffer, index, end - right + 1)
        copy(buffer, start, source, start, size)
    }

    fun copy(source: Array<Int>,
            sourcePosition: Int,
            destination: Array<Int>,
            destinationPosition: Int,
            numberOfElements: Int) {

        var destinationIndex = destinationPosition

        for (i in sourcePosition until sourcePosition + numberOfElements) {
            destination[destinationIndex] = source[i]
            destinationIndex++
        }
    }
}
