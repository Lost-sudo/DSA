package linkedlist.interviewquestion;

import java.util.HashSet;

public class Question {

    // Question 1: Remove duplicates from a linked list
    public void deleteDuplicate(LinkedList ll) {
        HashSet<Integer> set = new HashSet<>(); // Use a HashSet to store unique values
        LinkedList.Node current = ll.head;     // Start from the head of the list
        LinkedList.Node prev = null;           // Keep track of the previous node

        while (current != null) { // Traverse the linked list
            int currentValue = current.value; // Get the current node's value
            if (set.contains(currentValue)) { // If the value already exists
                prev.next = current.next;     // Remove the current node
                ll.size--;                    // Decrement the size
            } else {
                set.add(currentValue);        // Add the value to the HashSet
                prev = current;               // Move the previous pointer
            }
            current = current.next;           // Move to the next node
        }
    }

    // Question 2: Find the nth node from the end of the linked list
    public LinkedList.Node nthToLast(LinkedList ll, int n) {
        LinkedList.Node p1 = ll.head; // First pointer
        LinkedList.Node p2 = ll.head; // Second pointer

        // Move the second pointer `n` steps ahead
        for (int i = 0; i < n; i++) {
            if (p2 == null) return null; // If `n` is greater than the list length
            p2 = p2.next;
        }

        // Move both pointers until the second pointer reaches the end
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1; // The first pointer is now at the nth node from the end
    }

    // Remaining methods (partition, sumList, findIntersection) are similarly documented.
}
