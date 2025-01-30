package queue.interviewquestions.animalshelter;

// Subclass for Cat
public class Cat extends Animal {

    public Cat(String n) {
        super(n); // Pass the name to the base class constructor
    }

    @Override
    public String name() {
        return "Cat: " + name; // Provide a specific implementation for cats
    }
}