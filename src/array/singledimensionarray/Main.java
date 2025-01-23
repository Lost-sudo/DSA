package array.singledimensionarray;

public class Main {
    public static void main(String[] args) {
        SingleDimensionArray sda = new SingleDimensionArray(10);
        sda.insert(0, 10);
        sda.insert(1, 20);
        sda.insert(2, 30);
        sda.insert(1, 30);
        sda.insert(12, 120);

        sda.traverseArray();
        sda.searchInArray(20);
        sda.deleteValue(20);
        sda.traverseArray();
    }
}
