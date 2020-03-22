package Solution

data class TreeNode(var data: Int = 0,
                    var left: TreeNode? = null,
                    var right: TreeNode? = null,
                    var parent: TreeNode? = null)

class XorTrie {
	val root: TreeNode? = TreeNode()
	val baseNumberForPow: Double = 2.0
	val pows: Array<Int> = Array(32) {0}

	init {
		for (i in 0 until 32) {
			pows[i] = Math.pow(baseNumberForPow, i.toDouble()).toInt()
		}
	}

	fun insert(item: Int) {
		var current = root

		for(i in 31 downTo 0) {
			val bit = item.shr(i) and 1
			if (bit == 0) {
				if (current!!.left == null) {
					current!!.left = TreeNode()
				}
				current = current!!.left
			} else {
				if (current!!.right == null) {
					current!!.right = TreeNode()
				}

				current = current!!.right
			}
		}
	}

	fun getMaxXor(item: Int, items: Array<Int>): Int {
		var maxXor = 0

		var currentNode: TreeNode? = root
		var currentXor = 0

		for(i in 31 downTo 0) {
			var bit = item.shr(i) and 1

			if (bit == 0) {
				if (currentNode!!.right != null) {
					currentXor += pows[i]

					currentNode = currentNode.right
				} else {
					currentNode = currentNode.left
				}
			} else {
				if (currentNode!!.left != null) {
					currentXor += pows[i]
					currentNode = currentNode.left
				} else {
					currentNode = currentNode.right
				}
			}
		}

		if (currentXor > maxXor) {
			maxXor = currentXor
		}

		return maxXor
	}
}