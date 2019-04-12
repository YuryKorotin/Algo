//INCLUDE solutions/Solution.kt
//INCLUDE solutions/Stack.kt


class StackMin: Solution, Stack<NodeWithMin>() {
    fun push(element: Int) {
        var newMin = kotlin.math.min(element, min())
        super.push(NodeWithMin(element, newMin))
    }

    fun min(): Int {
        if (isEmpty()) {
            return Int.MAX_VALUE
        } else {
            return peek()!!.min
        }
    }
}