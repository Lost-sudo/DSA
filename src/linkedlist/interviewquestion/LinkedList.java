package linkedlist.interviewquestion;

public class LinkedList {

    // Inner class representing a node in the linked list
    public static class Node {
        int value; // Value of the node
        Node next; // Reference to the next node

        // Default constructor
        Node() {}

        // Constructor with a value parameter
        Node(int value) {
            this.value = value; // Assign value
            this.next = null;   // Initialize next to null
        }
    }

    Node head; // Reference to the head of the linked list
    Node tail; // Reference to the tail of the linked list
    int size;  // Size of the linked list (number of nodes)

    // Creates a new linked list with a single node
    public void createSinglyLinkedList(int nodeValue) {
        Node newNode = new Node(nodeValue); // Create a new node with the given value
        head = tail = newNode; // Both head and tail point to this single node
        size = 1; // Set the size to 1
    }

    // Inserts a new node with the given value into the linked list
    public void insertNode(int nodeValue) {
        if (head == null) { // If the linked list doesn't exist
            createSinglyLinkedList(nodeValue); // Create a new linked list
            return;
        }
        Node newNode = new Node(nodeValue); // Create a new node
        tail.next = newNode; // Link the current tail to the new node
        tail = newNode;      // Update the tail to the new node
        size++;              // Increment the size of the linked list
    }

    // Traverses the linked list and prints its elements
    public void traverseLinkedList() {
        if (head == null) { // If the list is empty
            System.out.println("The Linked List does not exist");
        } else {
            Node currentNode = head; // Start from the head
            for (int i = 0; i < size; i++) { // Iterate through the linked list
                System.out.print(currentNode.value); // Print the value of the current node
                if (i != size - 1) { // If not the last node
                    System.out.print(" -> "); // Print an arrow
                }
                currentNode = currentNode.next; // Move to the next node
            }
        }
    }

    public static void main(String[] args) {
        LinkedList newLinkedList = new LinkedList(); // Create a new linked list instance
        Question newQuestion = new Question(); // Create a new instance of the `Question` class

        // Question 1: Delete duplicates
        System.out.println("Question 1");
        newLinkedList.insertNode(2);
        newLinkedList.insertNode(3);
        newLinkedList.insertNode(4);
        newLinkedList.insertNode(3);
        newLinkedList.insertNode(5);
        newQuestion.deleteDups(newLinkedList); // Remove duplicates
        newLinkedList.traverseLinkedList(); // Print the updated linked list
        System.out.println();

        // Question 2: Find the nth node from the end
        System.out.println("Question 2");
        Node n = newQuestion.nthToLast(newLinkedList, 3); // Find the 3rd node from the end
        System.out.println(n.value); // Print the value of the found node
        System.out.println();

        // Question 3: Partition the linked list
        System.out.println("Question 3");
        LinkedList t = newQuestion.partition(newLinkedList, 3); // Partition the list around value 3
        t.traverseLinkedList(); // Print the partitioned list
        System.out.println();

        // Question 4: Sum two linked lists
        LinkedList newLinkedList2 = new LinkedList();
        newLinkedList2.insertNode(7);
        newLinkedList2.insertNode(1);
        newLinkedList2.insertNode(6);

        System.out.println("Question 4");
        LinkedList sumList = newQuestion.sumList(newLinkedList, newLinkedList2); // Add the two linked lists
        sumList.traverseLinkedList(); // Print the resulting list

        // Add common nodes for intersection
        newQuestion.addSameNode(newLinkedList, newLinkedList2, 7);
        newQuestion.addSameNode(newLinkedList, newLinkedList2, 2);
        newQuestion.addSameNode(newLinkedList, newLinkedList2, 1);
        Node inter = newQuestion.findIntersection(newLinkedList, newLinkedList2); // Find the intersection
        System.out.println(inter.value); // Print the value of the intersection node
    }
}
