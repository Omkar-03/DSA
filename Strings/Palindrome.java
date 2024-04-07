package Strings;

public class Palindrome {
    public static void main(String args[]) {
        int n = 121;
        int m = n, digit, rev = 0;
        while (n != 0) {
            digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }
        if (rev == m) {
            System.out.println(m + " is Palindrome.");
        } else {
            System.out.println(m + " is not a Palindrome.");
        }
    }
}
