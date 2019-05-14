class ListOfDepths(): Solution {
   var root: TreeNode? = null
   var listOfLevels: MutableList<List<TreeNode>> = mutableListOf<List<TreeNode>>()
   fun getSize(): Int {
     return listOfLevels.size
   }
   fun fill() {

   }
}
