val listOfDepthsTest = { solution: Solution ->
   
    val root = TreeNode(3, null, null)
    
    val listOfDepths = solution as ListOfDepths

    listOfDepths.root = root
    listOfDepths.fill()
   
    assertTrue(listOfDepths.getSize() == 1)
}

