//INCLUDE solutions/Solution.kt

class OneWay: Solution {
    fun wasOperationApplied(source: String, result: String) : Boolean {
        if (source.length == result.length) {
            return wasCharacterReplaced(source, result)
        } else if (source.length + 1 == result.length) {
            return wasCharacterInserted(source, result)
        } else if (source.length - 1 == result.length) {
            return wasCharacterInserted(result, source)
        }
        return false
    }
    fun wasCharacterReplaced(source: String, result: String) : Boolean {
        var wasFoundDifference = false
        source.forEachIndexed { index, symbol ->
            if (source[index] != result[index]) {
                if (wasFoundDifference) {
                    return false
                }
                wasFoundDifference = true
            }
        }
        return true
    }

    fun wasCharacterInserted(source: String, result: String) : Boolean {
        var i = 0
        var j = 0

        while (j < result.length && i < source.length) {
            if (source[i] != result[j]) {
                if (i != j) {
                    return false
                }
                j++
            } else {
                i++
                j++
            }
        }
        return true
    }
}