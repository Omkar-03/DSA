package Tries;

public class Tries1 {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L)
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key) { // O(L)
        Node curr = root;

        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    public static void main(String args[]) {
        // String words[] = { "the", "a", "there", "their", "any", "thee" };
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println("Word exists or not?");
        System.out.println(search("sam"));
        System.out.println(search("sammy"));

        // Word Break Problem
        String key = "ilikesamsung";
        System.out.println("Key exists or not?");
        System.out.println(wordBreak(key));

        // Starts With Problem
        String words1[] = { "apple", "app", "mango", "man", "woman" };
        String prefix1 = "app";
        String prefix2 = "map";

        for (int i = 0; i < words1.length; i++) {
            insert(words1[i]);
        }

        System.out.println("Word startig with prefix exists or not?");
        System.out.println(startsWith(prefix1));
        System.out.println(startsWith(prefix2));

    }
}
