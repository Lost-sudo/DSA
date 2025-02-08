package AVLTree;

public class Main {
    public static void main(String[] args) {
        AVL avl = new AVL();

        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(20);
        avl.levelOrder();
        System.out.println();
        avl.delete(15);
        avl.levelOrder();
        System.out.println();
        avl.search(5);
        avl.deleteAVLTree();
    }
}
