package solution

class QueueOnList<T> {
    val elements: MutableList<T> = mutableListOf()
    open fun isEmpty() = elements.isEmpty()
    open fun count() = elements.size
    open fun enqueue(item: T) = elements.add(item)
    open fun dequeue() = if (!isEmpty()) elements.removeAt(0) else null
    open fun peek() = if (!isEmpty()) elements[0] else null
}