package solution

import java.util.*
import java.io.File
import java.io.BufferedReader

//INCLUDE balanced_brackets.kt

class Solution{
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            solveProblem()
        }

        fun checkSolution(fileName: String) {
            var result = "SUCCESS"
            val expectedResults = readFromFile(fileName)
            val myResults = readFromFile("output.txt")

            for (i in 0 until expectedResults.size) {
                val expected = expectedResults.get(i)
                val myResult = myResults.get(i)
                if (!expected.equals(myResult)) {
                    println("FAILED %i variant".format(i))

                    println("Expected to be %s, but was %s".format(expected, myResult))

                    result = "FAILED"
                }
            }

            println(result)
        }

        fun solveProblem() {
            //val result = isBalanced(s)
            val input = readFromFile("input.txt")
            var output = mutableListOf<String>()

            val solution = BalancedBracketsSolution()

            for (i in 1 until input.size) {
                output.add(solution.isBalanced(input.get(i)))
            }

            writeToFile(output)
        }

        fun readFromConsole() {
            val lineList = mutableListOf<String>()

            val scan = Scanner(System.`in`)

            val t = scan.nextLine().trim().toInt()

            lineList.add(t.toString())

            for (tItr in 1..t) {
                val s = scan.nextLine()

                lineList.add(s)

                println(">  " + s)
            }

        }

        fun readFromFile(fileName: String) : List<String> {
            val bufferedReader = File(fileName).bufferedReader()

            val lineList = mutableListOf<String>()

            bufferedReader.useLines { lines ->
                lines.forEach {
                    lineList.add(it)
                }
            }

            lineList.forEach {
                println(">  " + it)
            }

            return lineList
        }

        fun writeToFile(result : List<String>) {
            File("output.txt").printWriter().use { out ->
                result.forEach { item ->
                    out.println(item)
                }
            }
        }
    }
}

Solution.solveProblem()
Solution.checkSolution("expected.txt")