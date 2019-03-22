val stackMinTest = { solution: Solution ->

    val stackMin = solution as StackMin

    stackMin.push(5)

    var min = stackMin.min()

    assertTrue(min == 5)

    stackMin.push(6)

    min = stackMin.min()

    assertTrue(min == 5)

}