
open class UnionFinder {

    val parents : HashMap<Int, Int> = HashMap<Int, Int>()
    val sizes : HashMap<Int, Int> = HashMap<Int, Int>()
    var max = 0
    open fun union(v1: Int, v2: Int) {

        if (!parents.containsKey(v1)) {
            parents.put(v1, v1)
            sizes.put(v1, 1)
        }

        if (!parents.containsKey(v2)) {
            parents.put(v2, v2)
            sizes.put(v2, 1)
        }

        val p1 = find(v1)
        val p2 = find(v2)

        if (p1 == p2) {
            return
        }
        val s1 = sizes.get(p1)!!
        val s2 = sizes.get(p2)!!
        if (s1 < s2) {
            parents.put(p1, p2)
            sizes.put(p2, s1 + s2)
            if (s1 + s2 > max) {
                max = s1 + s2
            }
        } else {
            parents.put(p2, p1)
            sizes.put(p1, s1 + s2)
            if (s1 + s2 > max) {
                max = s1 + s2
            }
        }
    }

    open fun find(v : Int) : Int {
        var result = v

        while (parents.get(v) != v) {
            parents.put(v, parents.get(parents.get(v)!!)!!)
            result = parents.get(v)!!

            System.out.println(result)
        }
        return result
    }
}