package DivideNConquer;

import java.util.concurrent.CountDownLatch;

public class Assign {

    public static String[] mergeSort(String arr[], int low, int high) {
        if (low == high) {
            String A[] = { arr[low] };
            return A;
        }

        int mid = low + (high - low) / 2;
        String arr1[] = mergeSort(arr, low, mid);
        String arr2[] = mergeSort(arr, mid + 1, high);
        String arr3[] = merge(arr1, arr2);
        return arr3;
    }

    public static String[] merge(String arr1[], String arr2[]) {
        int m = arr1.length;
        int n = arr2.length;
        String arr3[] = new String[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (isAlphabeticallySmaller(arr1[i], arr2[j])) {
                arr3[k] = arr1[i];
                i++;
                k++;
            } else {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < m) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }

        while (j < n) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }

        return arr3;
    }

    public static boolean isAlphabeticallySmaller(String str1, String str2) {
        if (str1.compareTo(str2) < 0) {
            return true;
        }
        return false;
    }

    public static int majority(int nums[], int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = low + (high - low) / 2;
        int left = majority(nums, low, mid);
        int right = majority(nums, mid + 1, high);

        if (left == right) {
            return left;
        }

        int leftCount = CountInRange(nums, left, low, high);
        int rightCount = CountInRange(nums, right, low, high);

        return leftCount > rightCount ? left : right;
    }

    public static int CountInRange(int nums[], int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }

        return count;
    }

    public static int mergeSortInv(int arr[], int left, int right) {
        int invCount = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;
            invCount = mergeSortInv(arr, left, mid);
            invCount += mergeSortInv(arr, mid + 1, right);
            invCount += mergeInv(arr, left, mid + 1, right);
        }

        return invCount;
    }

    public static int mergeInv(int arr[], int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        int temp[] = new int[right - left + 1];
        int invCount = 0;

        while (i < mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                invCount += mid - i;
                j++;
                k++;
            }
        }

        while (i < mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
        return invCount;
    }

    public static void main(String args[]) {
        String arr[] = { "sun", "earth", "mars", "mercury" };
        String ans[] = mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < ans.length; i++) {
            // System.out.println(ans[i]);
        }

        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        // System.out.println(majority(nums, 0, nums.length - 1));

        int arr1[] = { 1, 20, 6, 4, 5 };
        // int arr1[] = { 2, 3, 4, 5, 6};
        System.out.println(mergeSortInv(arr1, 0, arr1.length - 1));
    }
}
