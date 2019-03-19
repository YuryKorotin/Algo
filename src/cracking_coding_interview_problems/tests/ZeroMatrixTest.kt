val zeroMatrixTest = { solution: Solution ->
    val size = 10
    val testArray = Array(size, {
        Array(size, {
            size - it - 1
        })
    })

    val zeroAction = solution as ZeroMatrix

    val result = zeroAction.execute(testArray)

    for(i in 0 until testArray.size) {
        println(testArray[i].joinToString(" "))
    }

    for(i in 0 until result.size) {
        println(result[i].joinToString(" "))
    }

    assertTrue(result[9][4] == 0)
}