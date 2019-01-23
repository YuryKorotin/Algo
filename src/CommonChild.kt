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
        return LCS(firstString, secondString)
    }

    //Longest common subsequence
    fun LCS(x : String, y : String) : Int {
        var startPosition = 0
        var xCommonEnd = x.length - 1
        var yCommonEnd = y.length - 1

        while (startPosition <= xCommonEnd &&
                startPosition <= yCommonEnd &&
                x[startPosition] == y[startPosition]) {
            startPosition++
        }

        while (startPosition <= xCommonEnd &&
                startPosition <= yCommonEnd &&
                x[xCommonEnd] == y[yCommonEnd]) {
            xCommonEnd--
            yCommonEnd--
        }

        val lengthStorage : Array<Array<Int>> = Array(x.length + 1, {
            Array(y.length + 1, {
                0
            })
        })

        for(i in startPosition until xCommonEnd) {
            for(j in startPosition until yCommonEnd) {
                if (x[i] == y[j]) {
                    lengthStorage[i + 1][j + 1] = lengthStorage[i][j] + 1
                } else {
                    lengthStorage[i + 1][j + 1] = maxOf(lengthStorage[i + 1][j], lengthStorage[i][j + 1])
                }
            }
        }

        return lengthStorage[xCommonEnd][yCommonEnd]
    }
}