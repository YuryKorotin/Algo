val sumListTest = { solution: Solution ->

    val sumMaker = solution as SumList

    val firstNumberList = listOf(7, 1, 6).reversed()
    val secondNumberList = listOf(5, 9, 2).reversed()
    val resultList = listOf(2, 1, 9)


    var current: LinkedListNode? = LinkedListNode(null, firstNumberList[0])
    var newNode: LinkedListNode? = null

    for (i in 1 until firstNumberList.size) {
        newNode = LinkedListNode(current, firstNumberList[i])
        current = newNode!!
    }

    val firstNumber = current

    current = LinkedListNode(null, secondNumberList[0])
    newNode = null

    for (i in 1 until secondNumberList.size) {
        newNode = LinkedListNode(current, secondNumberList[i])
        current = newNode!!
    }

    val secondNumber = current

    var node = sumMaker.execute(firstNumber, secondNumber)
    var index = 0

    while (node != null) {
        assertTrue(resultList[index] == node!!.data)

        node = node!!.next

        index++
    }
    //TODO: Write reversed solution
}