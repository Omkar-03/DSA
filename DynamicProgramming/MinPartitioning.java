package DynamicProgramming;

import java.util.Arrays;

public class MinPartitioning {

    // Minimum Partitioning (Divide given array into 2 sets such that the absolute
    // sum difference is minimum)

    // Tabulation
    public static int minPartition(int arr[]) { // O(n * W)
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int W = sum / 2;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;

        printDp(dp);
        return Math.abs(sum1 - sum2);
    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 1, 6, 11, 5 };

        System.out.println("Minimum Partition: " + minPartition(arr));
    }
}
