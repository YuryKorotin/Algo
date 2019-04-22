val animalShelterTest = { solution: Solution ->
    val animalShelter = solution as AnimalShelter

    val testCat = Cat("Kitty")
    val testDog = Dog("Bobby")

    animalShelter.enqueue(testCat)

    animalShelter.enqueue(testDog)

    assertTrue(animalShelter.dequeueCats() === testCat)

    assertTrue(animalShelter.dequeueAny() === testDog)
}
