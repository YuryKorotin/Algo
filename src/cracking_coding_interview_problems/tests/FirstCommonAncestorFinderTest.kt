val firstCommonAncestorFinderTest = { solution: Solution ->

    var leftChild = TreeNode(2, null, null)

    var rightChild = TreeNode(5, null, null)

    val ancestor = TreeNode(3, leftChild, rightChild)

    leftChild.parent = ancestor

    rightChild.parent = ancestor

    val firstCommonAncestorFinder = solution as FirstCommonAncestorFinder

    firstCommonAncestorFinder.root = ancestor
    
    val result = firstCommonAncestorFinder.find(leftChild, rightChild)

    assertTrue(ancestor == result)
}