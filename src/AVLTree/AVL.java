package AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    BinaryNode root;

    AVL() {
        root = null;
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
    public void levelOrder() {
        if (root == null) {
            System.out.println("The AVL Tree does not exist");
            return;
        }
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


    // Search Method
    BinaryNode search(BinaryNode node, int value) {
        if (root == null) {
            System.out.println("The AVL Tree does not exist.");
            return null;
        } else if (node.value == value) {
            System.out.println("The value: " + value + " was found in the Tree.");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // Insert Method
    public void insert(int value) {
        root = insertNode(root, value);
    }


    // GetHeight Helper Method
    public int getHeight(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Rotate Right Method
    private BinaryNode rotateRight(BinaryNode disBalanceNode) {
        BinaryNode newRoot = disBalanceNode.left;
        BinaryNode temp = newRoot.right;
        newRoot.right = disBalanceNode;
        disBalanceNode.left = temp;

        disBalanceNode.height = Math.max(getHeight(disBalanceNode.left), getHeight(disBalanceNode.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

        return newRoot;
    }

    // Rotate Left Method
    private BinaryNode rotateLeft(BinaryNode disBalanceNode) {
        BinaryNode newRoot = disBalanceNode.right;
        BinaryNode temp = newRoot.left;
        newRoot.left = disBalanceNode;
        disBalanceNode.right = temp;

        disBalanceNode.height = 1 + Math.max(getHeight(disBalanceNode.left), getHeight(disBalanceNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    // Get Balance Method
    public int getBalance(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // Insert Method Helper
    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if (node == null) {
            return new BinaryNode(nodeValue);
        }

        if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else if (nodeValue > node.value) {
            node.right = insertNode(node.right, nodeValue);
        } else {
            return node;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && nodeValue < node.left.value) {
            return rotateRight(node);
        }

        if (balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }

        if (balance < -1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }
}
