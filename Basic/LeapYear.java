package Basic;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner om = new Scanner(System.in);
        System.out.println("Enter a year:");
        int year = om.nextInt();

        // String b = (year % 4 == 0)
        // ? ((year % 100 != 0) ? "Leap Year" : (year % 400 == 0) ? "Leap Year" : "Not a
        // leap year")
        // : "Not a leap year";

        // System.out.println(year + " is " + b);

        // if (year % 4 == 0) {
        // if (year % 100 != 0) {
        // System.out.println("Leap Year");
        // } else {
        // if (year % 400 == 0) {
        // System.out.println("Leap Year");
        // }
        // }
        // } else {
        // System.out.println("Not a Leap Year");
        // }

        boolean x = year % 4 == 0;
        boolean y = year % 100 != 0;
        boolean z = year % 100 == 0 && year % 400 == 0;

        if (x && (y || z)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}
