//INCLUDE Solution.kt
//TODO: For space efficiency we can use bit vectors or first column and first row of source
class ZeroMatrix: Solution {
    fun execute(source: Array<Array<Int>>): Array<Array<Int>>{
        var size = source.size

        val result = Array(size, {
            Array(size, {
                0
            })
        })

        val indicesForEmptyRows = MutableList<Int>(size, {0})
        val indicesForEmptyColumns = MutableList<Int>(size, {0})

        for (i in 0 until size) {
            for (j in 0 until size) {
                if (source[i][j] == 0) {
                    indicesForEmptyColumns.add(j)
                    indicesForEmptyRows.add(i)
                }
            }
        }

        for (i in 0 until size) {
            for (j in 0 until size) {
                if (indicesForEmptyColumns.contains(j) ||
                        indicesForEmptyRows.contains(i)) {
                    result[i][j] = 0
                } else {
                    result[i][j] = source[i][j]
                }
            }
        }

        return result
    }
}