package Strings;

import java.util.*;

public class Strings_2 {

    public static String compress(String str) {
        String sb = "";
        // sb.append(str.charAt(0));
        int i;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            Integer count = 0;
            for (i = 0; i < str.length(); i++) {
                if (ch == str.charAt(i)) {
                    count++;
                }
            }
            if (count > 0) {
                sb += ch;
                sb += count.toString();
            }
        }
        return sb;
    }

    public static void anagrams(String str1, String str2) {
        String str3 = compress(str1).intern();
        String str4 = compress(str2).intern();
        System.out.println(str3 + " " + str4);
        if (str3 == str4) {
            System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
        }
    }

    public static void anagrams1(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.length() == str2.length()) {
            char ch1[] = str1.toCharArray();
            char ch2[] = str2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            System.out.println(str1 + " " + str2);
            if (Arrays.equals(ch1, ch2)) {
                System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
            }
        } else {
            System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
        }
    }

    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = s1.intern();// returns string from pool, now it will be same as s2
        // System.out.println(s1 == s2);// false because reference variables are
        // pointing to different instance
        // System.out.println(s2 == s3);// true because reference variables are pointing
        // to same instance

        StringBuffer s4 = new StringBuffer("Omkar");
        StringBuffer s5 = s4.reverse();
        // System.out.println(s5);

        String str1 = "earth";
        String str2 = "heart";
        // anagrams(str1, str2); //Brute force
        anagrams1(str1, str2);
    }
}
