package stack.interviewquestions;

import java.util.EmptyStackException;
import java.util.ArrayList;

public class StackOfPlates {
    ArrayList<Stack> stacks = new ArrayList<>(); // List of individual stacks
    public int capacity; // Capacity of each stack

    // Constructor to initialize SetOfStacks with a stack capacity
    public StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    // Helper method to get the last stack in the list
    public Stack getLastStack() {
        if (stacks.isEmpty()) {
            return null; // Return null if there are no stacks
        }
        return stacks.getLast(); // Return the last stack
    }

    // Pushes a value onto the SetOfStacks
    public void push(int v) {
        Stack last = getLastStack(); // Get the last stack
        if (last != null && !last.isFull()) {
            last.push(v); // Add to the last stack if it's not full
        } else {
            Stack stack = new Stack(capacity); // Create a new stack
            stack.push(v); // Push the value onto the new stack
            stacks.add(stack); // Add the new stack to the list
        }
    }

    // Pops a value from the SetOfStacks
    public int pop() {
        Stack last = getLastStack(); // Get the last stack
        if (last == null) {
            throw new EmptyStackException(); // Handle empty case

        }
        int result = last.pop(); // Pop the value from the last stack
        if (last.size == 0) {
            stacks.removeLast(); // Remove the stack if it's empty
        }
        return result; // Return the popped value
    }

    // Helper method to shift items between stacks
    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index); // Get the stack at the specified index
        int removeItem;
        if (removeTop) {
            removeItem = stack.pop(); // Remove the top item
        } else {
            removeItem = stack.removeBottom(); // Remove the bottom item
        }

        if (stack.size == 0) {
            stacks.remove(index); // Remove empty stacks
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false); // Recursively shift items
            stack.push(v); // Push the shifted item onto the current stack
        }
        return removeItem; // Return the removed item
    }

    // Pops a value from a specific stack in the SetOfStacks
    public int popAt(int index) {
        return leftShift(index, true); // Delegate to leftShift with removeTop=true
    }

    public static void main(String[] args) {
        StackOfPlates newStack = new StackOfPlates(3);
        // System.out.println(newStack.isFull());
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        newStack.push(5);

        System.out.println(newStack.popAt(0));
        System.out.println(newStack.popAt(0));
    }
}

class StackNode {
    public StackNode above;
    public StackNode below;
    public int value;

    public StackNode(int value) {
        this.value = value;
    }
}

class Stack {

    private final int capacity; // Maximum number of items this stack can hold
    public StackNode top;       // Points to the top node in the stack
    public StackNode bottom;    // Points to the bottom node in the stack
    public int size = 0;        // Tracks the current size of the stack

    // Constructor to create a stack with a specified capacity
    public Stack(int capacity) {
        this.capacity = capacity;
    }

    // Checks if the stack is full
    public boolean isFull() {
        return capacity == size; // Returns true if the current size equals the capacity
    }

    // Helper method to link two nodes (above and below)
    public void join(StackNode above, StackNode below) {
        if (below != null) {
            below.above = above; // Set the below node's above reference
        }
        if (above != null) {
            above.below = below; // Set the above node's below reference
        }
    }

    // Pushes a new value onto the stack
    public boolean push(int value) {
        if (size >= capacity) {
            return false; // Prevent adding items beyond the stack's capacity
        }
        size++; // Increment the stack size
        StackNode newNode = new StackNode(value); // Create a new node for the value
        if (size == 1) {
            bottom = newNode; // If it's the first node, set it as the bottom

        }
        join(newNode, top); // Link the new node to the current top
        top = newNode; // Update the top reference
        return true; // Indicate success
    }

    // Pops the value from the top of the stack
    public int pop() {
        if (top == null) {
            throw new EmptyStackException(); // Handle empty stack case
        }
        int result = top.value; // Get the value of the top node
        top = top.below; // Move the top reference down
        size--; // Decrement the size
        return result; // Return the removed value
    }

    // Removes and returns the value from the bottom of the stack
    public int removeBottom() {
        StackNode oldBottom = bottom; // Save the current bottom node
        bottom = bottom.above; // Update the bottom to the node above it
        if (bottom != null) {
            bottom.below = null; // Unlink the old bottom

        }
        size--; // Decrement the size
        return oldBottom.value; // Return the removed value
    }
}