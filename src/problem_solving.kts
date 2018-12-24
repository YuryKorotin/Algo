package solution

import java.util.*
import java.io.File
import java.io.BufferedReader


//INCLUDE BalancedBrackets.kt
//INCLUDE TalesOfTwoStacks.kt
//INCLUDE DavisStaircase.kt
//INCLUDE CircleQueries.kt
//INCLUDE FraudulentActivity.kt

class Solution{
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            //solveProblem()
        }

        fun checkSolution(fileName: String) {
            var result = "SUCCESS"
            val expectedResults = readFromFile(fileName)
            val myResults = readFromFile("output.txt")

            for (i in 0 until expectedResults.size) {
                val expected = expectedResults.get(i)
                val myResult = myResults.get(i)
                if (!expected.equals(myResult)) {
                    println("FAILED %d variant".format(i))

                    println("Expected to be %s, but was %s".format(expected, myResult))

                    result = "FAILED"
                }
            }

            println(result)
        }

        fun solveBracketsProblem() {
            //val result = isBalanced(s)
            val input = readFromFile("input.txt")
            var output = mutableListOf<String>()

            val solution = BalancedBrackets()

            for (i in 1 until input.size) {
                output.add(solution.isBalanced(input.get(i)))
            }

            writeToFile(output)
        }


        fun solveQueueProblem() {
            //val result = isBalanced(s)
            val input = readFromFile("input.txt")

            val solution = TalesOfTwoStacks()

            val output = solution.changeQueue(input.subList(1, input.size))

            writeToFile(output)
        }

        fun solveDavisProblem() {
            val input = readFromFile("input.txt")

            val solution = DavisStaircase()

            val output = solution.calculate(input.subList(1, input.size))

            writeToFile(output)
        }

        fun solveCircleProblem() {
            val input = readFromFile("input.txt")

            val solution = CircleQueries()

            val output = solution.calculate(input.subList(1, input.size))

            writeToFile(output)
        }

        fun solveFraudulentProblem() {
            val input = readFromFile("input.txt")

            val solution = FraudulentActivity()

            val statistics = input.get(1).split(" ")

            val d = input.get(0).split(" ").get(1).toInt()

            val convertedList : List<Int> = statistics.map { it.toInt() }

            val output = solution.activityNotificationsCountSort(convertedList.toTypedArray(), d)

            val listOfOutput = listOf(output.toString())

            writeToFile(listOfOutput)
        }


        fun readFromConsole() : List<String>{
            val lineList = mutableListOf<String>()

            val scan = Scanner(System.`in`)

            val t = scan.nextLine().trim().toInt()

            lineList.add(t.toString())

            for (tItr in 1..t) {
                val s = scan.nextLine()

                lineList.add(s)

                println(">  " + s)
            }

            return lineList
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

Solution.solveFraudulentProblem()
//Solution.checkSolution("expected.txt")