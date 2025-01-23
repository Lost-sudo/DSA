package arraylist;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        // numbers.add(2, 4);
        numbers.add(4);
        numbers.add(5);
        // System.out.println(numbers);

        // Accessing an element
        // System.out.println(numbers.get(2));

        // Traversing an ArrayList
        // for (int i = 0; i < numbers.size(); i++) {
        //     System.out.println(numbers.get(i));
        // }
        // for (int number: numbers){
        //     System.out.println(number);
        // }
        // Iterator<Integer> iterator = numbers.iterator();
        // while (iterator.hasNext()){
        //     int number = iterator.next();
        //     System.out.println(number);
        // }

        // Searching
        // for (Integer number: numbers) {
        //     if (number.equals(2)){
        //         System.out.println("The element is found");
        //         break;
        //     }
        // }

        // Delete element
        numbers.remove(2);
        System.out.println(numbers);

    }
}
