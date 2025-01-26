package stack.array;

public class Stack {
    int[] arr;
    int topOfStack;

    public Stack(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("The Stack is created with size of: " + size);
    }

    // isEmpty
    public boolean isEmpty() {
        return topOfStack == -1;
    }

    // isFull
    public boolean isFull() {
        return topOfStack == arr.length - 1;
    }

    // Push
    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is full.");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("The value is inserted successfully.");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty!");
            return 0;
        } else {
            int topStack = arr[topOfStack];
            topOfStack--;
            return topStack;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty!");
            return 0;
        } else {
            return arr[topOfStack];
        }
    }

    public void deleteStack() {
        arr = null;
        System.out.println("The stack is successfully deleted.");
    }

    public static void main(String[] args) {
        Stack newStack = new Stack(4);
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        newStack.push(5);
        int popValue = newStack.pop();
        System.out.println(popValue);
        int peekValue = newStack.peek();
        System.out.println(peekValue);
        newStack.deleteStack();

    }


}
