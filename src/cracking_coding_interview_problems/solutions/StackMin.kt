//INCLUDE solutions/Solution.kt

class StackMin: Solution, Stack<NodeWithMin> {
    fun push(element: Int) {
        var newMin = kotlin.math.min(element, min())
        super.push(NodeWithMin(element, newMin))
    }

    fun pop(): Int {
        return 0
    }

    fun min(): Int {
        return 0
    }
}

class Stack<T>{
    val elements: MutableList<T> = mutableListOf()
    fun isEmpty() = elements.isEmpty()
    fun count() = elements.size
    fun push(item: T) = elements.add(item)
    fun pop() : T? {
        val item = elements.lastOrNull()
        if (!isEmpty()){
            elements.removeAt(elements.size -1)
        }
        return item
    }
    fun peek() : T? = elements.lastOrNull()
    override fun toString(): String = elements.toString()
}

fun <T> Stack<T>.push(items: Collection<T>) = items.forEach { this.push(it) }

data class NodeWithMin(var value: Int, var min: Int)