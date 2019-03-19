//INCLUDE solutions/Solution.kt
//INCLUDE solutions/LinkedListNode.kt

class IntersectionValidator : Solution {
    var k = 0
    fun getIntersection(firstHead: LinkedListNode?, secondHead: LinkedListNode?): LinkedListNode? {
        var resultNode: LinkedListNode? = null

        if (firstHead == null || secondHead == null) {
            return null
        }

        var firstResult: SearchResult? = getTailAndSize(firstHead)
        var secondResult: SearchResult? = getTailAndSize(secondHead)


        if (firstResult!!.tail != secondResult!!.tail) {
            return null
        }

        var shorter: LinkedListNode? = null
        if (firstResult!!.size < secondResult!!.size) {
            shorter = firstHead
        } else {
            shorter = secondHead
        }

        var longer: LinkedListNode? = null
        if (firstResult!!.size < secondResult!!.size) {
            longer = secondHead
        } else {
            longer = firstHead
        }

        k = java.lang.Math.abs(firstResult!!.size - secondResult!!.size)

        longer = getNodeAtKPosition(longer)

        while(shorter != longer) {
            shorter = shorter!!.next
            longer = longer!!.next
        }

        return longer
    }

    fun getNodeAtKPosition(head: LinkedListNode?): LinkedListNode? {
        var current = head

        while (k > 0 && current != null) {
            current = current!!.next
            k--
        }

        return current
    }

    fun getTailAndSize(head: LinkedListNode?): SearchResult? {
        if (head == null) {
            return null
        }

        var size = 1
        var current = head

        while(current != null) {
            size++
            current = current!!.next
        }

        return SearchResult(current, size)
    }
}

data class SearchResult(var tail: LinkedListNode?, var size: Int)