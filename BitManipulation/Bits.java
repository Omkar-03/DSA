package BitManipulation;

public class Bits {

    public static void oddOrEven(int n) {
        int bitmask = 1;
        if ((n & bitmask) == 1) {
            System.out.println("Odd number");
        } else {
            System.out.println("Even number");
        }
    }

    public static void getIthBit(int n, int i) {
        int bitmask = 1 << i;
        System.out.println(n & bitmask);
    }

    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;
        return n | bitmask;
    }

    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static void updateIthBit(int n, int i, int newBit) {
        if (newBit == 0) {
            n = clearIthBit(n, i);
        } else {
            n = setIthBit(n, i);
        }
        System.out.println(n);
    }

    public static void clearIBits(int n, int i) // clear last i bits
    {
        int bitmask = (~0) << i; // (~0) = -1 --> (1111111111111)
        System.out.println(n & bitmask);
    }

    public static void clearBitsInRange(int n, int i, int j) {
        int a = (~0) << (j + 1);
        int b = 1 << i - 1;
        int bitmask = a | b;
        System.out.println(n & bitmask);
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) // checks the LSB
            {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void swap(int x, int y) {
        System.out.println("Before swap x = " + x + " y = " + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After swap x = " + x + " y = " + y);
    }

    public static void add1() {
        int x = 6;
        System.out.println(x + " + 1 " + " is " + -~x);
        x = -4;
        System.out.println(x + " + 1 " + " is " + -~x);
        x = 0;
        System.out.println(x + " + 1 " + " is " + -~x);
    }

    public static void UpperToLower() {
        // System.out.println((int) ' ');
        // System.out.println(32 | 65);
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' '));
        }
    }

    public static void main(String[] args) {
        // oddOrEven(21);

        // getIthBit(10, 2);

        // System.out.println(setIthBit(10, 2));

        // System.out.println(clearIthBit(10, 1));

        // updateIthBit(10, 2, 1);

        // clearIBits(15, 2);

        // clearBitsInRange(10, 2, 4);

        // System.out.println(isPowerOfTwo(16));

        // System.out.println(countSetBits(15));

        // System.out.println(fastExpo(5, 3));

        // swap(3, 4);

        // add1();

        UpperToLower();
    }
}
