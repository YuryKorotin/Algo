
val partitionOfListTest = { solution: Solution ->

    val partitioner = solution as PartitionOfList

    val sourceList = listOf(3, 5, 8, 5, 10, 2, 1).reversed()

    var current: LinkedListNode? = LinkedListNode(null, sourceList[0])
    var newNode: LinkedListNode? = null

    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    val target = 5

    var node = partitioner.execute(current, target)

    var index = 0
    val lessIndeces = mutableListOf<Int>()
    val greaterIndeces = mutableListOf<Int>()
    while (node != null) {

        if (node!!.data < target) {
            lessIndeces.add(index)
        }

        if (node!!.data > target) {
            greaterIndeces.add(index)
        }

        node = node!!.next

        index++
    }

    assertTrue(lessIndeces.sorted().last() < greaterIndeces.sorted().first())
}