class BstValidator: Solution {
    var root: TreeNode? = null

    fun isTreeValid(): Boolean {
        return checkBst(root, null, null)
    }

    fun checkBst(node: TreeNode?, min: Int?, max: Int?): Boolean {
        if (node == null) {
            return true
        }

        if ((min != null && node!!.data <= min) || (max != null && node!!.data > max)) {
            return false
        }

        if (!checkBst(node!!.left, min, node!!.data) || !checkBst(node!!.right, node!!.data, max)) {
            return false
        }

        return true
    }
}