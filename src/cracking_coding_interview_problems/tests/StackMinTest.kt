val stackMinTest = { solution: Solution ->

    val stackMin = solution as StackMin

    stackMin.push(5)

    var min = stackMin.min()

    assertTrue(min == 5)

    stackMin.push(6)

    min = stackMin.min()

    assertTrue(min == 5)

    stackMin.push(7)

    min = stackMin.min()

    assertTrue(min == 5)

    stackMin.push(3)

    min = stackMin.min()

    assertTrue(min == 3)

    stackMin.pop()

    min = stackMin.min()

    assertTrue(min == 5)

    stackMin.pop()

    min = stackMin.min()

    assertTrue(min == 5)
}