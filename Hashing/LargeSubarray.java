package Hashing;

import java.util.HashMap;

public class LargeSubarray {

    public static void main(String args[]) {
        // Largest subarray with sum 0

        int arr1[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int sum1 = 0;
        int len = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for (int j = 0; j < arr1.length; j++) {
            sum1 += arr1[j];

            if (map1.containsKey(sum1)) {
                len = Math.max(len, j - map1.get(sum1));
            } else {
                map1.put(sum1, j);
            }
        }

        System.out.println("The length of largest subarray whose sum is 0: " + len);

        // Count of subarrays with sum k

        int arr2[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        int sum2 = 0;
        int ans = 0;

        HashMap<Integer, Integer> map2 = new HashMap<>();

        map2.put(0, 1);

        for (int j = 0; j < arr2.length; j++) {
            sum2 += arr2[j];

            if (map2.containsKey(sum2 - k)) {
                ans += map2.get(sum2 - k);
            }
            map2.put(sum2, map2.getOrDefault(sum2, 0) + 1);
        }

        System.out.println("The count of subarrays with sum k: " + ans);
    }
}
