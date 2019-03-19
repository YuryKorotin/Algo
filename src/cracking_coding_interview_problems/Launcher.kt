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