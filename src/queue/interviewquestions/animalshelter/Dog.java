package queue.interviewquestions.animalshelter;

// Subclass for Dog
public class Dog extends Animal {

    public Dog(String n) {
        super(n); // Pass the name to the base class constructor
    }

    @Override
    public String name() {
        return "Dog: " + name; // Provide a specific implementation for dogs
    }
}