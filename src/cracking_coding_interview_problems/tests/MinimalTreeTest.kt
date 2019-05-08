val minimalTreeTest = { solution: Solution ->
    val minimalTree = solution as MinimalTree

    val testList = listOf(4, 2, 4, 6, 7, 8)

    val root = minimalTree.createTree(testList)

    assertTrue(root != null)
    
    assertTrue(root!!.data == 4)
}