class BinarySearchTreeSequenceTracer: Solution {

	fun traceTree(node: TreeNode?): MutableList<MutableList<Int>> {
		var result: MutableList<MutableList<Int>> = mutableListOf<MutableList<Int>>()
		if (node == null) {
			result.add(mutableListOf<Int>())
			return result
		}
		
		val prefix = mutableListOf(node!!.data)
		val leftSeq = traceTree(node!!.left)
		val rightSeq = traceTree(node!!.right)

		for (i in 0 until leftSeq.size) {
			val left = leftSeq[i]
			for (j in 0 until rightSeq.size) {
				val right = rightSeq[j]
			
				val weaved = mutableListOf<MutableList<Int>>()
				weaveLists(left, right, weaved, prefix)
				result.addAll(weaved)
			}
		}

		return result
	}

	fun weaveLists(first: MutableList<Int>, second: MutableList<Int>, results: MutableList<MutableList<Int>>, prefix: MutableList<Int>) {
		if (first.size == 0 || second.size == 0) {
			val result = mutableListOf<Int>()
			result.addAll(prefix)
			result.addAll(first)
			result.addAll(second)
			results.add(result)
			return
		}
		val headFirst = first[0]
		first.removeAt(0)
		prefix.add(headFirst)
		weaveLists(first, second, results, prefix)
		prefix.removeAt(prefix.size - 1)
		first.add(0, headFirst)

		val headSecond = second[0]
		second.removeAt(0)
		prefix.add(headSecond)
		weaveLists(first, second, results, prefix)
		prefix.removeAt(prefix.size - 1)
		second.add(0, headSecond)
	}
}