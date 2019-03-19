val stringRotationTest = { solution: Solution ->

    val rotation = solution as StringRotation

    var firstInput = "waterbottle"

    var secondInput = "erbottlewat"

    val result = rotation.isSubtring(firstInput, secondInput)

    assertTrue(result)
}