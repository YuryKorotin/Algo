//INCLUDE Solution.kt
//INCLUDE LinkedListNode.kt

class LoopDetector: Solution {
    fun detect(head: LinkedListNode?): LinkedListNode? {
        var slow: LinkedListNode? = head
        var fast: LinkedListNode? = head 

	while(fast != null && fast!!.next != null) {
	    slow = slow!!.next
	    fast = fast!!.next!!.next
	    if (slow!! === fast!!) {
		break	
	    }
	}

        if (fast == null || fast!!.next == null) {
            return null
        }
        
	slow = head
        while (slow != fast) {
	    slow = slow!!.next
	    fast = fast!!.next
	}
	return fast
    }
}

