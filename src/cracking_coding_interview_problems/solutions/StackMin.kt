//INCLUDE solutions/Solution.kt

class StackMin: Solution, Stack<NodeWithMin> {
    fun push(element: Int) {
        int newMin = kotlin.math.min(element, min())
    }

    fun pop(): Int {
        return 0
    }

    fun min(): Int {
        return 0
    }
}

data class NodeWithMin(var value: Int, var min: Int)