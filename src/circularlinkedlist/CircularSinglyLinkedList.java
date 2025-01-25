package circularlinkedlist;

public class CircularSinglyLinkedList {

    // Represents a node in the circular linked list
    static class Node {
        public int value; // Holds the value/data of the node
        public Node next; // Reference to the next node in the list
    }

    private Node head; // Points to the first node in the list
    private Node tail; // Points to the last node in the list
    private int size;  // Tracks the size of the list

    // Creates a new Circular Linked List with a single node
    public Node createCLL(int nodeValue) {
        Node node = new Node(); // Create a new node
        node.value = nodeValue; // Set the value of the node
        node.next = node; // Point the node to itself (circular reference)
        head = node; // Head and tail point to the new node
        tail = node;
        size = 1; // Set size to 1 as we have one node
        return head; // Return the head node
    }

    // Inserts a node at a specific location
    public void insertCSLL(int nodeValue, int location) {
        Node node = new Node(); // Create a new node
        node.value = nodeValue; // Set the value of the node
        if (head == null) { // If list is empty, create a new one
            createCLL(nodeValue);
            return;
        } else if (location == 0) { // Insert at the beginning
            node.next = head; // Link the new node to the head
            head = node; // Update the head
            tail.next = head; // Maintain circular connection
        } else if (location >= size) { // Insert at the end
            tail.next = node; // Link the current tail to the new node
            tail = node; // Update the tail
            tail.next = head; // Maintain circular connection
        } else { // Insert at a specific position
            Node tempNode = head; // Start from the head
            int index = 0;
            while (index < location - 1) { // Traverse to the desired location
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next; // Point new node to the next node
            tempNode.next = node; // Link the previous node to the new node
        }
        size++; // Increment the size
    }

    // Traverses the Circular Singly Linked List and prints its elements
    public void traverseCSLL() {
        if (head != null) { // If the list exists
            Node tempNode = head; // Start from the head
            for (int i = 0; i < size; i++) { // Loop through all nodes
                System.out.print(tempNode.value); // Print the value
                if (i != size - 1) { // Add arrow for separation
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next; // Move to the next node
            }
        } else {
            System.out.println("CSLL does not exist.");
        }
        System.out.println(); // Add a newline
    }

    // Searches for a node with a given value
    public boolean searchNode(int nodeValue) {
        if (head != null) { // If the list exists
            Node tempNode = head; // Start from the head
            for (int i = 0; i < size; i++) { // Loop through all nodes
                if (tempNode.value == nodeValue) { // If value matches
                    System.out.println("Found node at location: " + i);
                    return true; // Value found
                }
                tempNode = tempNode.next; // Move to the next node
            }
        } else {
            System.out.println("CSLL does not exist.");
            return false; // Value not found
        }
        System.out.println("The value does not exist in the CSLL.");
        return false; // Value not found
    }

    // Deletes a node at a specific location
    public void deleteNode(int location) {
        if (location < 0 || location >= size) { // Bounds checking
            System.out.println("Invalid location! Please provide a location between 0 and " + (size - 1));
            return;
        }

        if (location == 0) { // Delete the first node
            head = head.next; // Move head to the next node
            tail.next = head; // Maintain circular connection
            size--;
            if (size == 0) { // Reset head and tail if the list becomes empty
                head = null;
                tail = null;
            }
        } else if (location == size - 1) { // Delete the last node
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) { // Traverse to the second last node
                tempNode = tempNode.next;
            }
            tempNode.next = head; // Link second last node to the head
            tail = tempNode; // Update tail
            size--;
        } else { // Delete a node in the middle
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) { // Traverse to the previous node
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next; // Bypass the node to delete
            size--;
        }
        System.out.println("Node at location " + location + " has been deleted.");
    }

    // Deletes the entire Circular Singly Linked List
    public void deleteCSLL() {
        if (head == null) {
            System.out.println("CSLL does not exist.");
        } else {
            head = null; // Clear the head
            tail.next = null; // Break the circular reference
            tail = null; // Clear the tail
            size = 0; // Reset size
            System.out.println("CSLL successfully deleted.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCLL(5); // Create the list with initial value 5
        csll.insertCSLL(4, 0); // Insert value 4 at the beginning
        csll.insertCSLL(3, 1); // Insert value 3 at position 1
        csll.insertCSLL(2, 2); // Insert value 2 at position 2
        System.out.println("Head value: " + csll.head.value); // Print the value of the head node
        csll.traverseCSLL(); // Print the entire list
        csll.searchNode(4); // Search for the value 4 in the list
        csll.deleteNode(1); // Delete the node at position 1
        csll.traverseCSLL(); // Print the updated list
        csll.deleteCSLL(); // Delete the entire CSLL
        csll.traverseCSLL(); // Verify deletion
    }
}
