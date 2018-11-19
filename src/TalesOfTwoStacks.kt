package solution

//INCLUDE QueueOnList.kt

open class TalesOfTwoStacks {
    open fun changeQueue(input : List<String>) : List<String> {
        var result = mutableListOf<String>()

        val queue = QueueOnList<Int>()

        input.forEach { item ->
            if (item.length == 1) {
                val command = item.toInt();

                if (command == 3) {
                    result.add(queue.peek().toString())
                }

                if (command == 2) {
                    queue.dequeue()
                }
            } else {
                val commandWithParam = item.split(" ")

                queue.enqueue(commandWithParam[commandWithParam.size - 1].toInt())
            }
        }


        return result
    }
}