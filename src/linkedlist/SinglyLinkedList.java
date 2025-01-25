package linkedlist; // Declares the package where this class resides.

public class SinglyLinkedList { // Defines the main class for the singly linked list.

    // Inner static class representing a node in the linked list.
    public static class Node {
        int value; // Stores the value of the node.
        Node next; // Reference to the next node in the list.

        // Constructor to initialize a node with a value.
        Node(int value) {
            this.value = value; // Sets the node's value.
            this.next = null; // Initially, the node does not point to any other node.
        }
    }

    // Fields to represent the linked list.
    private Node head; // Points to the first node in the list.
    private Node tail; // Points to the last node in the list.
    private int size;  // Tracks the number of nodes in the list.

    // Method to create a new singly linked list with a single node.
    public void createSinglyLinkedList(int nodeValue) {
        Node newNode = new Node(nodeValue); // Creates a new node with the given value.
        head = tail = newNode; // Sets both head and tail to the new node since it is the only node.
        size = 1; // Initializes the size of the list to 1.
    }

    // Method to insert a new node at a specific location in the list.
    public void insertInSinglyLinkedList(int nodeValue, int location) {
        Node newNode = new Node(nodeValue); // Creates a new node with the given value.
        if (location == 0) { // If location is 0, insert the node at the beginning.
            newNode.next = head; // Link the new node to the current head.
            head = newNode; // Update the head to the new node.
        } else if (location >= size) { // If location is greater than or equal to size, insert at the end.
            tail.next = newNode; // Link the current tail to the new node.
            tail = newNode; // Update the tail to the new node.
        } else { // Insert the node at a specific position in the middle.
            Node tempNode = head; // Start from the head.
            for (int i = 0; i < location - 1; i++) { // Traverse to the node just before the target location.
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next; // Link the new node to the next node at the target position.
            tempNode.next = newNode; // Link the previous node to the new node.
        }
        size++; // Increment the size of the list.
    }

    // Method to traverse and print the linked list.
    public void traverseSinglyLinkedList() {
        if (head == null) { // If the list is empty.
            System.out.println("The Singly Linked List does not exist");
        } else { // If the list is not empty.
            Node tempNode = head; // Start from the head.
            while (tempNode != null) { // Traverse until the end of the list.
                System.out.print(tempNode.value); // Print the value of the current node.
                if (tempNode.next != null) System.out.print(" -> "); // Print an arrow if there's a next node.
                tempNode = tempNode.next; // Move to the next node.
            }
            System.out.println(); // Print a new line at the end.
        }
    }

    // Method to search for a node by its value.
    public void searchNode(int nodeValue) {
        Node tempNode = head; // Start from the head.
        while (tempNode != null) { // Traverse the list.
            if (tempNode.value == nodeValue) { // Check if the current node's value matches the search value.
                System.out.println("Node found with value: " + nodeValue);
                return; // Return true if the node is found.
            }
            tempNode = tempNode.next; // Move to the next node.
        }
        System.out.println("Node not found!"); // If traversal is complete and no match is found.
    }

    // Method to delete a node at a specific location.
    public void deleteNode(int location) {
        if (head == null) { // If the list is empty.
            System.out.println("The Singly Linked List does not exist");
            return;
        }
        if (location == 0) { // If the node to delete is at the beginning.
            head = head.next; // Update the head to the next node.
            if (head == null) tail = null; // If the list is now empty, update the tail to null.
        } else { // If the node to delete is at a specific location.
            Node tempNode = head; // Start from the head.
            for (int i = 0; i < location - 1 && tempNode != null; i++) { // Traverse to the node just before the target location.
                tempNode = tempNode.next;
            }
            if (tempNode != null && tempNode.next != null) { // If the target node exists.
                tempNode.next = tempNode.next.next; // Skip the target node by linking to the next node.
                if (tempNode.next == null) tail = tempNode; // If the deleted node was the tail, update the tail.
            }
        }
        size--; // Decrease the size of the list.
    }

    // Method to delete the entire linked list.
    public void deleteSinglyLinkedList() {
        head = tail = null; // Set both head and tail to null.
        size = 0; // Reset the size to 0.
        System.out.println("The Singly Linked List has been deleted.");
    }

    // Main method to test the singly linked list operations.
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList(); // Create a new linked list instance.

        // Create a linked list with an initial node value of 5.
        sll.createSinglyLinkedList(5);

        // Insert nodes at different positions.
        sll.insertInSinglyLinkedList(6, 1); // Insert at position 1.
        sll.insertInSinglyLinkedList(7, 1); // Insert at position 1 (shifts existing node).
        sll.insertInSinglyLinkedList(8, 3); // Insert at position 3 (end of the list).

        sll.traverseSinglyLinkedList(); // Print the list: 5 -> 7 -> 6 -> 8.

        sll.searchNode(6); // Search for the node with value 6 (exists in the list).

        sll.deleteNode(2); // Delete the node at position 2 (value 6).
        sll.traverseSinglyLinkedList(); // Print the list: 5 -> 7 -> 8.

        sll.deleteSinglyLinkedList(); // Delete the entire list.
        sll.traverseSinglyLinkedList(); // Attempt to print an empty list.
    }
}
