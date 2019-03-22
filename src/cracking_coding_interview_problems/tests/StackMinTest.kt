val stackMinTest = { solution: Solution ->

    val stackMin = solution as StackMin

    stackMin.push(5)

    val min = stackMin.min()

    assertTrue(min == 5)
}