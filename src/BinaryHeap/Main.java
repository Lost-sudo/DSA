package BinaryHeap;

public class Main {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(5);
        binaryHeap.insert(10, "Min");
        binaryHeap.insert(5, "Min");
        binaryHeap.insert(15, "Min");
        binaryHeap.insert(1, "Min");
        System.out.println(binaryHeap.extractHeadOfBH("Min"));
        binaryHeap.deleteBH();
        System.out.println(binaryHeap.peek());
        binaryHeap.levelOrderTraversal();
    }
}
