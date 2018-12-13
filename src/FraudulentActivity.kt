package solution

open class FraudulentActivity {
    fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
        val endOfRange = expenditure.size
        var numberOfNotifications = 0

        var sliced = expenditure.slice(0..d - 1).sorted().toMutableList()

        var mediana = 0

        for(i in d until endOfRange) {
            if (d % 2 != 0) {
                mediana = sliced.get(d / 2) * 2
            } else {
                mediana = sliced.get(d / 2) + sliced.get(d / 2 - 1)
            }

            if (expenditure[i] >= mediana) {
                numberOfNotifications += 1
            }

            sliced.remove(expenditure[i - d])

            val newItem = expenditure[i]
            val sliceSize =  sliced.size

            if (newItem > sliced.get(sliceSize - 1)) {
                sliced.add(newItem)
                continue
            }

            sliced.add(
                    findBestIndex(
                            newItem,
                            sliced,
                            0,
                            sliceSize - 1),
                    newItem)
        }

        return numberOfNotifications
    }

    fun findBestIndex(item: Int,
                      list: MutableList<Int>,
                      startPosition: Int,
                      endPosition: Int) : Int{
        val rangeSize = (endPosition - startPosition) / 2

        if (item == list.get(startPosition)) {
            return startPosition
        }

        if (item == list.get(endPosition)) {
            return endPosition
        }

        if (rangeSize == 0) {
            return endPosition
        }

        if (item > list.get(startPosition + rangeSize)) {
            return findBestIndex(
                    item,
                    list,
                    startPosition + rangeSize,
                    endPosition)
        } else {
            return findBestIndex(
                    item,
                    list,
                    startPosition,
                    startPosition + rangeSize)
        }
    }
}