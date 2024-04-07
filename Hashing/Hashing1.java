package Hashing;

import java.util.*;

public class Hashing1 {
    public static void main(String args[]) {
        // Hash Map
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println("Hash Map: " + hm);

        // Get - O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("Indonesia"));

        // ContainsKey - O(1)
        System.out.println(hm.containsKey("India"));

        // Remove - O(1)
        // hm.remove("China");
        System.out.println(hm);

        System.out.println(hm.size());

        // hm.clear();
        System.out.println(hm.isEmpty());

        Set<String> keys = hm.keySet();
        // Also you can use hm.entrySet()

        for (String k : keys) {
            System.out.println("Key: " + k + ", val: " + hm.get(k));
        }

        // Linked Hash Map
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("USA", 50);

        System.out.println("Linked Hash Map: " + lhm);

        // Tree Map
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("USA", 50);

        System.out.println("Tree Map: " + tm);
    }
}
