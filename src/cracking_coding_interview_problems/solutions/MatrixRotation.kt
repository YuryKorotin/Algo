//INCLUDE solutions/Solution.kt

class MatrixRotation: Solution {
    fun apply(source: Array<Array<Int>>): Array<Array<Int>>{

        if (source.size == 0 ||
                source.size != source[0].size) {
            return source
        }
        var size = source.size

        val result = Array(size, {
            Array(size, {
                0
            })
        })

        for (i in 0 until size / 2) {
            var first = i
            var last = size - 1 - i
            for (j in first until last) {
                var offset = j - first
                var top = source[first][j]
                result[first][j] = source[last - offset][first]
                result[last - offset][first] = source[last][last - offset]
                result[last][last - offset] = source[j][last]
                result[j][last] = top

            }
        }


        return result
    }
}