package solution

import java.util.*
import java.io.File
import java.io.BufferedReader


//INCLUDE BalancedBrackets.kt
//INCLUDE TalesOfTwoStacks.kt
//INCLUDE DavisStaircase.kt
//INCLUDE CircleQueries.kt
//INCLUDE FraudulentActivity.kt
//INCLUDE CountingInversions.kt
//INCLUDE MaxCircles.kt
//INCLUDE MaxXor.kt
//INCLUDE SpecialPalindromeAgain.kt
//INCLUDE CommonChild.kt
//INCLUDE CrosswordPuzzle.kt

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

        fun solveCountingInversions() {
            val input = readFromFile("input.txt")

            val solution = CountingInversions()

            val statistics = input.get(1).split(" ")

            val d = input.get(0).split(" ").get(1).toInt()

            val convertedList : List<Int> = statistics.map { it.toInt() }

            val output = solution.countInversions(convertedList.toTypedArray())

            val listOfOutput = listOf(output.toString())

            writeToFile(listOfOutput)
        }

        fun solveMaxCircles() {
            val input = readFromFile("input.txt")

            val solution = MaxCircles()

            val lines = input.get(0).toInt()

            val adjacencies : Array<Array<Int>> = Array(lines, {
                Array(2, {
                    0
                })
            })


            for (i in 1..lines) {
                adjacencies[i - 1][0] = input.get(i).split(" ").get(0).toInt()
                adjacencies[i - 1][1] = input.get(i).split(" ").get(1).toInt()
            }

            val output : Array<Int> = solution.maxCircle(adjacencies)

            val listOfOutput = listOf(output.joinToString("\n"))

            writeToFile(listOfOutput)
        }

        fun solveMaxXor() {
            val input = readFromFile("input.txt")

            val solution = MaxXor()

            val arrSize = input.get(0).toInt()

            val arr : Array<Int> = Array(arrSize, { 0 })

            input.get(1).split(" ").forEachIndexed { index, s ->
                arr[index] = s.toInt()
            }

            val querySize = input.get(2).toInt()

            val queries : Array<Int> = Array(querySize, {0})

            for (i in 0 until querySize) {
                queries[i] = input.get(3 + i).toInt()
            }

            val output : Array<Int> = solution.maxXor(arr, queries)

            val listOfOutput = listOf(output.joinToString("\n"))

            writeToFile(listOfOutput)
        }

        fun solveSpecialPalindromeAgain() {
            val input = readFromFile("input.txt")

            val solution = SpecialPalindromeAgain()

            val stringLength = input.get(0).toInt()

            val output : Long = solution.substrCount(stringLength, input.get(1))

            val listOfOutput = listOf(output.toString())

            writeToFile(listOfOutput)
        }

        fun solveCommonChild() {
            val input = readFromFile("input.txt")

            val solution = CommonChild()

            val firstString = input.get(0)

            val output : Int = solution.commonChild(input.get(0), input.get(1))

            val listOfOutput = listOf(output.toString())

            writeToFile(listOfOutput)
        }

        fun solveCrosswordPuzzle() {
            val input = readFromFile("input.txt")

            val solution = CrosswordPuzzle()

            val crosswordSize = 10

            val crossword = Array<String>(10, { "" })
            for (i in 0 until 10) {
                val crosswordItem = input.get(i)
                crossword[i] = crosswordItem
            }

            val words = input.get(crosswordSize)

            val result = solution.putWords(crossword, words)

            if (result == null) {

                println("Wrong input, cannot be solving")

                return
            }

            val output = mutableListOf<String>()

            for(i in 0 until result.size) {
                output.add(String(result[i]))
            }

            writeToFile(output)
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

Solution.solveCrosswordPuzzle()
//Solution.checkSolution("expected.txt")