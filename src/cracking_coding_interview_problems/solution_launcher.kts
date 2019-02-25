//DEPS junit:junit:4.12
import org.junit.Assert.*
import java.util.*


//INCLUDE PalindromePermutationChecker.kt
//INCLUDE OneWay.kt
//INCLUDE StringCompression.kt
//INCLUDE Solution.kt
//INCLUDE MatrixRotation.kt
//INCLUDE ZeroMatrix.kt
//INCLUDE StringRotation.kt
//INCLUDE RemoveDups.kt
//INCLUDE LinkedListNode.kt

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

val zeroMatrixTest = { solution: Solution ->
    val size = 10
    val testArray = Array(size, {
        Array(size, {
            size - it - 1
        })
    })

    val zeroAction = solution as ZeroMatrix

    val result = zeroAction.execute(testArray)

    for(i in 0 until testArray.size) {
        println(testArray[i].joinToString(" "))
    }

    for(i in 0 until result.size) {
        println(result[i].joinToString(" "))
    }

    assertTrue(result[9][4] == 0)
}

val stringRotationTest = { solution: Solution ->

    val rotation = solution as StringRotation

    var firstInput = "waterbottle"

    var secondInput = "erbottlewat"

    val result = rotation.isSubtring(firstInput, secondInput)

    assertTrue(result)
}

val removeDupsTest = { solution: Solution ->

    val remover = removeDups as RemoveDups

    val sourceList = listOf(3, 1, 3, 3, 4)
    val resultList = listOf(4, 3, 1)

    var current: LinkedListNode? = LinkedListNode(null, 3)
    var newNode: LinkedListNode? = null
    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    remover.execute(current)

    var i = 0
    var node = current
    while(node != null) {
        assertTrue(node!!.data == resultList[i])

        node = node.next
        i++
    }

    assertTrue(i == resultList.size)
}

var checker = PalindromePermutationChecker()
val oneWay = OneWay()
val stringCompression = StringCompression()
val matrixRotation = MatrixRotation()
val zeroMatrix = ZeroMatrix()
val stringRotation = StringRotation()
val removeDups = RemoveDups()

Launcher.testProblemSolution("Palindrom permutation", palindromeTest, checker)
Launcher.testProblemSolution("One way", oneWayTest, oneWay)
Launcher.testProblemSolution("String compression", stringCompressionTest, stringCompression)
Launcher.testProblemSolution("Matrix rotation", matrixRotationTest, matrixRotation)
Launcher.testProblemSolution("Zero matrix", zeroMatrixTest, zeroMatrix)
Launcher.testProblemSolution("Removing duplications", removeDupsTest, removeDups)