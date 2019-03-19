val removeDupsTest = { solution: Solution ->

    val remover = solution as RemoveDups

    val sourceList = listOf(3, 1, 3, 3, 4)
    val resultList = listOf(4, 3, 1)

    var current: LinkedListNode? = LinkedListNode(null, 3)
    var newNode: LinkedListNode? = null
    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    remover.executeWithoutBuffer(current)

    var i = 0
    var node = current
    while(node != null) {
        assertTrue(node!!.data == resultList[i])

        node = node!!.next
        i++
    }

    assertTrue(i == resultList.size)
}