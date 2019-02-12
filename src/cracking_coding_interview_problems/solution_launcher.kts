//DEPS junit:junit:4.12
import org.junit.Assert.*


//INCLUDE PalindromePermutationChecker.kt
//INCLUDE Oneway.kt
//INCLUDE StringCompression.kt
//INCLUDE Solution.kt
//INCLUDE MatrixRotation.kt

class Launcher {
    companion object {

        fun measureTime(fileName: String, problemName: String) {
            println("Start measuring time of problem solution $problemName ...")

            println("End mesuaring time of problem solution $problemName")
        }

        fun testProblemSolution(problemName: String,
                                test: (solution: Solution) -> Unit,
                                solution: Solution) {
            println("Start testing solution of problem $problemName...")

            test(solution)

            println("End testing solution of problem $problemName")
        }
    }
}

val palindromeTest = { solution: Solution ->
    val checker = solution as PalindromePermutationChecker
    assertTrue(checker.isPermutationOfPalindrome(""))
    assertTrue(checker.isPermutationOfPalindrome(" "))
    assertTrue(checker.isPermutationOfPalindrome("Bbb"))
    assertTrue(checker.isPermutationOfPalindrome("Tact Coa"))
}

val oneWayTest = { solution: Solution ->
    val oneWay = solution as OneWay

    assertTrue(oneWay.wasOperationApplied("pale", "ple"))
    assertTrue(oneWay.wasOperationApplied("pales", "pale"))
    assertTrue(oneWay.wasOperationApplied("pale", "bale"))
    assertTrue(!oneWay.wasOperationApplied("pale", "bae"))
}

val stringCompressionTest = { solution: Solution ->
    val compression = solution as StringCompression

    assertTrue(compression.compress("pale").equals("pale"))
    assertTrue(compression.compress("aabcccccaaa").equals("a2b1c5a3"))
}

val matrixRotationTest = { solution: Solution ->
    val size = 10
    val testArray = Array(size, {
        Array(size, {
            size - it
        })
    })

    val rotation = solution as MatrixRotation

    val result = rotation.apply(testArray)

    for(i in 0 until testArray.size) {
        println(testArray[i].joinToString(" "))
    }

    for(i in 0 until result.size) {
        println(result[i].joinToString(" "))
    }

    assertTrue(testArray[1][4] == result[4][1])
}

var checker = PalindromePermutationChecker()
val oneWay = OneWay()
val stringCompression = StringCompression()
val matrixRotation = MatrixRotation()


Launcher.testProblemSolution("Palindrom permutation", palindromeTest, checker)
Launcher.testProblemSolution("One way", oneWayTest, oneWay)
Launcher.testProblemSolution("String compression", stringCompressionTest, stringCompression)
Launcher.testProblemSolution("Matrix rotation", matrixRotationTest, matrixRotation)