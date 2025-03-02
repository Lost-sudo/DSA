package BinaryHeap;

import java.util.Objects;

public class BinaryHeap {
    int[] arr;
    int sizeOfTree;

    public BinaryHeap(int size) {
        this.arr = new int[size+1];
        this.sizeOfTree = 0;
        System.out.println("The Binary Heap has been created!");
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Binary Heap is empty!");
            return null;
        }
        return arr[1];
    }

    public void levelOrderTraversal() {
        if (isEmpty()) {
            System.out.println("The Binary Heap is empty!");
        }
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(arr[i]);
            if (i != sizeOfTree) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    // Insert Method
    public void insert(int value, String heapType) {
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heapType);
        System.out.println("The value has: " + value + " successfully inserted");
    }

    // Extract Method
    public int extractHeadOfBH(String heapType) {
        if (isEmpty()) {
            return -1;
        } else {
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }

    public void deleteBH() {
        arr = null;
        System.out.println("The Binary Heap has been successfully deleted.");
    }

    // Heapify for Insert
    private void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;
        if (index <= 1) return;
        if (Objects.equals(heapType, "Min")) {
            if (arr[index] < arr[parent]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        } else if (Objects.equals(heapType, "Max")) {
            if (arr[index] > arr[parent]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }

        heapifyBottomToTop(parent, heapType);
    }

    // HeapifyTopToBottom
    private void heapifyTopToBottom(int index, String heapType) {
        int left = index * 2;
        int right = index + 2 + 1;
        int swapChild = 0;
        if (sizeOfTree < left) return;
        if (Objects.equals(heapType, "Max")) {
            if (sizeOfTree == left) {
                if (arr[index] < arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            } else {
                if (arr[left] > arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] < arr[swapChild]) {
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        } else if (Objects.equals(heapType, "Min")) {
            if (sizeOfTree == left) {
                if (arr[index] > arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            } else {
                if (arr[left] < arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] > arr[swapChild]) {
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }
        heapifyTopToBottom(swapChild, heapType);
    }


    public int sizeOfBP() {
        return sizeOfTree;
    }

    public boolean isEmpty() {
        return sizeOfTree == 0;
    }

}
