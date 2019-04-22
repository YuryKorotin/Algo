open class Animal(var name: String = "") {
    var order: Int = 0

    fun isOlderThan(animal: Animal): Boolean {
        return this.order > animal.order
    }
}

class Dog(name: String = ""): Animal(name)

class AnimalShelter: Solution {
}