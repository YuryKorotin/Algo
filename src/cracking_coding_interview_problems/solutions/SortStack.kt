class SortStack: Solution {
    fun sort(stackToSort: Stack<Int>) {
        var temp = Stack<Int>()

        while(!stackToSort.isEmpty()) {
            var tmp = stackToSort.pop()!!
            while(!temp.isEmpty() && temp.peek()!! > tmp) {
                stackToSort.push(temp.pop()!!)
            }
            temp.push(tmp)
        }
        while(!temp.isEmpty()) {
            stackToSort.push(temp.pop()!!)
        }
    }
}