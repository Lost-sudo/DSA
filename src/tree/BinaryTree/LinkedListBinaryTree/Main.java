package tree.BinaryTree.LinkedListBinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTreeLinkedList binaryTreeLinkedList = new BinaryTreeLinkedList();

        binaryTreeLinkedList.insert("N1");
        binaryTreeLinkedList.insert("N2");
        binaryTreeLinkedList.insert("N3");
        binaryTreeLinkedList.insert("N4");
        binaryTreeLinkedList.insert("N5");
        binaryTreeLinkedList.insert("N6");
        binaryTreeLinkedList.insert("N7");
        binaryTreeLinkedList.insert("N8");
        binaryTreeLinkedList.insert("N9");


        binaryTreeLinkedList.preOrder(binaryTreeLinkedList.root);
        System.out.println();
        binaryTreeLinkedList.inOrder(binaryTreeLinkedList.root);
        System.out.println();
        binaryTreeLinkedList.postOrder(binaryTreeLinkedList.root);
        System.out.println();
        binaryTreeLinkedList.levelOrder();
        System.out.println("\n");

        binaryTreeLinkedList.search("N5");
        binaryTreeLinkedList.deleteNode("N5");
        binaryTreeLinkedList.deleteNode("N1");
        binaryTreeLinkedList.levelOrder();
        binaryTreeLinkedList.deleteBinaryTree();
        System.out.println();
        binaryTreeLinkedList.levelOrder();
    }
}
