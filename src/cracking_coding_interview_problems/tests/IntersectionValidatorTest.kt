val interSectionValidatorTest = { solution: Solution ->

    val validator = solution as IntersectionValidator

    val sourceList = listOf(0, 1, 2, 1, 0).reversed()
    val secondInput = listOf(3, 3, 2, 4, 4).reversed()

    var current: LinkedListNode? = LinkedListNode(null, sourceList[0])
    var newNode: LinkedListNode? = null

    var nodeOfIntersection: LinkedListNode? = null

    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!

        if (i == 2) {
            nodeOfIntersection = current
        }
    }

    val firstHead = current

    current = LinkedListNode(null, secondInput[0])
    newNode = null

    for (i in 1 until secondInput.size) {
        newNode = LinkedListNode(current, secondInput[i])
        current = newNode!!

        if (i == 2) {
            current = nodeOfIntersection
        }
    }

    assertTrue(validator.getIntersection(firstHead, current) == nodeOfIntersection)
}