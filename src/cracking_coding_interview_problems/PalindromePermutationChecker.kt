

class PalindromePermutationChecker {
    fun isPermutationOfPalindrome(source: String) : Boolean {
        if (source.isBlank()) {
            return true
        }

        var preparedString = source.toLowerCase()

        val regex = Regex("[^A-Za-z0-9 ]")
        preparedString = regex.replace(preparedString, "")


        val symbolsCount = Array(26, {0})

        preparedString.forEach { symbol ->
            symbolsCount[symbol.toInt()] += 1
        }

        var centerSymbolWasFound = false

        symbolsCount.forEach { count ->
            if (centerSymbolWasFound && count != 0 && count != 2) {
                return false
            }

            if (count == 1) {
                centerSymbolWasFound = true
            }
        }

        return true
    }
}