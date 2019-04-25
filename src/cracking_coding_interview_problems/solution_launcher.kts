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
//INCLUDE solutions/StackMin.kt
//INCLUDE solutions/SetOfStacks.kt
//INCLUDE solutions/QueueOnStack.kt
//INCLUDE solutions/SortStack.kt
//INCLUDE solutions/AnimalShelter.kt
//INCLUDE solutions/RouteBetween.kt
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
//INCLUDE tests/StackMinTest.kt
//INCLUDE tests/SetOfStacksTest.kt
//INCLUDE tests/QueueOnStackTest.kt
//INCLUDE tests/SortStackTest.kt
//INCLUDE tests/AnimalShelterTest.kt
//INCLUDE tests/RouteBetweenTest.kt

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
var stackMin = StackMin()
var setOfStacks = SetOfStacks(5)
var queueOnStack = QueueOnStack()
var sortStack = SortStack()
var animalShelter = AnimalShelter()
var routeBetween = RouteBetween()

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
Launcher.testProblemSolution("Stack min implementation", stackMinTest, stackMin)
Launcher.testProblemSolution("SetOfStacks", setOfStacksTest, setOfStacks)
Launcher.testProblemSolution("Queue on stack", queueOnStackTest, queueOnStack)
Launcher.testProblemSolution("Sort stack", sortStackTest, sortStack)
Launcher.testProblemSolution("Animal shelter", animalShelterTest, animalShelter)
Launcher.testProblemSolution("Route between nodes", routeBetweenTest, routeBetween)