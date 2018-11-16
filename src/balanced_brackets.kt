package solution

open class BalancedBracketsSolution() {
    fun isBalanced(s: String): String {
        var brackets = ""
        val leftBrackets = "{(["
        val pairs = hashMapOf('{' to '}', '[' to ']', '(' to ')')

        s.forEach { character ->
            if (!leftBrackets.contains(character) &&
                    brackets.isEmpty()) {
                return "NO"
            }

            if (leftBrackets.contains(character)) {
                brackets = brackets.plus(character)
            } else if (!brackets.isEmpty()) {
                var last = brackets.last()
                if (pairs.get(last) == character) {
                    brackets = brackets.dropLast(1)
                } else {
                    return "NO"
                }
            }
        }

        if (brackets.isEmpty()) {
            return "YES"
        }

        return "NO"
    }
}