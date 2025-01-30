package queue.interviewquestions.animalshelter;

import java.util.LinkedList; // Import LinkedList for queue functionality

// Queue for managing animals (dogs and cats) in the shelter
public class AnimalQueue {

    LinkedList<Dog> dogs = new LinkedList<>(); // Queue for dogs
    LinkedList<Cat> cats = new LinkedList<>(); // Queue for cats
    private int order = 0; // Global order counter for all animals

    // Adds a new animal to the queue
    public void enqueue(Animal a) {
        a.setOrder(order); // Assign the current order to the animal
        order++; // Increment the global order counter
        switch (a) { // Determine the type of animal
            case Dog dog ->
                    dogs.addLast(dog); // Add dog to the dog queue
            case Cat cat ->
                    cats.addLast(cat); // Add cat to the cat queue
            default -> {
                // Handle unsupported animal types (if any)
            }
        }
    }

    // Returns the total number of animals in the shelter
    public int size() {
        return dogs.size() + cats.size(); // Sum of both queues
    }

    // Removes and returns the oldest dog
    public Dog dequeueDogs() {
        return dogs.poll(); // Remove and return the first dog in the queue
    }

    // Returns the oldest dog without removing it
    public Dog peekDogs() {
        return dogs.peek(); // Return the first dog in the queue
    }

    // Removes and returns the oldest cat
    public Cat dequeueCats() {
        return cats.poll(); // Remove and return the first cat in the queue
    }

    // Returns the oldest cat without removing it
    public Cat peekCats() {
        return cats.peek(); // Return the first cat in the queue
    }

    // Removes and returns the oldest animal (dog or cat)
    public Animal dequeueAny() {
        if (dogs.isEmpty()) { // If no dogs, dequeue from cats
            return dequeueCats();
        } else if (cats.isEmpty()) { // If no cats, dequeue from dogs
            return dequeueDogs();
        }

        Dog dog = dogs.peek(); // Get the oldest dog
        Cat cat = cats.peek(); // Get the oldest cat

        // Compare their orders to find the oldest animal
        if (dog.isOlderThan(cat)) {
            return dequeueDogs(); // Dog is older
        } else {
            return dequeueCats(); // Cat is older
        }
    }

    // Returns the oldest animal without removing it
    public Animal peek() {
        if (dogs.isEmpty()) { // If no dogs, peek at cats
            return peekCats();
        } else if (cats.isEmpty()) { // If no cats, peek at dogs
            return peekDogs();
        }

        Dog dog = dogs.peek(); // Get the oldest dog
        Cat cat = cats.peek(); // Get the oldest cat

        // Compare their orders to find the oldest animal
        if (dog.isOlderThan(cat)) {
            return peekDogs(); // Dog is older
        } else {
            return peekCats(); // Cat is older
        }
    }
}
