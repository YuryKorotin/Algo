val deleteMiddleNodeTest = { solution: Solution ->

    val remover = solution as DeleteMiddleNode

    val sourceList = listOf(7, 12, 1, 2, 3, 4)
    val resultList = listOf(4, 3, 1, 12, 7)

    var current: LinkedListNode? = LinkedListNode(null, sourceList[0])
    var newNode: LinkedListNode? = null

    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    remover.execute(current)

    var node = current

    resultList.forEach {
        assertTrue(it == node!!.data)

        node = node!!.next
    }
}