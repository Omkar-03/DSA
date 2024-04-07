package Hashing;

import java.util.*;

public class Hashing2 {
    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(4);
        set.add(1);
        set.add(2);
        set.add(4);

        System.out.println("Hash Set: " + set);

        if (set.contains(1)) {
            System.out.println("set contains 1");
        }
        // set.remove(1);

        System.out.println(set);
        // System.out.println(set.size());

        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // for (int num : set) {
        // System.out.println(num);
        // }

        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("Mumbai");
        lhs.add("Delhi");
        lhs.add("Bengaluru");
        lhs.add("Noida");

        System.out.println("Linked Hash Set: " + lhs);

        TreeSet<String> ts = new TreeSet<>();

        ts.add("Mumbai");
        ts.add("Delhi");
        ts.add("Bengaluru");
        ts.add("Noida");

        System.out.println("Tree Set: " + ts);

        // For counting unique elements in an array you can use HashSet
    }
}
