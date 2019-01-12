package solution


class TrieForBits(val maxBit : Int = 31) {
    val root = Node(maxBit)

    class Node(val maxBit : Int = 31) {
        var children = Array<Node?>(2, {null})

        fun add(value: Int, index: Int) {
            val bitPos = maxBit - index
            if (bitPos < 0) {
                return
            }

            val power = 1.shl(bitPos)
            val bit = value / power
            val remainder = value % power

            println("value=$value;power=$power;bit=$bit;remainder=$remainder")

            val child = children[bit]

            if(child != null) {
                child.add(remainder, index + 1)
            } else {
                val newNode = Node()
                newNode.add(remainder, index + 1)
                children[bit] = newNode
            }
        }
    }

    fun add(value: Int) {
        root.add(value, 0)
    }

    fun getMaxXor(value: Int) : Int {
        var current = root
        var xorValue = 0
        var remainder = value

        for(i in 0 until 32) {
            val bitPos = 31 - i
            val power = 1.shl(bitPos)
            val bit = remainder / power
            remainder = remainder % power

            val child = current.children[bit.xor(1)]

            if (child != null) {
                xorValue += power
                current = child
            } else {
                current = current.children[bit]!!
            }
        }

        return xorValue
    }
}