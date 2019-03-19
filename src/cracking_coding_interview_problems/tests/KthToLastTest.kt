val kThToLastTest = { solution: Solution ->

    val finder = solution as KthToLast

    val sourceList = listOf(5, 4, 3, 2, 1)
    val resultList = listOf(4, 3, 1)

    var current: LinkedListNode? = LinkedListNode(null, 3)
    var newNode: LinkedListNode? = null
    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    val k = 3
    val node = finder.find(current, k)

    assertTrue(node!!.data == 3)
}