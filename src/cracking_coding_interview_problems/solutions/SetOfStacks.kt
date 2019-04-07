class SetOfStacks(var capacity: Int): Solution {
    var stacks: MutableList<CustomStack> = mutableListOf<CustomStack>()

    fun getLastStack(): CustomStack? {
        if (stacks.size == 0) {
            return null
        }
        return stacks.get(stacks.size - 1)
    }
    fun push(value: Int) {
        var last: CustomStack? = getLastStack()

        if (last != null && !last.isFull()) {
            last.push(value)
        } else {
            val newStack = CustomStack(capacity)
            newStack.push(value)
            stacks.add(newStack)
        }
    }
    fun pop(): Int {
        var last = getLastStack()
        if (last == null) {
            return 0
        }

        var resultValue = last.pop()
        if (last.size == 0) {
            stacks.removeAt(stacks.size - 1)
        }

        return resultValue
    }
    fun isEmpty(): Boolean {
        var last = getLastStack()

        return last == null || last.isEmpty()
    }

    fun popAt(index: Int): Int {
        return leftShift(index, true)
    }

    fun leftShift(index: Int, removeTop: Boolean): Int {
        var stack = stacks.get(index)
        var removedItem : Int = 0

        if (removeTop) {
            removedItem = stack.pop()
        } else {
            removedItem = stack.removeBottom()
        }

        if (stack.isEmpty()) {
            stacks.removeAt(index)
        } else if (stacks.size > index + 1) {
            val value = leftShift(index + 1, false)
            stack.push(value)
        }
        return removedItem
    }
 }

class CustomStack(var capacity: Int) {
    var top: CustomStackNode? = null
    var bottom: CustomStackNode? = null
    var size: Int = 0

    fun isFull(): Boolean {
        return capacity == size
    }

    fun join(above: CustomStackNode?, below: CustomStackNode?) {
        if (below != null) {
            below!!.above = above
        }

        if (above != null) {
            above!!.below = below
        }
    }

    fun push(value: Int): Boolean {
        if (size >= capacity) {
            return false
        }
        size++
        val node = CustomStackNode(value)
        if (size == 1) {
            bottom = node
        }

        join(node, top)

        top = node

        return true
    }

    fun pop(): Int {
        var savedTop = top
        top = top!!.below
        size--
        return savedTop!!.value
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun removeBottom(): Int {
        var bottom = bottom!!.above
        if (bottom != null) {
            bottom!!.below = null
        }
        size--
        return bottom!!.value
    }
}

class CustomStackNode(var value: Int) {
    var below: CustomStackNode? = null
    var above: CustomStackNode? = null
}