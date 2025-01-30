package queue.interviewquestions.animalshelter;

public abstract class Animal {
    private int order; // Tracks the order of arrival for FIFO management
    protected String name; // The name of the animal

    public Animal(String n) {
        name = n; // Initialize the animal's name
    }

    // Abstract method to get the animal's name (implemented by subclasses)
    public abstract String name();

    // Sets the order of the animal (used for comparison)
    public void setOrder(int ord) {
        order = ord;
    }

    // Returns the order of the animal
    public int getOrder() {
        return order;
    }

    // Checks if this animal is older than another animal
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder(); // Smaller order means older
    }
}
