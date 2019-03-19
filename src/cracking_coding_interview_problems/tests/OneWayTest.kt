val oneWayTest = { solution: Solution ->
    val oneWay = solution as OneWay

    assertTrue(oneWay.wasOperationApplied("pale", "ple"))
    assertTrue(oneWay.wasOperationApplied("pales", "pale"))
    assertTrue(oneWay.wasOperationApplied("pale", "bale"))
    assertTrue(!oneWay.wasOperationApplied("pale", "bae"))
}