class FirstCommonAncestorFinder: Solution {
    var root: TreeNode? = null

    fun find(firstNode: TreeNode?, secondNode: TreeNode?): TreeNode? {
        var delta = depth(firstNode) - depth(secondNode)

        var first: TreeNode? = null
        if (delta > 0) {
            first = secondNode
        } else {
            first = firstNode
        }

        var second: TreeNode? = null

        if (delta > 0) {
            second = firstNode
        } else {
            second = secondNode
        }

        while (first != second && first != null && second != null) {
            first = first!!.parent
            second = second!!.parent
        }

        if (first == null || second == null) {
            return null
        } else {
            return first
        }
    }

    fun getUpBy(node: TreeNode?, delta: Int): TreeNode? {
        var currentDelta = delta
        var currentNode = node
        while(currentDelta > 0 && currentNode != null) {
            currentNode = currentNode!!.parent
            currentDelta--
        }

        return currentNode
    }

    fun depth(node: TreeNode?): Int {
        var currentDepth = 0
        var currentNode = node


        while(currentNode != null) {
            currentNode  = currentNode!!.parent

            currentDepth--
        }
        return currentDepth
    }
}