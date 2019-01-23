package solution

/*
A string is said to be a child of a another string if it can be formed by deleting 0 or more
characters from the other string. Given two strings of equal length,
what's the longest string that can be constructed such that it is a child of both?
For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed
by eliminating either the D or C from both strings. Note that we will not consider ABCD as a common
child because we can't rearrange characters and ABCD  ABDC.
* */

class CommonChild {
    fun commonChildOld(firstString: String, secondString: String): Int {
        var firstCommon = ""
        var secondPositions = mutableListOf<Int>()

        var lastCommon = 0

        for (i in 0 until firstString.length) {
            for (j in 0 until secondString.length) {
                if (firstString[i] == secondString[j]) {
                    secondPositions.add(j)
                    if (lastCommon == i) {
                        continue
                    }
                    lastCommon = i

                    firstCommon += firstString[i]
                }
            }
        }

        var secondCommon = ""

        val secondPositionsSorted = secondPositions.sorted().distinct()

        for (i in 0 until secondPositionsSorted.size) {
            secondCommon += secondString[secondPositionsSorted[i]]
        }

        val commonChilds = mutableListOf<String>()

        var i = 0
        var j = 0
        var child  = ""
        println(firstCommon)
        println(secondCommon)
        while (i < firstCommon.length) {
            j = 0
            if (child.isNotEmpty()) {
                commonChilds.add(child)
                child = ""
            }
            while (j < secondCommon.length) {
                if (i == firstCommon.length) {
                    commonChilds.add(child)
                    child = ""
                    break
                }

                println("i=$i and j=$j")
                if (firstCommon[i] == secondCommon[j]) {
                    child += firstCommon[i]

                    println("child=$child")

                    if (j != secondCommon.length - 1) {
                        i++
                    }
                }

                j++
            }

            i++
        }
        if (child.isNotEmpty()) {
            commonChilds.add(child)
            println("child=$child")
        }

        var max = 0
        commonChilds.forEach { item ->
            println(item)
            if (item.length > max) {
                max = item.length
            }
        }


        return max
    }

    fun commonChild(firstString: String, secondString: String): Int {
        val shortStrings = shortenStrings(firstString, secondString)
        return LCS(shortStrings[0], shortStrings[1])
    }

    fun shortenStrings(x : String, y : String) : List<String> {
        println("length=${x.length}")
        var xCommonEnd = x.length - 1
        var yCommonEnd = y.length - 1

        var xCommonStart = 0
        var yCommonStart = 0

        for(i in 0 until x.length) {
            if (y.contains(x[i])) {
                xCommonStart = i
                println("xStart=$xCommonStart")
                break
            }
        }

        for(i in 0 until y.length) {
            if (x.contains(y[i])) {
                yCommonStart = i
                println("yStart=$yCommonStart")
                break
            }
        }

        for(i in y.length - 1 downTo 0) {
            if (x.contains(y[i])) {
                yCommonEnd = i
                println("yEnd=$yCommonEnd")
                break
            }
        }

        for(i in x.length - 1 downTo 0) {
            if (y.contains(x[i])) {
                xCommonEnd = i
                println("xEnd=$xCommonEnd")
                break
            }
        }

        return listOf(x.substring(xCommonStart, xCommonEnd + 1), y.substring(yCommonStart, yCommonEnd + 1))
    }

    //Longest common subsequence
    fun LCS(x : String, y : String) : Int {
        var startPosition = 0
        var xCommonEnd = x.length
        var yCommonEnd = y.length

        var previousStorage = Array<Int>(x.length + 1, {0})
        var currentStorage = Array<Int>(x.length + 1, {0})

        for(i in startPosition until xCommonEnd) {
            for(j in startPosition until yCommonEnd) {
                if (x[i] == y[j]) {
                    currentStorage[j + 1] = previousStorage[j] + 1
                } else {
                    currentStorage[j + 1] = maxOf(currentStorage[j], previousStorage[j + 1])
                }
            }
            previousStorage = currentStorage
            currentStorage = Array<Int>(x.length + 1, {0})
        }

        return previousStorage[yCommonEnd]
    }
}