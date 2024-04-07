package DynamicProgramming;

import java.util.*;

public class MinArrayJumps {
    // Minimum Array Jumps
    // (Minimum number of jumps required to reach the last index of the array from
    // 0th index)

    // Tabulation
    public static int minJumps(int nums[]) { // O(n)
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, -1);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;

            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }
            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }

        return dp[0];
    }

    public static void main(String args[]) {
        int nums[] = { 2, 3, 1, 1, 4 };
        System.out.println("Minimum Array Jumps: " + minJumps(nums));
    }
}
