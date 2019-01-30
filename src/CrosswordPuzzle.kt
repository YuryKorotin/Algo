package solution

import java.util.ArrayList
import java.util.stream.IntStream


class CrosswordPuzzle {

    val size = 10
    val r_offsets = intArrayOf(0, 1)
    val c_offsets = intArrayOf(1, 0)

    fun putWords(crossword: Array<String>, words: String): Array<CharArray>? {
        var wordsList = words.split(";").toMutableList()

        val wordSet: MutableSet<String> = mutableSetOf()

        wordSet.addAll(wordsList)

        val crosswordMatrix = Array(size) { CharArray(size) }
        for (i in 0 until size) {
            val line = crossword.get(i)
            for (j in 0 until size) {
                crosswordMatrix[i][j] = line[j]
            }
        }

        val result = search(crosswordMatrix, wordSet, 0, 0, 0);

        return result
    }

    fun search(crossword: Array<CharArray>,
               wordSet: MutableSet<String>,
               r: Int,
               c: Int,
               direction: Int) : Array<CharArray>? {

        if (r == size) {
            return crossword
        }
        if (c == size) {
            return search(crossword, wordSet, r + 1, 0, 0);
        }
        if (direction == r_offsets.size) {
            return search(crossword, wordSet, r, c + 1, 0);
        }

        val insertLength = countInsertLength(crossword, r, c, direction)
        if (insertLength > 1) {
            for (remainWord in ArrayList<String>(wordSet)) {
                if (canInsert(crossword, r, c, direction, insertLength, remainWord)) {
                    val insertOffsets = ArrayList<Int>()

                    for (insertOffset in 0 until insertLength) {
                        val insertR = r + r_offsets[direction] * insertOffset
                        val insertC = c + c_offsets[direction] * insertOffset

                        if (crossword[insertR][insertC] === '-') {
                            crossword[insertR][insertC] = remainWord.get(insertOffset)

                            insertOffsets.add(insertOffset)
                        }
                    }
                    wordSet.remove(remainWord)

                    val subResult = search(crossword, wordSet, r, c, direction + 1)
                    if (subResult != null) {
                        return subResult
                    }

                    wordSet.add(remainWord)
                    for (insertOffset in insertOffsets) {
                        val insertR = r + r_offsets[direction] * insertOffset
                        val insertC = c + c_offsets[direction] * insertOffset

                        crossword[insertR][insertC] = '-'
                    }
                }
            }

            return null
        } else {
            return search(crossword, wordSet, r, c, direction + 1)
        }
    }

    fun countInsertLength(crossword: Array<CharArray>, r: Int, c: Int, direction: Int): Int {
        var r = r
        var c = c
        val prevR = r - r_offsets[direction]
        val prevC = c - c_offsets[direction]
        if (prevR >= 0 && prevR < size && prevC >= 0 && prevC < size && crossword[prevR][prevC] != '+') {
            return 0
        }

        var insertLength = 0
        while (r >= 0 && r < size && c >= 0 && c < size && crossword[r][c] != '+') {
            insertLength++

            r += r_offsets[direction]
            c += c_offsets[direction]
        }
        return insertLength
    }

    fun canInsert(crossword: Array<CharArray>, r: Int, c: Int, direction: Int, insertLength: Int, word: String): Boolean {

        var result = false

        for (insertOffset in 0 until word.length){
            val insertR = r + r_offsets[direction] * insertOffset
            val insertC = c + c_offsets[direction] * insertOffset
            result = crossword[insertR][insertC] == '-' || crossword[insertR][insertC] == word[insertOffset]
        }
        return word.length == insertLength && result
    }
}