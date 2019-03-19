//INCLUDE solutions/Solution.kt
//INCLUDE solutions/LinkedListNode.kt

class DeleteMiddleNode : Solution {
    var sizeCounter = 0
    var k = 0

    fun execute(head: LinkedListNode?) {
        exploreNode(head)
    }

    fun exploreNode(node: LinkedListNode?): LinkedListNode? {
        if (node == null) {
            return node
        }

        sizeCounter++

        exploreNode(node!!.next)

        if (sizeCounter % 2 == 1 && k == sizeCounter / 2 ||
                sizeCounter % 2 == 0 && k == sizeCounter / 2) {
            deleteNode(node)
        }

        k++

        return node
    }

    fun deleteNode(node: LinkedListNode?): Boolean {
        if (node == null || node.next == null) {
            return false
        }

        node!!.data = node!!.next!!.data
        node!!.next = node!!.next!!.next
        return true
    }
}