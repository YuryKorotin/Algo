val queueOnStackTest = { solution: Solution ->
    val queueOnStack = solution as QueueOnStack

    assertTrue(queueOnStack.isEmpty())

    queueOnStack.add(4)

    queueOnStack.add(5)

    queueOnStack.add(6)

    assertTrue(!queueOnStack.isEmpty())

    assertTrue(queueOnStack.peek() == 4)

    assertTrue(queueOnStack.remove() == 4)

    assertTrue(queueOnStack.remove() == 5)

    assertTrue(queueOnStack.peek() == 6)

    //assertTrue(queueOnStack.peek() == 0)
}