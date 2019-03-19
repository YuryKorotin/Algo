val stringCompressionTest = { solution: Solution ->
    val compression = solution as StringCompression

    assertTrue(compression.compress("pale").equals("pale"))
    assertTrue(compression.compress("aabcccccaaa").equals("a2b1c5a3"))
}