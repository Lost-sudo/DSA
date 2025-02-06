package tree.BinaryTree.ArrayBinaryTree;

import java.util.Objects;

public class BinaryTree {
    String[] binaryArray;
    int lastUsedIndex;

    public BinaryTree(int size) {
        binaryArray = new String[size + 1];
        this.lastUsedIndex = 0;
        System.out.println("The blank Binary Tree has been created.");
    }

    // isFull
    boolean isFull() {
        return (binaryArray.length - 1) == lastUsedIndex;
    }

    // Insert Method
    void insert(String value) {
        if (!isFull()) {
            binaryArray[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println("The value " + value + " has been inserted.");
        } else {
            System.out.println("The Binary Tree is full.");
        }
    }

    // PreOrder Traversal
    public void preOrder(int index) {
        if (index > lastUsedIndex) return;


        System.out.print(binaryArray[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    // InOrder Traversal
    public void inOrder(int index) {
        if (index > lastUsedIndex) return;

        inOrder(index * 2);
        System.out.print(binaryArray[index] + " ");
        inOrder(index * 2 + 1);
    }

    // PostOrder Traversal
    public void postOrder(int index) {
        if (index > lastUsedIndex) return;

        postOrder(index * 2);
        postOrder(index * 2 + 1);
        System.out.print(binaryArray[index] + " ");
    }

    // LevelOrder Traversal
    public void levelOrder() {
       if (binaryArray == null) {
           System.out.println("The Binary Tree Does not exist!");
           return;
       } else {
           for (int i = 1; i <= lastUsedIndex; i++) {
               System.out.print(binaryArray[i] + " ");
           }
       }
    }

    // Search Method
    public int searchValue(String value) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (Objects.equals(binaryArray[i], value)) {
                System.out.println("The value is found at index: " + i);
                return i;
            }
        }
        System.out.println("The value does not exist in the Tree.");
        return -1;
    }

    // Delete Method
    public void deleteValue(String value) {
        int location = searchValue(value);
        if (location == -1) {
            return;
        } else {
            binaryArray[location] = binaryArray[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("The value successfully deleted.");
        }
    }

    // Delete Binary Tree
    void deleteBinaryTree() {
        if (binaryArray == null) {
            System.out.println("The Tree does not exist");
            return;
        } else {
            binaryArray = null;
        }

    }
}
