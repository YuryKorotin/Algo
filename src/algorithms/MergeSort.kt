

class MergeSort() {
    fun sort(source: List<Int>) : List<Int> {
        if (source.size <= 1) {
            return source
        }

        val middle = source.size / 2
        var left = source.subList(0, middle);
        var right = source.subList(middle, source.size);

        return merge(sort(left), sort(right))
    }

    fun merge(left: List<Int>, right: List<Int>): List<Int>  {
        var indexLeft = 0
        var indexRight = 0
        var newList : MutableList<Int> = mutableListOf()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }

        return newList;
    }
}
