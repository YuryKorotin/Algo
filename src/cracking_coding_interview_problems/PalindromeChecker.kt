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

            println(top)

            println(slow!!.data)

            if (top != slow!!.data) {
                return false
            }
            slow = slow!!.next
        }
        return true
    }
}

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