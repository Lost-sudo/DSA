package array.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("How many days' temperature? ");
            int numberOfDays = s.nextInt();
            int[] temp = new int[numberOfDays];

            int sum = 0;
            for (int i = 0; i < numberOfDays; i++) {
                System.out.println("Day " + (i + 1) + "'s high temp: ");
                temp[i] = s.nextInt();
                sum += temp[i];
            }
            double average = (double) sum / numberOfDays;
            int above = 0;
            for (int j : temp) {
                if (j > average) {
                    above++;
                }
            }

            System.out.println();
            System.out.println("Average Temp = " + average);
            System.out.println("Days above average temp: " + above);
        }
    }
}
