package DynamicProgramming;

import java.util.*;

public class Catalan {
    // Normal Recursion
    public static int catalan1(int n) { // O(exponential)
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalan1(i) * catalan1(n - i - 1);
        }

        return ans;
    }

    // Memoization
    public static int catalan2(int n, int dp[]) { // O(n^2)
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalan2(i, dp) * catalan2(n - i - 1, dp);

        }
        dp[n] = ans;
        return ans;
    }

    // Tabulation
    public static int catalan3(int n) { // O(n^2)
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5;

        System.out.println("Catalan's number(Normal Recursion): " + catalan1(n));

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Catalan's number(Memoization): " + catalan2(n, dp));

        System.out.println("Catalan's number(Tabulation): " + catalan3(n));

    }
}
