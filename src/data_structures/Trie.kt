package solution.data_structures

//DEPS com.offbytwo:docopt:0.6.0.20150202,log4j:log4j:1.2.14

//'io.kotlintest:kotlintest-runner-junit5:3.1.11'

data class Trie(private val char: Char,
                private val indices: MutableList<Int> = mutableListOf(),
                private val children: MutableList<Trie> = mutableListOf()) {


    fun add(word: String,
            index: Int) {
        val first = word.first()
        val trie = findOrCreate(first)

        when(word.length) {
            1 -> trie.indices.add(index)
            else -> trie.add(word.drop(1), index)
        }
    }

    fun get(word: String) : List<Int> {
        val first = word.first()

        return find(first)?.run {
            when(word.length) {
                1 -> indices
                else -> get(word.drop(1))
            }
        } ?: listOf()
    }

    private fun findOrCreate(char: Char) : Trie {
        find(char) ?: Trie(char).apply {
            this@Trie.children.add(this)
        }
    }

    private fun find(char: Char) : Trie {
        children.find {
            it.char == char
        }
    }

    fun empty() = Trie(char = ' ')
}