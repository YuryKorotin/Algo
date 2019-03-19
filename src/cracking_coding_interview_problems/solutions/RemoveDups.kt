//INCLUDE solutions/Solution.kt
//INCLUDE solutions/LinkedListNode.kt

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

    fun executeWithoutBuffer(node: LinkedListNode?) {
        var current = node
        while (current != null) {
            var changer = current
            while (changer!!.next != null) {
                if (changer!!.next!!.data == current!!.data) {
                    changer!!.next = changer!!.next!!.next
                } else {
                    changer = changer.next
                }
            }
            current = current!!.next
        }
    }

}