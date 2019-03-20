//INCLUDE solutions/Solution.kt

class MultiStack(val numberOfStacks: Int, val defaultSize: Int) : Solution {
    lateinit var values: Array<Int>
    lateinit var info: Array<StackInfo>

    init {
        info = Array(numberOfStacks, { i ->  StackInfo(defaultSize * i, defaultSize)})
        values = Array(numberOfStacks * defaultSize, {0})
    }

    inner class StackInfo(var start: Int,
                          var size: Int,
                          var capacity: Int = 0,
                          val values: Array<Int> = Array(1, {0})) {
        fun isWithinStackCapacity(index: Int): Boolean {
            if (index < 0 || index >= values.size) {
                return false
            }

            var contigousIndex = 0
            if (index < start) {
                contigousIndex = index + values.size
            } else {
                contigousIndex = index
            }

            var end = start + capacity
            return start <= contigousIndex && contigousIndex < end
        }

        fun lastCapacityIndex(): Int {
            return adjustIndex(start + capacity - 1)
        }

        fun lastElementIndex(): Int {
            return adjustIndex(start + size - 1)
        }

        fun isFull(): Boolean {
            return size == capacity
        }

        fun isEmpty(): Boolean {
            return  size == 0
        }
    }

    fun adjustIndex(index: Int): Int {
        var max = values.size

        return ((index % max) + max) % max
    }

    fun nextIndex(index: Int): Int {
        return adjustIndex(index + 1)
    }

    fun prevIndex(index: Int): Int {
        return adjustIndex(index - 1)
    }

    fun push(stackNumber: Int, element: Int) {
        if (allStacksAreFull()) {
            return
        }
    }

    fun numberOfElements(): Int {
        var size = 0
        info.forEach{ infoItem -> size += infoItem.size }
        return size
    }

    fun allStacksAreFull(): Boolean {
        return numberOfElements() == values.size
    }

    fun isEmpty(): Boolean {
        return true
    }
}