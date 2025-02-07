package AVLTree;

public class BinaryNode {
    public int value;
    public int height;
    public BinaryNode left;
    public BinaryNode right;

    BinaryNode(int value) {
        this.value = value;
        this.height = 0;
    }
}
