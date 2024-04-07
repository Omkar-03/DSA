package Basic;

import java.util.*;

public class Prime {
    public static void main(String[] args) {
        Scanner om = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = om.nextInt();
        int i;
        if (n == 2) {
            System.out.println(n + "is a prime number");
        } else {
            boolean isPrime = true;
            for (i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime == true) {
                System.out.println(n + " is a prime number.");
            } else {
                System.out.println(n + " is not a prime number.");
            }
        }

    }
}