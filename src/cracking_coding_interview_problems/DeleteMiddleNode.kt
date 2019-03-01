//INCLUDE Solution.kt
//INCLUDE LinkedListNode.kt

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

        if (k == sizeCounter / 2 + 1) {
            node!!.next = node!!.next!!.next
        }

        k++

        return node
    }
}