val buildOrderResolverTest = { solution: Solution ->

    val buildOrderResolver = solution as BuildOrderResolver

    val projects = listOf("a", "b", "c", "d", "e", "f")

    val dependencies = listOf(
            listOf("a", "d"),
            listOf("f", "b"),
            listOf("b", "d"),
            listOf("f", "a"),
            listOf("d", "c"))

    val order = buildOrderResolver.findBuildOrder(projects, dependencies)

    assertTrue("f" == order.peek()!!.name)
}