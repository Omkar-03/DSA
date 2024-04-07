import java.util.*;

public class MaxArea {
    // Max Area in Histogram
    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        // next smaller left
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        s = new Stack<>();

        // next smaller right
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = arr.length;
                ;
            } else {
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int height = arr[i];
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("The maximum area in given histogram is " + maxArea);
    }

    public static void main(String args[]) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(arr);
    }
}