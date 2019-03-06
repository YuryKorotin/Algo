//INCLUDE Solution.kt
//INCLUDE LinkedListNode.kt

class PalindromeChecker : Solution {
    fun isPalindrome(head: LinkedListNode?): Boolean {
        var fast = head
        var slow = head

        var stack = StackWithList()

        while(fast != null && fast!!.next != null) {
            stack.push(slow.data)
        }
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