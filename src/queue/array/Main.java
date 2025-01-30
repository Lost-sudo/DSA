package queue.array;

// Main class to demonstrate the functionality of the Queue class
public class Main {
    public static void main(String[] args) {
        // Create a Queue of size 3
        Queue queue = new Queue(3);

        // Enqueue values into the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4); // This will fail as the queue is full

        // Peek the front element of the queue
        System.out.println(queue.peek()); // Output: 1

        // Check if the queue is full
        System.out.println(queue.isFull()); // Output: true

        // Check if the queue is empty
        System.out.println(queue.isEmpty()); // Output: false

        // Peek the front element again
        System.out.println(queue.peek()); // Output: 1

        // Traverse and print all elements of the queue
        queue.traverseQueue();

        // Delete the entire queue
        queue.deleteQueue();

        // Attempt to dequeue elements from the queue
        System.out.println(queue.dequeue()); // Output: The Queue is empty! -> -2147483648
        System.out.println(queue.dequeue()); // Output: The Queue is empty! -> -2147483648
        System.out.println(queue.dequeue()); // Output: The Queue is empty! -> -2147483648

        // Check if the queue is full
        System.out.println(queue.isFull()); // Output: false

        // Check if the queue is empty
        System.out.println(queue.isEmpty()); // Output: true

        // Peek the front element of the queue
        System.out.println(queue.peek()); // Output: The Queue is empty! -> -1
    }
}

// Queue class implementation using an array
class Queue {
    int[] arr; // Array to store queue elements
    int topOfQueue; // Points to the last element of the queue
    int beginningOfQueue; // Points to the first element of the queue

    // Constructor to initialize the queue with a given size
    public Queue(int size) {
        arr = new int[size]; // Initialize the array
        topOfQueue = -1; // No elements in the queue
        beginningOfQueue = -1; // No elements in the queue
        System.out.println("The Queue has been created with size: " + size);
    }

    // Check if the queue is full
    public boolean isFull() {
        return topOfQueue == arr.length - 1; // If the last index is reached, the queue is full
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return topOfQueue == -1 || beginningOfQueue == arr.length; // If no elements or all elements are dequeued
    }

    // Add an element to the queue
    public void enqueue(int value) {
        if (isFull()) { // Check if the queue is full
            System.out.println("The Queue is full.");
        } else if (isEmpty()) { // Check if the queue is empty
            beginningOfQueue = 0; // Reset beginning of queue to 0
            topOfQueue++; // Move to the next index
            arr[topOfQueue] = value; // Add the value to the queue
            System.out.println("The value " + value + " is successfully inserted in the Queue");
        } else { // If the queue has elements
            topOfQueue++; // Move to the next index
            arr[topOfQueue] = value; // Add the value to the queue
            System.out.println("The value " + value + " is successfully inserted in the Queue");
        }
    }

    // Remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) { // Check if the queue is empty
            System.out.println("The Queue is empty!");
            return Integer.MIN_VALUE; // Return a sentinel value
        } else {
            int result = arr[beginningOfQueue]; // Get the front element
            beginningOfQueue++; // Move the beginning pointer to the next element
            if (beginningOfQueue > topOfQueue) { // If the queue is now empty
                beginningOfQueue = topOfQueue - 1; // Reset pointers
            }
            return result; // Return the dequeued value
        }
    }

    // Print all elements in the queue
    public void traverseQueue() {
        for (int j : arr) { // Iterate through the array
            System.out.println(j + " "); // Print each element
        }
        System.out.println(); // Newline for better formatting
    }

    // Peek the front element of the queue
    public int peek() {
        if (!isEmpty()) { // If the queue is not empty
            return arr[beginningOfQueue]; // Return the front element
        } else { // If the queue is empty
            System.out.println("The Queue is empty!");
            return -1; // Return a sentinel value
        }
    }

    // Delete the queue
    public void deleteQueue() {
        arr = null; // Set the array reference to null
        System.out.println("The Queue has been deleted successfully!");
    }
}
