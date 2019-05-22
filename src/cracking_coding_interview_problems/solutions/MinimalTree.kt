class MinimalTree: Solution {
    fun createTree(list: List<Int>): TreeNode? {
        return createMinimalTree(list, 0, list.size - 1)
    }

    fun createMinimalTree(list: List<Int>, start: Int, end: Int): TreeNode? {
        if (end < start) {
            return null
        }
        val middle = (start + end) / 2

        val node: TreeNode? = TreeNode(data = list[middle])

        node!!.left = createMinimalTree(list, start, middle - 1)
        node!!.right = createMinimalTree(list, middle + 1, end)

        return node
    }
}

data class TreeNode(var data: Int = 0,
                    var left: TreeNode? = null,
                    var right: TreeNode? = null,
                    var parent: TreeNode? = null)