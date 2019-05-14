class ListOfDepths(): Solution {
   var root: TreeNode? = null
   var listOfLevels: MutableList<MutableList<TreeNode>> = mutableListOf<MutableList<TreeNode>>()
   fun getSize(): Int {
     return listOfLevels.size
   }

   fun fillLevels(node: TreeNode?, level: Int) {
      if (node == null) {
         return
      }

      var levelList: MutableList<TreeNode> = mutableListOf()

      if (listOfLevels.size == level) {
         listOfLevels.add(levelList)
      } else {
         levelList = listOfLevels[level]
      }

      levelList.add(node)
      if (node!!.left != null) {
         fillLevels(node!!.left, level + 1)
      }

      if (node!!.right != null) {
         fillLevels(node!!.right, level + 1)
      }
   }

   fun fill() {
      if (root == null) {
         return
      }

      fillLevels(root, 0)
   }
}
