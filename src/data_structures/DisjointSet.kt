package solution


class DisjointSet(val elements: List<Int>) {
    private val parent = mutableMapOf<Int, Int>()
    private val rank = mutableMapOf<Int, Int>()

    public var max = 2

    init {
        makeSet()
    }

    fun makeSet() {
        elements.forEach{ element ->
            parent.put(element, element)
        }
    }

    public fun connected(v: Int, w: Int): Boolean {
        return find(v) == find(w)
    }

    public fun find(element: Int): Int {
        var element = element

        parent.forEach lit@{ key, value ->
            println("$key = $value")
            if (parent.get(element) == element) {
                return@lit
            }
            parent.put(element, parent.get(element)!!)
            element = parent.get(element)!!
        }
        return element
    }

    public fun union(v: Int, w: Int) {
        val rootV = find(v)
        val rootW = find(w)
        if (rootV == rootW) {
            return
        }
        val rankOfRootV = rank.get(rootV) ?: 0
        val rankOfRootW = rank.get(rootW) ?: 0


        if (rankOfRootV > rankOfRootW) {
            parent.put(rootW, rootV)
        } else if (rankOfRootW > rankOfRootV) {
            parent.put(rootV, rootW)
        } else {
            parent.put(rootW, rootV)

            rank.put(rootW, rankOfRootW + 1)

            if (rankOfRootW + 1 > max) {
                max = rankOfRootW + 1
            }
        }
    }
}