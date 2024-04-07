package DynamicProgramming;

public class WildcardMatching {
    // * - any number of characters(can be null)
    // ? - single character(cannot be null)
    public static boolean wildcardMatching(String s, String p) { // O(n * m)
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    boolean ans1 = dp[i][j - 1]; // ignore *
                    boolean ans2 = dp[i - 1][j]; // match the char but keep *
                    dp[i][j] = ans1 || ans2;
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {
        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.println("Wildcard Matching possible? : " + wildcardMatching(s, p));
    }
}
