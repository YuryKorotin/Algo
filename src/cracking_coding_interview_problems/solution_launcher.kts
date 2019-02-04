//DEPS junit:junit:4.12
import org.junit.Assert.*


//INCLUDE PalindromePermutationChecker.kt

class Launcher {
    companion object {

        fun measureTime(fileName: String, problemName: String) {
            println("Start measuring time of problem solution $problemName ...")

            println("End mesuaring time of problem solution $problemName")
        }

        fun testProblemSolution(problemName: String) {
            println("Start testing solution of problem $problemName...")

            var checker = PalindromePermutationChecker()

            assertTrue(checker.isPermutationOfPalindrome(""))

            assertTrue()

            println("End testing solution of problem $problemName")
        }
    }
}

Launcher.testProblemSolution("Palindrom permutation")