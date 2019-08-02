val binarySearchTreeSequenceTracerTest = { solution: Solution ->
	val testResult = mutableListOf(mutableListOf(2, 1, 3), mutableListOf(2, 3, 1))

	val tracer = solution as BinarySearchTreeSequenceTracer

	var leftChild = TreeNode(1, null, null)

    var rightChild = TreeNode(3, null, null)

    val root = TreeNode(2, leftChild, rightChild)

    leftChild.parent = root

    rightChild.parent = root

	val result = tracer.traceTree(root)

	assertTrue(testResult == result)
}