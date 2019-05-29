val buildOrderResolverTest = { solution: Solution ->

    var leftChild = TreeNode(2, null, null)

    var rightChild = TreeNode(5, null, null)

    val root = TreeNode(3, leftChild, rightChild)

    leftChild.parent = root

    rightChild.parent = root

    val successorFinder = solution as SuccessorFinder

    val result = successorFinder.find(root)

    assertTrue(result!!.data == 5)
}