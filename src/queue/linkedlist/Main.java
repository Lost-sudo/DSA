package queue.linkedlist;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(queue.isEmpty());
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.peek());
        queue.deleteQueue();
    }
}

class LinkedList {
    class  Node {
        public int value;
        public Node next;

        Node (int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public void createSinglyLinkedList(int nodeValue) {
        Node newNode = new Node(nodeValue);
        head = tail = newNode;
        size = 1;
    }

    public void insertInSinglyLinkedList(int nodeValue) {
        Node node = new Node(nodeValue);
        if (head == null) {
            createSinglyLinkedList(nodeValue);
            return;
        } else {
            node.next = null;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("The singly linked list does not exist!");
        } else {
            Node temporaryNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(temporaryNode.value);
                if (i != size -1 ) {
                    System.out.print(" -> ");
                }
                temporaryNode = temporaryNode.next;
            }
        }
    }

    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found a node at location " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found!");
        return false;
    }

    public void deleteOfNode() {
        if (head == null) {
            System.out.println("The SLL does not exist");
        } else {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        }
    }

    public void deleteSLL() {
        head = null;
        tail = null;
        System.out.println("The SLL deleted succesfully");
    }

}

