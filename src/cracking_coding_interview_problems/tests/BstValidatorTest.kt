val bstValidatorTest = { solution: Solution ->

    var leftChild = TreeNode(2, null, null)

    var rightChild = TreeNode(5, null, null)

    val root = TreeNode(3, leftChild, rightChild)

    val bstValidator = solution as BstValidator

    bstValidator.root = root
    bstValidator.isTreeValid()

    assertTrue(bstValidator.isTreeValid())
}
