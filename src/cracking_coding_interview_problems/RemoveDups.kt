//INCLUDE Solution.kt
//INCLUDE LinkedListNode.kt

class RemoveDups : Solution {
    fun execute(node: LinkedListNode?) {
        val counts = mutableSetOf<Int>()

        var current = node
        var previous: LinkedListNode? = null
        while (current != null) {
            if (counts.contains(current!!.data)) {
                previous!!.next = current!!.next
            } else {
                counts.add(current!!.data)
                previous = current
            }
            current = current!!.next
        }
    }
}