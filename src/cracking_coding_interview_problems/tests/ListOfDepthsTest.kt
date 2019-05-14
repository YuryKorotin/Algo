val listOfDepthsTest = { solution: Solution ->

    var leftChild = TreeNode(2, null, null)

    var rightChild = TreeNode(5, null, null)
   
    val root = TreeNode(3, leftChild, rightChild)
    
    val listOfDepths = solution as ListOfDepths

    listOfDepths.root = root
    listOfDepths.fill()
   
    assertTrue(listOfDepths.getSize() == 2)
}

