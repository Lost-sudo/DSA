package linkedlist.interviewquestion;

import java.util.HashSet;

public class Question {

    // Question 1 - Remove duplicates from the linked list
    public void deleteDups(LinkedList ll) {
        // Use a HashSet to track seen values
        HashSet<Integer> set = new HashSet<>();
        LinkedList.Node current = ll.head;
        LinkedList.Node prev = null;

        // Traverse the linked list
        while (current != null) {
            int currentValue = current.value;
            // If value already exists, skip the current node
            if (set.contains(currentValue)) {
                prev.next = current.next;
                ll.size--; // Decrease the size of the linked list
            } else {
                set.add(currentValue); // Add value to the set
                prev = current; // Update previous node
            }
            current = current.next; // Move to the next node
        }
    }

    // Question 2 - Find the nth-to-last node in the linked list
    LinkedList.Node nthToLast(LinkedList ll, int n) {
        LinkedList.Node p1 = ll.head; // Pointer 1 starts at head
        LinkedList.Node p2 = ll.head; // Pointer 2 starts at head

        // Move p2 n steps ahead
        for (int i = 0; i < n; i++) {
            if (p2 == null) {
                return null; // If n is greater than the size of the list
            }
            p2 = p2.next;
        }

        // Move both pointers until p2 reaches the end
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1; // p1 will now be the nth-to-last node
    }

    // Question 3 - Partition the linked list around a value x
    LinkedList partition(LinkedList ll, int x) {
        LinkedList.Node currentNode = ll.head; // Start at the head
        ll.tail = ll.head; // Set the tail to the head initially

        // Traverse the linked list
        while (currentNode != null) {
            LinkedList.Node next = currentNode.next; // Store the next node

            if (currentNode.value < x) {
                // Insert nodes with value < x at the head
                currentNode.next = ll.head;
                ll.head = currentNode;
            } else {
                // Insert nodes with value >= x at the tail
                ll.tail.next = currentNode;
                ll.tail = currentNode;
            }

            currentNode = next; // Move to the next node
        }

        assert ll.tail != null;
        ll.tail.next = null; // Terminate the list
        return ll;
    }

    // Question 4 - Sum two linked lists representing reversed numbers
    LinkedList sumList(LinkedList llA, LinkedList llB) {
        LinkedList.Node n1 = llA.head; // Pointer for the first list
        LinkedList.Node n2 = llB.head; // Pointer for the second list
        int carry = 0; // Initialize carry to 0

        LinkedList resultLL = new LinkedList(); // Resultant linked list

        // Traverse both lists
        while (n1 != null || n2 != null) {
            int result = carry; // Start with the carry

            if (n1 != null) {
                result += n1.value; // Add value from the first list
                n1 = n1.next; // Move to the next node
            }

            if (n2 != null) {
                result += n2.value; // Add value from the second list
                n2 = n2.next; // Move to the next node
            }

            resultLL.insertNode(result % 10); // Insert the remainder in the result list
            carry = result / 10; // Update the carry
        }

        return resultLL; // Return the resultant list
    }

    // Question 5 - Find the intersection of two linked lists
    LinkedList.Node getKthNode(LinkedList.Node head, int k) {
        LinkedList.Node current = head;

        // Move k steps forward
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }

        return current;
    }

    LinkedList.Node findIntersection(LinkedList list1, LinkedList list2) {
        // If either list is empty, there is no intersection
        if (list1.head == null || list2.head == null) return null;

        // If the tails are not the same, there is no intersection
        if (list1.tail != list2.tail) {
            return null;
        }

        // Determine the shorter and longer list
        LinkedList.Node shorter = list1.size < list2.size ? list1.head : list2.head;
        LinkedList.Node longer = list1.size >= list2.size ? list1.head : list2.head;

        // Align the longer list to the same starting point as the shorter list
        longer = getKthNode(longer, Math.abs(list1.size - list2.size));

        // Traverse both lists together to find the intersection point
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer; // Return the intersection node
    }

    // Add a common node to two linked lists
    void addSameNode(LinkedList llA, LinkedList llB, int nodeValue) {
        LinkedList.Node newNode = new LinkedList.Node(); // Create a new node
        newNode.value = nodeValue; // Set the node value

        // Attach the node to the tail of both lists
        llA.tail.next = newNode;
        llA.tail = newNode;
        llB.tail.next = newNode;
        llB.tail = newNode;
    }
}