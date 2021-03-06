val multiStackTest = { solution: Solution ->
    val multiStack = solution as MultiStack

    multiStack.push(0, 1)

    assertTrue(!multiStack.isEmpty())

    multiStack.pop(0)

    assertTrue(multiStack.isEmpty())
}