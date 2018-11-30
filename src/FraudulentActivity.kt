package solution

open class FraudulentActivity {
    fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
        /*val endOfRange = expenditure.size
        var numberOfNotifications = 0

        var sliced = expenditure.slice(0..d - 1).toMutableList()
        var sum = sliced.sum().toDouble()
        var mediana : Double = sum / d

        for(i in d until endOfRange) {
            if (expenditure[i] >= mediana * 2) {
                numberOfNotifications += 1
            }

            sliced.removeAt(0)
            val newItem = expenditure[i]
            sliced.add(newItem)

            sum = sliced.sum().toDouble()
            mediana = sum / d
        }

        return numberOfNotifications*/
        val endOfRange = expenditure.size
        var numberOfNotifications = 0

        var sliced = expenditure.slice(0..d - 1).sorted().toMutableList()

        for(i in d until endOfRange) {
            val mediana = sliced.get(d / 2)

            if (expenditure[i] >= mediana * 2) {
                numberOfNotifications += 1
            }

            sliced.remove(expenditure[i - d])

            val newItem = expenditure[i]

            for (j in 0 until sliced.size) {
                if (newItem <= sliced.get(j)) {
                    sliced.add(j, newItem)
                    break
                }
                if (j == sliced.size - 1) {
                    sliced.add(newItem)
                }
            }
        }

        return numberOfNotifications
    }
}