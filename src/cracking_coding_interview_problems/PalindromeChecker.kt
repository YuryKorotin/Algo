//INCLUDE Solution.kt
//INCLUDE LinkedListNode.kt

class PalindromeChecker : Solution {
    fun isPalindrome(head: LinkedListNode?): Boolean {
        var fast = head
        var slow = head

        var stack = StackWithList()

        while(fast != null && fast!!.next != null) {
            stack.push(slow!!.data)

            val data = slow!!.data

            slow = slow!!.next

            fast = fast!!.next!!.next
        }

        if (fast != null) {
            slow = slow!!.next
        }

        while (slow != null) {
            val top = stack.pop()

            if (top != slow!!.data) {
                return false
            }
            slow = slow!!.next
        }
        return true
    }

    fun isPalindromeRecurse(head: LinkedListNode?, length: Int): Result {
	if (head == null || length <= 0) {
            return Result(head, true)
	} else if (length == 1) {
            return Result(head!!.next, true)
	}
	
	val res = isPalindromeRecurse(head!!.next, length - 2)

        if (!res.result || res.node == null) {
           return res
	}

	res.result = head!!.data == res.node!!.data
        
        res.node = res.node!!.next

	return res
    }

    fun isPalindromeRecursive(head: LinkedListNode?): Boolean {
	val length = lengthOfList(head)

	val result = isPalindromeRecurse(head, length)
	
	return result.result
    }

    fun lengthOfList(node: LinkedListNode?): Int {
	var size = 0

	var current = node
	while (current != null) {
	    size++
	    current = current!!.next
	}
	return size
    }
}

data class Result(var node: LinkedListNode?, var result: Boolean)

class StackWithList{
    val elements: MutableList<Any> = mutableListOf()

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    fun push(item: Any) = elements.add(item)

    fun pop() : Any? {
        val item = elements.lastOrNull()
        if (!isEmpty()){
            elements.removeAt(elements.size -1)
        }
        return item
    }
    fun peek() : Any? = elements.lastOrNull()

    override fun toString(): String = elements.toString()
}
