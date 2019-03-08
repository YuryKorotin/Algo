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
//INCLUDE KthToLast.kt
//INCLUDE DeleteMiddleNode.kt
//INCLUDE PalindromeChecker.kt
//INCLUDE PartitionOfList.kt
//INCLUDE SumList.kt


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

    val remover = solution as RemoveDups

    val sourceList = listOf(3, 1, 3, 3, 4)
    val resultList = listOf(4, 3, 1)

    var current: LinkedListNode? = LinkedListNode(null, 3)
    var newNode: LinkedListNode? = null
    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    remover.executeWithoutBuffer(current)

    var i = 0
    var node = current
    while(node != null) {
        assertTrue(node!!.data == resultList[i])

        node = node.next
        i++
    }

    assertTrue(i == resultList.size)
}


val kThToLastTest = { solution: Solution ->

    val finder = solution as KthToLast

    val sourceList = listOf(5, 4, 3, 2, 1)
    val resultList = listOf(4, 3, 1)

    var current: LinkedListNode? = LinkedListNode(null, 3)
    var newNode: LinkedListNode? = null
    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    val k = 3
    val node = finder.find(current, k)

    assertTrue(node!!.data == 3)
}

val deleteMiddleNodeTest = { solution: Solution ->

    val remover = solution as DeleteMiddleNode

    val sourceList = listOf(7, 12, 1, 2, 3, 4)
    val resultList = listOf(4, 3, 1, 12, 7)

    var current: LinkedListNode? = LinkedListNode(null, sourceList[0])
    var newNode: LinkedListNode? = null

    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    remover.execute(current)

    var node = current

    resultList.forEach {
        assertTrue(it == node!!.data)

        node = node!!.next
    }
}

val partitionOfListTest = { solution: Solution ->

    val partitioner = solution as PartitionOfList

    val sourceList = listOf(3, 5, 8, 5, 10, 2, 1).reversed()

    var current: LinkedListNode? = LinkedListNode(null, sourceList[0])
    var newNode: LinkedListNode? = null

    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    val target = 5

    var node = partitioner.execute(current, target)

    var index = 0
    val lessIndeces = mutableListOf<Int>()
    val greaterIndeces = mutableListOf<Int>()
    while (node != null) {

        if (node!!.data < target) {
            lessIndeces.add(index)
        }

        if (node!!.data > target) {
            greaterIndeces.add(index)
        }

        node = node!!.next

        index++
    }

    assertTrue(lessIndeces.sorted().last() < greaterIndeces.sorted().first())
}

val sumListTest = { solution: Solution ->

    val sumMaker = solution as SumList

    val firstNumberList = listOf(7, 1, 6).reversed()
    val secondNumberList = listOf(5, 9, 2).reversed()
    val resultList = listOf(2, 1, 9)


    var current: LinkedListNode? = LinkedListNode(null, firstNumberList[0])
    var newNode: LinkedListNode? = null

    for (i in 1 until firstNumberList.size) {
        newNode = LinkedListNode(current, firstNumberList[i])
        current = newNode!!
    }

    val firstNumber = current

    current = LinkedListNode(null, secondNumberList[0])
    newNode = null

    for (i in 1 until secondNumberList.size) {
        newNode = LinkedListNode(current, secondNumberList[i])
        current = newNode!!
    }

    val secondNumber = current

    var node = sumMaker.execute(firstNumber, secondNumber)
    var index = 0

    while (node != null) {
        assertTrue(resultList[index] == node!!.data)

        node = node!!.next

        index++
    }
    //TODO: Write reversed solution
}

val palindromeCheckerTest = { solution: Solution ->

    val checker = solution as PalindromeChecker

    val sourceList = listOf(0, 1, 2, 1, 0).reversed()

    var current: LinkedListNode? = LinkedListNode(null, sourceList[0])
    var newNode: LinkedListNode? = null

    for (i in 1 until sourceList.size) {
        newNode = LinkedListNode(current, sourceList[i])
        current = newNode!!
    }

    assertTrue(checker.isPalindromeRecursive(current))
}

var checker = PalindromePermutationChecker()
val oneWay = OneWay()
val stringCompression = StringCompression()
val matrixRotation = MatrixRotation()
val zeroMatrix = ZeroMatrix()
val stringRotation = StringRotation()
val removeDups = RemoveDups()
val nodeFinder = KthToLast()
var deleteMiddleNode = DeleteMiddleNode()
var partitionOfList = PartitionOfList()
var sumList = SumList()
var palindromeChecker = PalindromeChecker()

Launcher.testProblemSolution("Palindrom permutation", palindromeTest, checker)
Launcher.testProblemSolution("One way", oneWayTest, oneWay)
Launcher.testProblemSolution("String compression", stringCompressionTest, stringCompression)
Launcher.testProblemSolution("Matrix rotation", matrixRotationTest, matrixRotation)
Launcher.testProblemSolution("Zero matrix", zeroMatrixTest, zeroMatrix)
Launcher.testProblemSolution("Delete middle node", deleteMiddleNodeTest, deleteMiddleNode)
Launcher.testProblemSolution("Partition of list", partitionOfListTest, partitionOfList)
Launcher.testProblemSolution("Sum of numbers", sumListTest, sumList)
Launcher.testProblemSolution("Linked list is palindrome", palindromeCheckerTest, palindromeChecker)
