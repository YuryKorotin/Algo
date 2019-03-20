//DEPS junit:junit:4.12
import org.junit.Assert.*
import java.util.*

//INCLUDE solutions/PalindromePermutationChecker.kt
//INCLUDE solutions/OneWay.kt
//INCLUDE solutions/StringCompression.kt
//INCLUDE solutions/Solution.kt
//INCLUDE solutions/MatrixRotation.kt
//INCLUDE solutions/ZeroMatrix.kt
//INCLUDE solutions/StringRotation.kt
//INCLUDE solutions/RemoveDups.kt
//INCLUDE solutions/LinkedListNode.kt
//INCLUDE solutions/KthToLast.kt
//INCLUDE solutions/DeleteMiddleNode.kt
//INCLUDE solutions/PalindromeChecker.kt
//INCLUDE solutions/PartitionOfList.kt
//INCLUDE solutions/SumList.kt
//INCLUDE solutions/IntersectionValidator.kt
//INCLUDE solutions/LoopDetector.kt
//INCLUDE solutions/MultiStack.kt
//INCLUDE Launcher.kt

//INCLUDE tests/LoopDetectorTest.kt
//INCLUDE tests/IntersectionValidatorTest.kt
//INCLUDE tests/PalindromCheckerTest.kt
//INCLUDE tests/PartitionOfListTest.kt
//INCLUDE tests/SumListTest.kt
//INCLUDE tests/DeleteMiddleNodeTest.kt
//INCLUDE tests/KthToLastTest.kt
//INCLUDE tests/RemoveDupsTest.kt
//INCLUDE tests/StringRotationTest.kt
//INCLUDE tests/ZeroMatrixTest.kt
//INCLUDE tests/MatrixRotationTest.kt
//INCLUDE tests/StringCompressionTest.kt
//INCLUDE tests/OneWayTest.kt
//INCLUDE tests/PalindromeTest.kt
//INCLUDE tests/MultiStackTest.kt

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
var interSectionValidator = IntersectionValidator()
var loopDetector = LoopDetector()
var multiStack = MultiStack(3, 10)

Launcher.testProblemSolution("Palindrom permutation", palindromeTest, checker)
Launcher.testProblemSolution("One way", oneWayTest, oneWay)
Launcher.testProblemSolution("String compression", stringCompressionTest, stringCompression)
Launcher.testProblemSolution("Matrix rotation", matrixRotationTest, matrixRotation)
Launcher.testProblemSolution("Zero matrix", zeroMatrixTest, zeroMatrix)
Launcher.testProblemSolution("Delete middle node", deleteMiddleNodeTest, deleteMiddleNode)
Launcher.testProblemSolution("Partition of list", partitionOfListTest, partitionOfList)
Launcher.testProblemSolution("Sum of numbers", sumListTest, sumList)
Launcher.testProblemSolution("Linked list is palindrome", palindromeCheckerTest, palindromeChecker)
Launcher.testProblemSolution("Intersection of lists", interSectionValidatorTest, interSectionValidator)
Launcher.testProblemSolution("Find loop start", loopDetectorTest, loopDetector)
Launcher.testProblemSolution("Multistack implementation", multiStackTest, multiStack)


