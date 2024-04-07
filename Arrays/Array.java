package Arrays;

public class Array {
    public static int linear(String arr[], String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // String arr[]=new String[100];
        String arr[] = { "mango", "banana", "apple" };
        String key = "apple";
        int x = linear(arr, key);
        if (x == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + x);
        }
    }
}

// Time complexity

// linear search = n
// binary search = log(n)
//
