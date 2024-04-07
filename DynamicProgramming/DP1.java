package DynamicProgramming;

import java.util.Arrays;

public class DP1 {
    // Fibonacci Series
    // Normal Recursion
    public static int fib1(int n) { // O(2^n)
        if (n == 0 || n == 1) {
            return n;
        }

        return fib1(n - 1) + fib1(n - 2);
    }

    // Memoization
    public static int fib2(int n, int f[]) { // O(n)
        if (n == 0 || n == 1) {
            return n;
        }

        f[n] = fib2(n - 1, f) + fib2(n - 2, f);

        return f[n];
    }

    // Tabulation
    public static int fib3(int n, int dp[]) { // O(n)
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Climbing Stairs
    // Memoization
    public static int climbingStairs1(int n, int ways[]) { // O(n)
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) {
            return ways[n];
        }

        return climbingStairs1(n - 1, ways) + climbingStairs1(n - 2, ways);
    }

    // Tabulation
    public static int climbingStairs2(int n, int dp[]) { // O(n)
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5;
        int f[] = new int[n + 1];

        System.out.println("Normal Recursion: " + fib1(n));
        System.out.println("Memoization: " + fib2(n, f));
        System.out.println("Tabulation: " + fib3(n, f));

        int n1 = 5;
        int ways[] = new int[n1 + 1];
        Arrays.fill(ways, -1);

        System.out.println("Number of ways to reach nth stair(Memoization): " + climbingStairs1(n1, ways));
        System.out.println("Number of ways to reach nth stair(Tabulation): " + climbingStairs2(n1, ways));
    }
}
