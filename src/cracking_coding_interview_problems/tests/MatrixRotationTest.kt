val matrixRotationTest = { solution: Solution ->
    val size = 10
    val testArray = Array(size, {
        Array(size, {
            size - it
        })
    })

    val rotation = solution as MatrixRotation

    val result = rotation.apply(testArray)

    for(i in 0 until testArray.size) {
        println(testArray[i].joinToString(" "))
    }

    for(i in 0 until result.size) {
        println(result[i].joinToString(" "))
    }

    assertTrue(testArray[1][4] == result[4][1])
}