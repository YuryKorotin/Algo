package solution

//INCLUDE algorithms/QuickSelect.kt
//INCLUDE algorithms/CountingSort.kt

open class FraudulentActivity {
    fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
        val endOfRange = expenditure.size
        var numberOfNotifications = 0

        var sliced = expenditure.slice(0..d - 1).sorted().toMutableList()

        var mediana = 0
        val isOdd = d % 2 != 0
        val halfSize = d / 2

        for(i in d until endOfRange) {
            if (isOdd) {
                mediana = sliced.get(halfSize) * 2
            } else {
                mediana = sliced.get(halfSize) + sliced.get(halfSize - 1)
            }

            if (expenditure[i] >= mediana) {
                numberOfNotifications += 1
            }

            sliced.remove(expenditure[i - d])

            val newItem = expenditure[i]
            val sliceSize =  sliced.size
            if (newItem >= sliced.get(sliceSize - 1)) {
                sliced.add(newItem)
                continue
            }

            if (newItem <= sliced.get(0)) {
                sliced.add(0, newItem)
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

    fun activityNotificationsCountSort(expenditure: Array<Int>, d: Int): Int {
        val endOfRange = expenditure.size
        var numberOfNotifications = 0

        val sorter = CountingSort(200)
        var sliced : Array<Int> = expenditure.slice(0..d - 1).toTypedArray()
        sliced = sorter.sort(sliced)

        var mediana = 0
        val isOdd = d % 2 != 0
        val halfSize = d / 2

        for(i in d until endOfRange) {
            if (isOdd) {
                mediana = sliced[halfSize] * 2
            } else {
                mediana = sliced[halfSize] + sliced[halfSize - 1]
            }

            if (expenditure[i] >= mediana) {
                numberOfNotifications += 1
            }

            sliced = expenditure.slice(i - d + 1..i).toTypedArray()
            sliced = sorter.sort(sliced)
        }

        return numberOfNotifications
    }

    fun activityNotificationsWithoutSort(expenditure: Array<Int>, d: Int): Int {
        val endOfRange = expenditure.size
        var numberOfNotifications = 0

        val select = QuickSelect()
        val target = expenditure.toIntArray()


        var mediana = 0
        val isOdd = d % 2 != 0
        val halfSize = d / 2

        for(i in d until endOfRange) {
            if (isOdd) {
                mediana = select.quickSelect(target, i - d, i, i - halfSize - 1) * 2
            } else {
                mediana = select.quickSelect(target, i - d, i, i - halfSize)
                val prev = select.quickSelect(target, i - d, i - 1, i - halfSize - 1)

                mediana = mediana + prev
            }

            if (expenditure[i] >= mediana) {
                numberOfNotifications += 1
            }
        }

        return numberOfNotifications
    }

    fun findBestIndex(item: Int, list: MutableList<Int>, startPosition: Int, endPosition: Int) : Int{
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
