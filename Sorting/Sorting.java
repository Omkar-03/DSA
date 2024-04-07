package Sorting;

import java.util.Collections;
import java.util.Arrays;

public class Sorting {

    public static void selectionSort(Integer arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int imin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[imin] > arr[j]) {
                    imin = j;
                }
            }
            int temp = arr[imin];
            arr[imin] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(Integer arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > key) {
                arr[prev + 1] = arr[prev];
            }
            arr[prev + 1] = key;
        }
    }

    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Integer arr[] = { 5, 4, 1, 3, 2 };
        int a[] = { 5, 4, 5, 3, 3, 2, 1, 0 };

        // selectionSort(arr);
        // insertionSort(arr);

        // Arrays.sort(arr); // Time complexity = O(nlog(n))
        // Arrays.sort(arr, 0, 3);
        // Use Integer and not int, so the array is the object of class Integer
        // Arrays.sort(arr, Collections.reverseOrder());
        // Arrays.sort(arr, 0, 3, Collections.reverseOrder());

        countingSort(a); // Time complexity = O(n)
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
    }
}
