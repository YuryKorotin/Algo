open class Animal(var name: String = "") {
    var order: Int = 0

    fun isOlderThan(animal: Animal): Boolean {
        return this.order > animal.order
    }
}

class Dog(name: String = ""): Animal(name)

class Cat(name: String = ""): Animal(name)


class AnimalShelter: Solution {
    val dogs: MutableList<Dog> = mutableListOf()
    val cats: MutableList<Cat> = mutableListOf()
    var order: Int = 0

    fun enqueue(animal: Animal) {
        animal.order = order
        order++
        if (animal is Dog) {
            dogs.add(animal)
        } else if (animal is Cat) {
            cats.add(animal)
        }
    }

    fun dequeueAny(): Animal {
        if (dogs.isEmpty()) {
            return dequeueCats()
        } else if (cats.isEmpty()) {
            return dequeueDogs()
        }

        val dog = dogs.get(dogs.size - 1)

        val cat = cats.get(cats.size - 1)

        if (dog.isOlderThan(cat)) {
            return dequeueDogs()
        } else {
            return dequeueCats()
        }
    }

    fun dequeueCats(): Cat {
        val cat = cats.get(cats.size - 1)

        cats.remove(cat)

        return cat
    }

    fun dequeueDogs(): Dog {
        val dog = dogs.get(dogs.size - 1)

        dogs.remove(dog)

        return dog
    }
}