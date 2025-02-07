package BinarySearchTree;

import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Insert Method
    void insert(int value) {
        root = insert(root, value);
    }

    // Helper Method
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println("The value successfully inserted");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    // PreOrder Traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // InOrder Traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // PostOrder Traversal
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // LevelOrder Traversal
    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }

            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    // Search Node
    BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("The value does not exist in this BST.");
            return null;
        } else if (node.value == value) {
            System.out.println("The value: " + value + " found in the BST.");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // Delete Method
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("The value not found in BST.");
            return null;
        }

        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BinaryNode minNodeForRight = minimum(root.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    // Minimum node
    public static BinaryNode minimum(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimum(root.left);
        }
    }

    // Delete BST
    void deleteBST() {
        root = null;
        System.out.println("The BST has been successfully deleted.");
    }
}
