//DEPS junit:junit:4.12
import org.junit.Assert.*


//INCLUDE PalindromePermutationChecker.kt
//INCLUDE Oneway.kt
//INCLUDE Solution.kt

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

var checker = PalindromePermutationChecker()
val oneWay = OneWay()

Launcher.testProblemSolution("Palindrom permutation", palindromeTest, checker)
Launcher.testProblemSolution("One way", oneWayTest, oneWay)