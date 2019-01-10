
class UnionFinder {

    val parents : HashMap<Int, Int> = HashMap<Int, Int>()
    val sizes : HashMap<Int, Int> = HashMap<Int, Int>()
    var max = 0

    open fun union(firstFriend: Int, secondFriend: Int) {
        if (!parents.containsKey(firstFriend)) {
            parents.put(firstFriend, firstFriend)
            sizes.put(firstFriend, 1)
        }

        if (!parents.containsKey(secondFriend)) {
            parents.put(secondFriend, secondFriend)
            sizes.put(secondFriend, 1)
        }

        val firstParent = find(firstFriend)
        val secondParent = find(secondFriend)

        if (firstParent == secondParent) {
            return
        }
        val firstSize = sizes.get(firstParent)!!
        val secondSize = sizes.get(secondParent)!!

        val togetherSize = firstSize + secondSize

        if (firstSize < secondSize) {
            parents.put(firstParent, secondParent)

            sizes.put(secondParent, togetherSize)
            if (togetherSize > max) {
                max = togetherSize
            }
        } else {
            parents.put(secondParent, firstParent)
            sizes.put(firstParent, togetherSize)
            if (togetherSize > max) {
                max = togetherSize
            }
        }
    }

    open fun find(item : Int) : Int {
        var result = item

        while (parents.get(result) != result) {
            parents.put(result, parents.get(parents.get(item)!!)!!)
            result = parents.get(result)!!
        }
        
        return result
    }
}