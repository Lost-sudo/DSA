package doublylinkedlist;

// Main class to represent and manipulate a Doubly Linked List (DLL)
public class DoublyLinkedList {

    // Inner class to define a Doubly Linked List Node
    public static class Doubly {
        public int value; // The value stored in the node
        public Doubly next; // Reference to the next node
        public Doubly prev; // Reference to the previous node
    }

    // Head and Tail references for the DLL
    Doubly head;
    Doubly tail;
    int size; // Number of nodes in the DLL

    /**
     * Creates a new Doubly Linked List with a single node.
     * @param nodeValue The value of the first node.
     * @return The head of the created DLL.
     */
    public Doubly createDLL(int nodeValue) {
        head = new Doubly();
        Doubly newNode = new Doubly();
        newNode.value = nodeValue;
        newNode.next = null;
        newNode.prev = null;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    /**
     * Inserts a new node into the DLL at a specified location.
     * @param nodeValue The value of the new node.
     * @param location The position where the node should be inserted.
     */
    public void insertDLL(int nodeValue, int location) {
        Doubly newNode = new Doubly();
        newNode.value = nodeValue;

        if (head == null) { // Case 1: If the list is empty
            createDLL(nodeValue);
            return;
        } else if (location == 0) { // Case 2: Insert at the beginning
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) { // Case 3: Insert at the end
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else { // Case 4: Insert at a specific location
            Doubly tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    /**
     * Traverses the DLL from head to tail and prints the values of nodes.
     */
    public void traverseDLL() {
        if (head != null) {
            Doubly tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("The DLL does not exist!");
        }
        System.out.println();
    }

    /**
     * Traverses the DLL in reverse from tail to head and prints the values of nodes.
     */
    public void reverseTraverseDLL() {
        if (tail != null) {
            Doubly tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }
        } else {
            System.out.println("The DLL does not exist!");
        }
        System.out.println();
    }

    /**
     * Searches for a node with a specific value in the DLL.
     * @param nodeValue The value to search for.
     * @return True if the value exists, false otherwise.
     */
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Doubly tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("The value is found at location: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("The value does not exist in the DLL!");
        return false;
    }

    /**
     * Deletes a node from the DLL at a specific location.
     * @param location The position of the node to be deleted.
     */
    public void deleteNodeDLL(int location) {
        if (head == null) {
            System.out.println("The DLL does not exist!");
            return;
        } else if (location == 0) { // Delete the first node
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else if (location >= size - 1) { // Delete the last node
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        } else { // Delete a node in the middle
            Doubly tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
        }
        size--;
    }

    /**
     * Deletes the entire Doubly Linked List.
     */
    public void deleteDLL() {
        Doubly tempNode = head;
        while (tempNode != null) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        size = 0;
        System.out.println("The DLL has been successfully deleted!");
    }

    /**
     * Main method to demonstrate the Doubly Linked List operations.
     */
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Create a DLL with the first node having value 1
        dll.createDLL(1);

        // Insert additional nodes into the DLL
        dll.insertDLL(2, 1); // Insert 2 at the end
        dll.insertDLL(3, 2); // Insert 3 at the end

        // Traverse the DLL
        System.out.println("Traversing DLL:");
        dll.traverseDLL();

        // Reverse traverse the DLL
        System.out.println("Reverse Traversing DLL:");
        dll.reverseTraverseDLL();

        // Search for a node
        System.out.println("Searching for value 2:");
        dll.searchNode(2);
        System.out.println("Searching for value 5:");
        dll.searchNode(5);

        // Delete a node
        System.out.println("Deleting node at location 3:");
        dll.deleteNodeDLL(3);
        dll.traverseDLL();

        // Delete the entire DLL
        System.out.println("Deleting entire DLL:");
        dll.deleteDLL();
        dll.traverseDLL();
    }
}
