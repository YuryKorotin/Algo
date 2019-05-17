val balanceTreeCheckerTest = { solution: Solution ->

    var leftChild = TreeNode(2, null, null)

    var rightChild = TreeNode(5, null, null)

    val root = TreeNode(3, leftChild, rightChild)

    val balancedTreeChecker = solution as BalanceTreeChecker

    balancedTreeChecker.isBalanced(root)

    assertTrue(balancedTreeChecker.isBalanced(root))
    assertTrue(balancedTreeChecker.isBalancedOptimal(root))
}