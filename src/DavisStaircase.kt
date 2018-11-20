package solution

open class DavisStaircase {

    fun stepPerms(n: Int): Int {
        if (n < 3) {
            return n
        }

        if (n == 3) {
            return 4
        }

        return stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3)
    }

    open fun calculate(input : List<String>) : List<String> {
        var result = mutableListOf<String>()

        val queue = QueueOnList<Int>()

        input.forEach { item ->
            result.add(stepPerms(item.toInt()).toString())
        }

        return result
    }
}