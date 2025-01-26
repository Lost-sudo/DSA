package stack.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushes: " + stack);

        System.out.println("Top of stack: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop:" + stack);

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.clear();
        System.out.println("Stack after clearing: " + stack );
        System.out.println("Is stack empty? " + stack.isEmpty());


    }
}
