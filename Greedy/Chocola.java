package Greedy;

import java.util.*;

public class Chocola {
    public static void main(String args[]) {
        int n = 4, m = 6;
        Integer costHor[] = { 2, 1, 3, 1, 4 };
        Integer costVer[] = { 4, 1, 2 };

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int hp = 1, vp = 1;
        int h = 0, v = 0;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {  //horizontal cut
                cost += costHor[h] * vp;
                hp++;
                h++;
            } else {
                cost += costVer[v] * hp;
                vp++;
                v++;
            }
        }

        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        System.out.println("The minimum cost of cuts is " + cost);
    }
}
