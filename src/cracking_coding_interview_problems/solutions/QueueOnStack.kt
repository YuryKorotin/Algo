//INCLUDE solutions/Stack.kt


class QueueOnStack: Solution {
    var stackNewest: Stack<Int> = Stack<Int>()
    var stackOldest: Stack<Int> = Stack<Int>()

    fun size(): Int {
        return stackNewest.count() + stackOldest.count()
    }

    fun isEmpty(): Boolean {
        return size() == 0
    }

    fun add(value: Int) {
        stackNewest.push(value)
    }

    fun shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop() ?: 0)
            }
        }
    }

    fun peek(): Int {
        shiftStacks()
        return stackOldest.peek() ?: 0
    }

    fun remove(): Int {
        shiftStacks()
        return stackOldest.pop() ?: 0
    }
}