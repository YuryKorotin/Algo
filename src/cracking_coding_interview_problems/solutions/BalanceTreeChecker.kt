//Balanced tree is defined to be a tree such that heights of the two subtrees
// of any node never differ for more than one
class BalanceTreeChecker: Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        val heightDifference = getHeight(root!!.left) - getHeight(root!!.right)

        if (kotlin.math.abs(heightDifference) > 1) {
            return false
        } else {
            return isBalanced(root!!.left) && isBalanced(root!!.right)
        }
    }

    fun getHeight(node: TreeNode?): Int {
        if (node == null) {
            return  -1
        }

        val height = kotlin.math.max(getHeight(node!!.left), getHeight(node!!.right)) + 1
        return height
    }

    fun optimalGetHeight(node: TreeNode?) : Int {
        if (node == null) {
            return -1
        }

        val leftHeight = optimalGetHeight(node!!.left)

        if (leftHeight == Int.MIN_VALUE) {
            return Int.MIN_VALUE
        }

        val rightHeight = optimalGetHeight(node!!.right)

        if (rightHeight == Int.MIN_VALUE) {
            return Int.MIN_VALUE
        }

        val heightDifference = leftHeight - rightHeight

        if (kotlin.math.abs(heightDifference) > 1) {
            return Int.MIN_VALUE
        } else {
            return kotlin.math.max(leftHeight, rightHeight) + 1
        }
    }

    fun isBalancedOptimal(root: TreeNode?): Boolean {
        return optimalGetHeight(root) != Int.MIN_VALUE
    }
}