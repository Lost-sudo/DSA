package SortingAlgorithm.BucketSort;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import java.lang.Integer;

public class Main {
    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 4, 2, 1, 3, 6, 8};
        BucketSort newBucketSort = new BucketSort(arr);
        newBucketSort.printArray(arr);
        newBucketSort.bucketSort();
        System.out.println();
        newBucketSort.printArray(arr);


    }
}

class BucketSort {
    int[] arr;

    public BucketSort(int[] arr) {
        this.arr = arr;
    }

    public void bucketSort() {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for (int value: arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int value : arr) {
            int bucketNumber = (int) Math.ceil(((float)value * numberOfBuckets)/(float)maxValue);
            buckets[bucketNumber-1].add(value);
        }

        System.out.println("\n\nPrinting buckets before sorting...");
        printBucket(buckets);

        for (ArrayList<Integer> bucket: buckets) {
            Collections.sort(bucket);
        }

        System.out.println("\n\nPrinting buckets after sorting...");
        printBucket(buckets);

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index] = value;
                index++;
            }
        }

    }

    public void printArray(int[] array) {
        for (int data : array) {
            System.out.print(data + " ");
        }
    }

    public void printBucket(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("\nBucket No. " + i);
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " ");
            }
        }
    }
}