package Strings;

public class Strings_1 {
    public static boolean palindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void getShortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'N') {
                y++;
            } else if (str.charAt(i) == 'E') {
                x++;
            } else if (str.charAt(i) == 'S') {
                y--;
            } else {
                x--;
            }
        }
        System.out.println("Shortest Path: " + Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }

    public static void equal(String str1, String str2, String str3) {
        // Here the output is strings are equal, as str2 points to str1 as their value
        // is same
        if (str1 == str2) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }

        // Here the output is strings are not equal, as both the strings are stored at
        // different locations
        // if (str1 == str3) {
        // System.out.println("Strings are equal");
        // } else {
        // System.out.println("Strings are not equal");
        // }

        // Here the output is strings are equal, as this checks the value of string is
        // equal or not
        if (str1.equals(str3)) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }
    }

    public static String substring(String str, int si, int ei) {
        String substr = "";
        // for (int i = si; i < ei; i++) {
        // substr += str.charAt(i);
        // }
        // return substr;

        substr = str.substring(0, 4);
        return substr;
    }

    public static void compare(String fruits[]) {
        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        System.out.println("Largest String: " + largest);
    }

    public static String toUppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void compress(String str) {
        String newstr = "";
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            newstr += str.charAt(i);
            if (count > 1) {
                newstr += count.toString();
            }
        }
        System.out.println("Compressed String: " + newstr);
    }

    public static void main(String[] args) {
        String str = "racecar";
        // System.out.println(palindrome(str));

        String path = new String("WNEENESENNN");
        // getShortestPath(path);

        String str1 = "Omkar";
        String str2 = "Omkar";
        String str3 = new String("Omkar");
        // equal(str1, str2, str3);

        String str4 = "HelloWorld";
        // System.out.println(substring(str4, 0, 5));

        String fruits[] = { "apple", "mango", "banana" };
        // compare(fruits);

        // StringBuilder sb = new StringBuilder("");
        // for (char ch = 'a'; ch <= 'z'; ch++) {
        // sb.append(ch);
        // }
        // Time complexity= O(26) i.e. O(n)
        // If we use string then it is O(n^2), so StringBuilder is more efficient
        // System.out.println(sb);

        String str5 = "hi, i am omkar";
        // System.out.println(toUppercase(str5));

        String str6 = "aaabbcccdd";
        // String str7="abcd";
        // compress(str6);

        String str8 = "ApnaCollege".replace("l", "");
        System.out.println(str8);
    }
}