package Recursion;

public class Recursion {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int fn = n * factorial(n - 1);
        return fn;
    }

    public static int tilingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int fnm1 = tilingProblem(n - 1);
        int fmn2 = tilingProblem(n - 2);
        int totalWays = fnm1 + fmn2;
        return totalWays;
    }

    public static void removeDuplicates(int i, String str, StringBuilder newStr, boolean map[]) {
        if (i == str.length() - 1) {
            System.out.println(newStr);
            return;
        }

        char ch = str.charAt(i);
        if (map[ch - 'a'] == true) {
            removeDuplicates(i + 1, str, newStr, map);
        } else {
            map[ch - 'a'] = true;
            removeDuplicates(i + 1, str, newStr.append(ch), map);
        }
    }

    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int fnm1 = friendsPairing(n - 1);
        int fnm2 = friendsPairing(n - 2);

        return fnm1 + (n - 1) * fnm2;
    }

    public static void printBinStrings(int n, int lastplace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        printBinStrings(n - 1, 0, str + "0");
        if (lastplace == 0) {
            printBinStrings(n - 1, 1, str + "1");
        }
    }

    public static void allOccurence(int a[], int i, int key) {
        if (i == a.length) {
            return;
        }

        if (a[i] == key) {
            System.out.println(i);
        }
        allOccurence(a, i + 1, key);
    }

    public static void numToString(int n) {
        String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        if (n == 0) {
            return;
        }

        int lastdigit = n % 10;
        numToString(n / 10);
        System.out.print(digits[lastdigit] + " ");
    }

    // My solution
    // public static int length(String str, int i) {
    // if (i == str.length()) {
    // return i;
    // }
    // return length(str, i + 1);
    // }

    public static int length(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return length(str.substring(1)) + 1;
    }

    // Difficult to understand
    public static int countSubstrings(String str, int i, int j, int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }

        int res = countSubstrings(str, i + 1, j, n - 1) + countSubstrings(str, i, j - 1, n - 1)
                - countSubstrings(str, i + 1, j - 1, n - 2);

        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }

    public static void towerOfHanoi(int n, String src, String help, String dest) {
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }

        // transfer top n-1 from source to helper using destination as helper
        towerOfHanoi(n - 1, src, dest, help);
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
        // transfer n-1 from helper to destination using source as helper
        towerOfHanoi(n - 1, help, src, dest);
    }

    public static void main(String args[]) {
        // System.out.println(factorial(5));

        // System.out.println(tilingProblem(5));

        boolean map[] = new boolean[26];
        // removeDuplicates(0, "apnacollege", new StringBuilder(""), map);

        // System.out.println(friendsPairing(3));

        // printBinStrings(3, 0, "");

        int a[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        // allOccurence(a, 0, 2);

        // numToString(1209);

        // System.out.println(length("omkar", 0));
        // System.out.println(length("omkar"));

        String str = "abcab";
        // System.out.println(countSubstrings(str, 0, str.length() - 1, str.length()));

        towerOfHanoi(3, "S", "H", "D");
    }
}