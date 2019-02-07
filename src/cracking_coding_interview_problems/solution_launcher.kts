//DEPS junit:junit:4.12
import org.junit.Assert.*


//INCLUDE PalindromePermutationChecker.kt
//INCLUDE Oneway.kt

class Launcher {
    companion object {

        fun measureTime(fileName: String, problemName: String) {
            println("Start measuring time of problem solution $problemName ...")

            println("End mesuaring time of problem solution $problemName")
        }

        fun testProblemSolution(problemName: String, test: (checker: PalindromePermutationChecker) -> Void) {
            println("Start testing solution of problem $problemName...")

            var checker = PalindromePermutationChecker()

            test(checker)

            println("End testing solution of problem $problemName")
        }
    }
}

val palindromeTest = {
    assertTrue(checker.isPermutationOfPalindrome(""))
    assertTrue(checker.isPermutationOfPalindrome(" "))
    assertTrue(checker.isPermutationOfPalindrome("Bbb"))
    assertTrue(checker.isPermutationOfPalindrome("Tact Coa"))
}

val oneWayTest = {
    println("One way test")
}

Launcher.testProblemSolution("Palindrom permutation", palindromeTest)
Launcher.testProblemSolution("One way", )