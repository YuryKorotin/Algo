//INCLUDE solutions/Solution.kt
//INCLUDE solutions/LinkedListNode.kt

class PartitionOfList : Solution {
    fun execute(node: LinkedListNode?, target: Int) : LinkedListNode? {
        var tail: LinkedListNode? = node
        var head: LinkedListNode? = node

        var current = node

        while(current != null) {
            val next = current!!.next
            if (current!!.data < target) {
                current!!.next = head
                head = current
            } else {
                tail!!.next = current
                tail = current
            }
            current = next
        }
        tail!!.next = null

        return head
    }
}