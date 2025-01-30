package queue.interviewquestions.queueviastack;

import java.util.Stack;

public class QueueViaStack {

    // Two stacks to simulate the queue
    Stack<Integer> stackNewest, stackOldest;

    public QueueViaStack() {
        // Initialize the stacks
        stackNewest = new Stack<>(); // Stack for storing new elements
        stackOldest = new Stack<>(); // Stack for holding elements in FIFO order
    }

    // Returns the total number of elements in the queue
    public int size() {
        return stackNewest.size() + stackOldest.size(); // Combine sizes of both stacks
    }

    // Adds a new element to the queue
    public void enqueue(int value) {
        stackNewest.push(value); // Push the value onto the stackNewest
    }

    // Shifts elements from stackNewest to stackOldest to maintain the correct order
    private void shiftStacks() {
        // Only shift if stackOldest is empty (to avoid redundant operations)
        if (stackOldest.isEmpty()) {
            // Move all elements from stackNewest to stackOldest
            while (!stackNewest.isEmpty()) {
                int poppedOut = stackNewest.pop(); // Remove top element from stackNewest
                stackOldest.push(poppedOut); // Push it onto stackOldest (reverses the order)
            }
        }
    }

    // Removes and returns the front element of the queue
    public int dequeue() {
        shiftStacks(); // Ensure elements are in correct order for dequeuing
        return stackOldest.pop(); // Remove and return the top element from stackOldest
    }

    // Returns the front element of the queue without removing it
    public int peek() {
        shiftStacks(); // Ensure elements are in correct order for peeking
        return stackOldest.peek(); // Return the top element of stackOldest
    }
}