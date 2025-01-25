package circulardoublylinkedlist;

public class CircularDoublyLinkedList {

    // Node class to represent each element in the list
    static class CircularDoublyNode {
        public int value;
        public CircularDoublyNode next;
        public CircularDoublyNode prev;
    }

    // Circular Doubly Linked List class
    static class CircularDoublyLL {
        public CircularDoublyNode head;
        public CircularDoublyNode tail;
        public int size;

        // Create a new Circular Doubly Linked List
        public CircularDoublyNode createCDLL(int nodeValue) {
            CircularDoublyNode newNode = new CircularDoublyNode();
            newNode.value = nodeValue;
            newNode.next = newNode;
            newNode.prev = newNode;
            head = tail = newNode;
            size = 1;
            return head;
        }

        // Insert a node into the CDLL at a specific location
        public void insertCDLL(int nodeValue, int location) {
            CircularDoublyNode newNode = new CircularDoublyNode();
            newNode.value = nodeValue;

            if (head == null) {
                createCDLL(nodeValue);
                return;
            }

            if (location == 0) { // Insert at the beginning
                newNode.next = head;
                newNode.prev = tail;
                head.prev = newNode;
                tail.next = newNode;
                head = newNode;
            } else if (location >= size) { // Insert at the end
                newNode.next = head;
                newNode.prev = tail;
                tail.next = newNode;
                head.prev = newNode;
                tail = newNode;
            } else { // Insert at a specific position
                CircularDoublyNode tempNode = head;
                for (int i = 0; i < location - 1; i++) {
                    tempNode = tempNode.next;
                }
                newNode.next = tempNode.next;
                newNode.prev = tempNode;
                tempNode.next.prev = newNode;
                tempNode.next = newNode;
            }
            size++;
        }

        // Traverse and print the CDLL in forward order
        public void traverseCDLL() {
            if (head != null) {
                CircularDoublyNode tempNode = head;
                for (int i = 0; i < size; i++) {
                    System.out.print(tempNode.value);
                    if (i != size - 1) {
                        System.out.print(" -> ");
                    }
                    tempNode = tempNode.next;
                }
                System.out.println();
            } else {
                System.out.println("The CDLL does not exist.");
            }
        }

        // Traverse and print the CDLL in reverse order
        public void reverseTraverseCDLL() {
            if (head != null) {
                CircularDoublyNode tempNode = tail;
                for (int i = 0; i < size; i++) {
                    System.out.print(tempNode.value);
                    if (i != size - 1) {
                        System.out.print(" <- ");
                    }
                    tempNode = tempNode.prev;
                }
                System.out.println();
            } else {
                System.out.println("The CDLL does not exist.");
            }
        }

        // Search for a node in the CDLL
        public boolean searchNode(int nodeValue) {
            if (head != null) {
                CircularDoublyNode tempNode = head;
                for (int i = 0; i < size; i++) {
                    if (tempNode.value == nodeValue) {
                        System.out.println("The node is found at location: " + i);
                        return true;
                    }
                    tempNode = tempNode.next;
                }
            } else {
                System.out.println("The CDLL does not exist.");
                return false;
            }
            System.out.println("The node is not found in the CDLL.");
            return false;
        }

        // Delete a node from the CDLL at a specific location
        public void deleteNode(int location) {
            if (head == null) {
                System.out.println("The CDLL does not exist!");
                return;
            }

            if (location == 0) { // Delete the first node
                if (size == 1) { // If there's only one node
                    head = tail = null;
                } else {
                    head = head.next;
                    head.prev = tail;
                    tail.next = head;
                }
            } else if (location >= size - 1) { // Delete the last node
                if (size == 1) {
                    head = tail = null;
                } else {
                    tail = tail.prev;
                    tail.next = head;
                    head.prev = tail;
                }
            } else { // Delete a node at a specific position
                CircularDoublyNode tempNode = head;
                for (int i = 0; i < location - 1; i++) {
                    tempNode = tempNode.next;
                }
                tempNode.next = tempNode.next.next;
                tempNode.next.prev = tempNode;
            }
            size--;
        }

        // Delete the entire CDLL
        public void deleteCDLL() {
            if (head != null) {
                head = null;
                tail = null;
                size = 0;
                System.out.println("The CDLL has been successfully deleted.");
            } else {
                System.out.println("The CDLL does not exist.");
            }
        }
    }

    // Main method for testing the Circular Doubly Linked List
    public static void main(String[] args) {
        CircularDoublyLL cdll = new CircularDoublyLL();
        cdll.createCDLL(1);
        cdll.insertCDLL(2, 0);
        cdll.insertCDLL(3, 5);
        cdll.insertCDLL(4, 2);

        System.out.println("Traversal in forward order:");
        cdll.traverseCDLL();

        System.out.println("Traversal in reverse order:");
        cdll.reverseTraverseCDLL();

        System.out.println("Search for node with value 4:");
        cdll.searchNode(4);

        System.out.println("Delete node at position 1:");
        cdll.deleteNode(1);
        cdll.traverseCDLL();

        System.out.println("Reverse traversal after deletion:");
        cdll.reverseTraverseCDLL();

        System.out.println("Delete the entire CDLL:");
        cdll.deleteCDLL();
        cdll.traverseCDLL();
    }
}

