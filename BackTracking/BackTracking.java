package BackTracking;

public class BackTracking {
    public static void findPermutations(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutations(newStr, ans + ch);
        }
    }

    public static int gridWays(int i, int j, int n, int m) {

        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }
        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);

        return w1 + w2;
    }

    final static char[][] L = {
            {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }
    };

    public static void letterCombinations(String D) {
        int len = D.length();

        if (len == 0) {
            System.out.println("");
            return;
        }

        bfs(0, len, new StringBuilder(), D);
    }

    public static void bfs(int pos, int len, StringBuilder sb, String D) {
        if (pos == len) {
            System.out.println(sb.toString());
        } else {
            char[] letters = L[Character.getNumericValue(D.charAt(pos))];
            for (int i = 0; i < letters.length; i++) {
                bfs(pos + 1, len, new StringBuilder(sb).append(letters[i]), D);
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        // findPermutations(str, "");

        int n = 3, m = 3;
        // System.out.println(gridWays(0, 0, n, m));

        letterCombinations("23");
    }
}

// gridWays
// Time Complexity=O(pow(2, n+m))
// shortcut formula:
// no. of ways = (n-1+m-1)!/(n-1)!(m-1)!