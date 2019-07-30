class BinarySearchTreeSequenceTracer: Solution {

	fun traceTree(node: TreeNode?): MutableList<MutableList<Int>> {
		var result: MutableList<MutableList<Int> = mutableListOf()
		if (node == null) {
			result.add(mutableListOf<Int>())
			return result
		}
		
		val trace: String = mutableListOf(head!!.data)
		var currentNode: TreeNode? = node	

		trace.add(node.data.toString())
		var temp = 
		
		if(currentNode!!.left != null) {
			trace.add(traceTree(currentNode!!.left))
		}

		if(currentNode!!.right != null) {
			trace.add(traceTree(currentNode!!.right))
		}

		return trace
	}

	fun weaveList(first: MutableList<Int>, second: MutableList<Int>, results: MutableList<<>>) {

	}
}