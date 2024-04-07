package DynamicProgramming;

public class MountainRanges {
    public static int mountainRanges(int n) { // O(n^2)
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                // Select one pair and
                // arrange "inside" number of pairs inside the selected pair
                int inside = dp[j];
                // arrange "outside" number of pairs outside the selected pair
                int outside = dp[i - j - 1];

                dp[i] += inside * outside;
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 4;
        System.out.println("Number of mountain ranges: " + mountainRanges(n));
    }
}
