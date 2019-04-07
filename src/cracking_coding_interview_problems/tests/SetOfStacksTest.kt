val setOfStacksTest = { solution: Solution ->
    val setOfStacks = solution as SetOfStacks

    assertTrue(setOfStacks.isEmpty())

    setOfStacks.push(4)

    setOfStacks.push(5)

    setOfStacks.push(6)

    assertTrue(!setOfStacks.isEmpty())

    assertTrue(setOfStacks.pop() == 6)

    assertTrue(setOfStacks.pop() == 5)

    assertTrue(setOfStacks.pop() == 4)

    assertTrue(setOfStacks.pop() == 0)
}