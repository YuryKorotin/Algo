val sortStackTest = { solution: Solution ->
    val sortStack = solution as SortStack

    var newStack = Stack<Int>()

    //assertTrue(newStack.isEmpty())

    newStack.push(5)

    newStack.push(10)

    newStack.push(7)

    assertTrue(!newStack.isEmpty())

    sortStack.sort(newStack)

    assertTrue(5 == newStack.pop())

    assertTrue(7 == newStack.pop())

    assertTrue(10 == newStack.pop())
}