package stack.interviewquestions;

public class ThreeInOne {

    // Number of stacks in the array (fixed at 3)
    private final int numberOfStacks = 3;
    // Capacity of each individual stack
    private final int stackCapacity;
    // Single array to hold all three stacks
    private final int[] values;
    // Array to track size of each stack
    private final int[] sizes;

    public ThreeInOne(int stackSize) {
        // Set the capacity for each stack
        stackCapacity = stackSize;
        // Create array with space for all three stacks
        values = new int[stackSize * numberOfStacks];
        // Initialize size tracker for each stack
        sizes = new int[numberOfStacks];
    }

    // Check if a specific stack is full
    public boolean isFull(int stackNum) {
        // Validate stack number
        if (stackNum < 0 || stackNum >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        // Stack is full if its size equals capacity
        return sizes[stackNum] == stackCapacity;
    }

    // Check if a specific stack is empty
    public boolean isEmpty(int stackNum) {
        // Validate stack number
        if (stackNum < 0 || stackNum >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        // Stack is empty if its size is 0
        return sizes[stackNum] == 0;
    }

    // Calculate the index of the top element for a specific stack
    private int indexOfTop(int stackNum) {
        // Calculate starting position of this stack in array
        int offset = stackNum * stackCapacity;
        // Get current size of this stack
        int size = sizes[stackNum];
        // Return index of top element
        return offset + size - 1;
    }

    // Add element to specific stack
    public void push(int stackNum, int value) {
        if (stackNum < 0 || stackNum >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        if (isFull(stackNum)) {
            System.out.println("The stack is full.");
            throw new IllegalArgumentException("The stack is full!");
        } else {
            // Increment size and add value at top
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
            System.out.println("The value is successfully inserted.");
        }
    }

    // Remove and return top element from specific stack
    public int pop(int stackNum) {
        if (stackNum < 0 || stackNum >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        if (isEmpty(stackNum)) {
            System.out.println("Stack is empty.");
            throw new IllegalArgumentException("The stack is empty!");
        }
        // Get top index and value
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        // Clear value and decrease size
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    /**
     * Returns the top element of specified stack without removing it
     *
     * @param stackNum Stack number (0-2)
     * @return Top element value
     * @throws IllegalArgumentException if stack number is invalid or stack is
     * empty
     */
    public int peek(int stackNum) {
        // Validate stack number (0-2)
        if (stackNum < 0 || stackNum >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        // Check if stack is empty
        if (isEmpty(stackNum)) {
            System.out.println("The stack is empty");
            throw new IllegalArgumentException("The stack is empty!");
        }
        // Return value at top index without removing it
        return values[indexOfTop(stackNum)];
    }

    /**
     * Prints elements of specified stack from top to bottom Format: element1 ->
     * element2 -> element3
     *
     * @param stackNum Stack number (0-2)
     */
    public void traverseStack(int stackNum) {
        // Validate stack number
        if (stackNum < 0 || stackNum >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        if (isEmpty(stackNum)) {
            System.out.println("The stack is empty!");
        } else {
            // Get top index of stack
            int topIndex = indexOfTop(stackNum);
            // Print elements from top to bottom with arrow separators
            for (int i = topIndex; i >= stackNum * stackCapacity; i--) {
                System.out.print(values[i]);
                // Add arrow separator except for last element
                if (i != stackNum * stackCapacity) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints elements of all three stacks Calls traverseStack for each stack
     * (0-2)
     */
    public void traverseAllStacks() {
        for (int i = 0; i < numberOfStacks; i++) {
            traverseStack(i);
        }
    }

    public static void main(String[] args) {
        ThreeInOne newStack = new ThreeInOne(3);
        newStack.push(0, 1);
        newStack.push(0, 2);
        newStack.push(0, 3);
        newStack.push(1, 4);
        newStack.push(1, 5);
        newStack.push(1, 6);
        newStack.push(2, 7);
        newStack.push(2, 8);
        newStack.push(2, 9);
        newStack.traverseStack(0);
        newStack.traverseStack(1);
        newStack.traverseStack(2);
        // newStack.traverseAllStacks();
        System.out.println(newStack.pop(0));
        System.out.println(newStack.pop(1));
        System.out.println(newStack.pop(2));
        newStack.traverseStack(0);
        newStack.traverseStack(1);
        newStack.traverseStack(2);
        System.out.println(newStack.peek(0));
        System.out.println(newStack.peek(1));
        System.out.println(newStack.peek(2));
    }
}