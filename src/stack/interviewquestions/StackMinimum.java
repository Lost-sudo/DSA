package stack.interviewquestions;

public class StackMinimum {
    Node top;
    Node min;

    public StackMinimum() {
        this.top = null;
        this.min = null;
    }

    public int min() {
        return min.value;
    }

    public void push(int value) {
        if (min == null) {
            min = new Node(value, min);
        } else if (min.value < value) {
            min = new Node(min.value, min);
        } else {
            min = new Node(value, min);
        }

        top = new Node(value, top);
    }

    public int pop() {
        min = min.next;
        int result = top.value;
        top = top.next;

        return result;
    }

    public static void main(String[] args) {
        StackMinimum newStack = new StackMinimum();
        newStack.push(3);
        newStack.push(2);
        newStack.push(5);
        newStack.push(1);
        System.out.println("Minimum Value: " + newStack.min());
        newStack.pop();
        System.out.println("Minimum Value after popped: " + newStack.min());

    }
}

class Node {
    int value;
    Node next;

    public  Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}