class SuccessorFinder: Solution {
	fun find(target: TreeNode?): TreeNode? {
		if (target == null) {
			return null
		}

		if (target!!.right != null) {
			return leftMostChild(target!!.right)
		} else {
			var q: TreeNode? = target
			var x: TreeNode? = q!!.parent

			while(x != null && x!!.left != q) {
				q = x
				x = x!!.parent
			} 
			return x
		}
	}

	fun leftMostChild(n: TreeNode?): TreeNode? {
		if (n == null) {
			return null
		}

		var current = n

		while (current!!.left != null) {
			current = current!!.left
		} 
		return current
	}
}