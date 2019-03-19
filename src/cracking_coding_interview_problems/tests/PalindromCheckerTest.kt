
val palindromeCheckerTest = { solution: Solution ->

    val checker = solution as PalindromeChecker

    val sourceList = listOf(0, 1, 2, 1, 0).reversed()

    var current: LinkedListNode? = LinkedListNode(null, sourceList[0])
    var newNode: LinkedListNode? = null

    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    assertTrue(checker.isPalindromeRecursive(current))
}