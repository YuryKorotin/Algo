//INCLUDE Solution.kt

class StringRotation: Solution {
    fun isSubtring(firstSource: String, secondSource: String): Boolean {
        var hasCommonSequence = false

        var firstDoubled = firstSource + firstSource

        loop@for (i in 0 until firstDoubled.length) {
            for (j in 0 until secondSource.length) {
                if (firstDoubled[i] == secondSource[j]) {
                    hasCommonSequence = true
                }

                if (firstSource[i] != secondSource[j] && hasCommonSequence) {
                    hasCommonSequence
                    break@loop
                }
            }
        }

        return hasCommonSequence
    }
}