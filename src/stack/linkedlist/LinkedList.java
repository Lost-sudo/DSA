package stack.linkedlist;

// LinkedList class definition
public class LinkedList {

    // Node class represents a single element in the linked list
    public static class Node {
        int value;   // Value of the node
        Node next;   // Reference to the next node in the list

        // Constructor to initialize a node with a given value
        Node(int value) {
            this.value = value;
            this.next = null; // Next is null by default
        }
    }

    Node head; // Points to the first node of the linked list
    Node tail; // Points to the last node of the linked list
    private int size; // Tracks the size of the linked list

    // Creates a linked list with a single node
    public void createLinkedList(int nodeValue) {
        Node newNode = new Node(nodeValue); // Create a new node
        head = tail = newNode; // Set both head and tail to the new node
        size = 1; // Initialize size to 1
    }

    // Inserts a new node at the beginning of the linked list
    public void insertLinkedList(int nodeValue) {
        Node newNode = new Node(nodeValue); // Create a new node
        newNode.next = head; // Link the new node to the current head
        head = newNode; // Update the head to the new node
        size++; // Increment the size of the list
    }

    // Traverses and prints the elements of the linked list
    public void traverseLinkedList() {
        if (head == null) { // Check if the list is empty
            System.out.println("The Singly Linked List does not exist!");
        } else {
            Node tempNode = head; // Start from the head node
            while (tempNode != null) { // Loop until the end of the list
                System.out.print(tempNode.value); // Print the value of the current node
                if (tempNode.next != null) System.out.print(" -> "); // Add an arrow if there's a next node
                tempNode = tempNode.next; // Move to the next node
            }
            System.out.println(); // New line after traversal
        }
    }

    // Deletes the node at the beginning (head) of the linked list
    public void deleteNode() {
        if (head == null) { // Check if the list is empty
            System.out.println("The Singly Linked List does not exist!");
            return;
        }
        head = head.next; // Update head to the next node
        if (head == null) tail = null; // If the list is empty after deletion, update tail
        size--; // Decrement the size of the list
    }

    public static void main(String[] args) {
        // Create a new stack object
        Stack newStack = new Stack();

        // Check if the stack is empty
        System.out.println(newStack.isEmpty()); // true

        // Push elements onto the stack
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);

        // Traverse the stack (print its elements)
        newStack.linkedList.traverseLinkedList(); // 3 -> 2 -> 1

        // Check if the stack is empty
        System.out.println(newStack.isEmpty()); // false

        // Peek at the top element of the stack
        System.out.println(newStack.peek()); // 3

        // Pop an element from the stack
        System.out.println(newStack.pop()); // 3 (removes the top)

        // Peek again to see the new top
        System.out.println(newStack.peek()); // 2

        // Traverse the stack again after popping
        newStack.linkedList.traverseLinkedList(); // 2 -> 1

        // Delete the stack
        newStack.deleteStack();
    }
}

// Stack class implementation using a linked list
class Stack {
    LinkedList linkedList; // The linked list that serves as the stack's data structure

    // Constructor to initialize the stack
    public Stack() {
        linkedList = new LinkedList(); // Create a new linked list
    }

    // Pushes a value onto the stack
    public void push(int value) {
        if (linkedList.head == null) { // If the stack is empty
            linkedList.createLinkedList(value); // Create a new linked list with the value
        } else {
            linkedList.insertLinkedList(value); // Insert the value at the head of the list
            System.out.println("Inserted " + value + " in stack");
        }
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return linkedList.head == null; // Return true if the head is null
    }

    // Pops the top value off the stack
    public int pop() {
        int result = -1; // Default value if the stack is empty
        if (isEmpty()) { // Check if the stack is empty
            System.out.println("The Stack is empty!");
        } else {
            result = linkedList.head.value; // Get the value at the top
            linkedList.deleteNode(); // Remove the top node
        }
        return result; // Return the popped value
    }

    // Peeks at the top value of the stack without removing it
    public int peek() {
        if (isEmpty()) { // Check if the stack is empty
            System.out.println("The Stack is empty!");
            return -1;
        }
        return linkedList.head.value; // Return the value at the head of the list
    }

    // Deletes the entire stack
    public void deleteStack() {
        linkedList.head = null; // Set the head to null (clear the list)
        System.out.println("Stack is deleted.");
    }
}
