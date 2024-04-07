package DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMul {
    // Matrix Chain Multiplication
    // Normal Recursion
    public static int mcm1(int arr[], int i, int j) { // O(exponential)
        if (i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm1(arr, i, k);
            int cost2 = mcm1(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }

        return ans;
    }

    // Memoization
    public static int mcm2(int arr[], int i, int j, int dp[][]) { // O(n^2)
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm2(arr, i, k, dp);
            int cost2 = mcm2(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }

        return dp[i][j] = ans;
    }

    // Tabulation
    public static int mcm3(int arr[]) { // O(n^2)
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1; // col
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[j] * arr[k];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }

        // printDp(dp);
        return dp[1][n - 1];
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
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;

        System.out.println("Minimum Cost(Recursion): " + mcm1(arr, 1, n - 1));

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println("Minimum Cost(Memoization): " + mcm2(arr, 1, n - 1, dp));

        System.out.println("Minimum Cost(Tabulation): " + mcm3(arr));
    }
}
