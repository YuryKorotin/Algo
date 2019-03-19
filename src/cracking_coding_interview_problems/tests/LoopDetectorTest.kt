//INCLUDE Solution.kt
//INCLUDE LoopDetector.kt


val loopDetectorTest = { solution: Solution ->

    val detector = solution as LoopDetector

    val sourceList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 11).reversed()

    var current: LinkedListNode? = LinkedListNode(null, sourceList[0])
    var newNode: LinkedListNode? = null

    var loopStart: LinkedListNode? = null
    val lastNode = current
    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!

        if (sourceList[i] == 4) {
            loopStart = current
        }
    }

    lastNode!!.next = loopStart

    assertTrue(detector.detect(current) == loopStart)
}