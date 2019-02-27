//INCLUDE Solution.kt
//INCLUDE LinkedListNode.kt

class KthToLast : Solution {
    var countFromEnd = 0

    var k = 0

    fun find(node: LinkedListNode?, k: Int): LinkedListNode? {
        countFromEnd = 0

        this.k = k

        return findNode(node)
    }

    fun findNode(node: LinkedListNode?): LinkedListNode? {
        if (node == null) {
            return node
        }

        var current = findNode(node.next)

        countFromEnd++
        
        if (k == countFromEnd) {
            return node
        }

        return current
    }
}