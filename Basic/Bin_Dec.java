package Basic;

public class Bin_Dec {
    public static void BintoDec(int n) {
        int i, digit, dec = 0, m = n;
        for (i = 0; n > 0; i++) { // We can also use while loop
            digit = n % 10;
            dec = dec + digit * (int) Math.pow(2, i);
            n = n / 10;
        }
        System.out.println("Decimal form of " + m + " is " + dec);
    }

    public static void DectoBin(int no) {
        int i, digit, bin = 0, m = no;
        for (i = 0; no > 0; i++) { // We can also use while loop
            digit = no % 2;
            bin = bin + digit * (int) Math.pow(10, i);
            no = no / 2;
        }
        System.out.println("Binary form of " + m + " is " + bin);
    }

    public static void main(String[] args) {
        BintoDec(1111);
        DectoBin(15);
    }
}