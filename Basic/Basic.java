package Basic;

import java.util.*;

public class Basic {
    public static void main(String[] args) {
        Scanner om = new Scanner(System.in);
        float a = om.nextFloat();
        float b = om.nextFloat();
        float c = om.nextFloat();
        float total = a + b + c;
        total = total + total * 0.18f;
        System.out.println("Total with GST: " + total);

        int $ = 24;
        System.out.println($);

        char ch = 'a';
        int num = ch;
        System.out.println(num);
    }
}