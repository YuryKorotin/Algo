//INCLUDE Solution.kt
//INCLUDE LinkedListNode.kt

class SumList : Solution {

    var carry = 0
    fun execute(firstNumber: LinkedListNode?,
                secondNumber: LinkedListNode?) : LinkedListNode? {
        var newNode = sumDigits(firstNumber, secondNumber)

        val head = newNode

        var currentFirst = firstNumber!!.next

        var currentSecond = secondNumber!!.next

        while(currentFirst != null && currentSecond != null) {
            newNode!!.next = sumDigits(currentFirst, currentSecond)

            newNode = newNode!!.next

            currentFirst = currentFirst!!.next

            currentSecond = currentSecond!!.next
        }

        return head
    }

    fun sumDigits(firstDigit: LinkedListNode?,
                  secondDigit: LinkedListNode?) : LinkedListNode? {
        
        val sum = firstDigit!!.data + secondDigit!!.data + carry

        val resultNode = LinkedListNode(null, sum % 10)

        carry = sum / 10

        return resultNode
    }
}