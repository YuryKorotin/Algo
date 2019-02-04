//DEPS junit:junit:4.12
import org.junit.Assert.*


//INCLUDE PalindromePermutationChecker.kt

class Launcher {
    companion object {

        fun checkSolution(fileName: String, problemName: String) {
            println("Start checking of problem solution$problemName ...")

            println("End checking of problem solution $problemName")
        }

        fun solveProblem(problemName: String) {
            println("Start solution of problem $problemName...")

            var checker = PalindromePermutationChecker()

            assertTrue(checker.isPermutationOfPalindrome(""))

            println("End solution of problem $problemName")
        }
    }
}

Launcher.solveProblem("Palindrom permutation")