package DynamicProgramming;

public class StringConverstion {

    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int ans = 0;
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static void stringConversion(String str1, String str2) {
        int lcsLength = lcs(str1, str2);
        if (str1.length() < str2.length()) {
            int delete = str2.length() - lcsLength;
            int insert = str1.length() - lcsLength;
            System.out.println("Insert operations: " + insert);
            System.out.println("Delete operations: " + delete);
        } else {
            int delete = str1.length() - lcsLength;
            int insert = str2.length() - lcsLength;
            System.out.println("Insert operations: " + insert);
            System.out.println("Delete operations: " + delete);
        }
    }

    public static void main(String args[]) {
        String str1 = "pear";
        String str2 = "steal";

        stringConversion(str1, str2);
    }
}
