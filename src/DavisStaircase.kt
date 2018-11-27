package solution

import javax.swing.UIManager.put
import java.util.HashMap

open class DavisStaircase {

    fun stepPerms(n: Int, cache: HashMap<Int, Int>): Int {
        if (n < 0) {
            return 0
        }

        if (n == 0) {
            return 1
        }

        if (n < 3) {
            return n
        }

        if (n == 3) {
            return 4
        }

        if (!cache.containsKey(n)) {
            val count = stepPerms(n - 1, cache) +
                    stepPerms(n - 2, cache) +
                    stepPerms(n - 3, cache)

            cache.put(n, count)
        }

        return cache.get(n)!!
    }

    open fun calculate(input : List<String>) : List<String> {
        var result = mutableListOf<String>()

        val queue = QueueOnList<Int>()


        val cache = HashMap<Int, Int>()

        input.forEach { item ->
            result.add(stepPerms(item.toInt(), cache).toString())
        }

        return result
    }
}