//INCLUDE solutions/Solution.kt

class PalindromePermutationChecker : Solution {
    //Strings with even length should have even counts, strings with odd characters should have
    //one character with odd count

    //TODO: Implement by storing counts in bits of number

    fun isPermutationOfPalindrome(source: String) : Boolean {
        if (source.isBlank()) {
            return true
        }

        var preparedString = source.toLowerCase()

        val regex = Regex("[^A-Za-z0-9 ]")
        preparedString = regex.replace(preparedString, "")
        preparedString = preparedString.replace(" ", "")

        val symbolsCount = Array(26, {0})

        preparedString.forEach { symbol ->
            symbolsCount[symbol.toInt() - 97] += 1
        }

        var centerSymbolWasFound = false

        symbolsCount.forEach { count ->
            if (centerSymbolWasFound && count % 2 != 0) {
                return false
            }

            if (count % 2 == 1) {
                centerSymbolWasFound = true
            }
        }

        return true
    }
}