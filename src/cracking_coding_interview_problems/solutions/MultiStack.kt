//INCLUDE solutions/Solution.kt

class MultiStack(val numberOfStacks: Int, val defaultSize: Int) : Solution {
    lateinit var values: Array<Int>
    lateinit var info: Array<StackInfo>

    init {
        info = Array(numberOfStacks, { i ->  StackInfo(defaultSize * i, defaultSize)})
        values = Array(numberOfStacks * defaultSize, {0})
    }

    inner class StackInfo(var start: Int,
                          var capacity: Int,
                          var size: Int = 0) {
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

        var stack = info[stackNumber]
        if (stack.isFull()) {
            expand(stackNumber)
        }

        stack.size++
        values[stack.lastElementIndex()] = element
    }

    fun pop(stackNumber: Int): Int {
        val stack = info[stackNumber]
        if (stack.isEmpty()) {
            return 0
        }

        val value = values[stack.lastElementIndex()]
        values[stack.lastElementIndex()] = 0
        stack.size--
        return value
    }

    fun peek(stackNumber: Int): Int {
        val stack = info[stackNumber]
        return values[stack.lastElementIndex()]
    }

    fun shift(stackNumber: Int) {
        val stack = info[stackNumber]
        if (stack.size > stack.capacity) {
            val nexStack = (stackNumber + 1) % info.size
            shift(nexStack)
            stack.capacity++
        }

        var index = stack.lastCapacityIndex()
        while (stack.isWithinStackCapacity(index)) {
            values[index] = values[prevIndex(index)]
            index = prevIndex(index)
        }

        values[stack.start] = 0
        stack.start = nextIndex(stack.start)
        stack.capacity--
    }

    fun expand(stackNumber: Int) {
        shift((stackNumber + 1) % info.size)
        info[stackNumber].capacity++
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
        return numberOfElements() == 0
    }
}