import java.util.Stack;

public class Rainwater {

    public static int maxWater(int height[]) {
        Stack<Integer> s = new Stack<>();
        int n = height.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && height[s.peek()] < height[i]) {
                int pop_height = height[s.pop()];
                if (s.isEmpty()) {
                    break;
                }
                int distance = i - s.peek() - 1;
                int min_height = Math.min(height[s.peek()], height[i]) - pop_height;
                ans += distance * min_height;
            }
            s.push(i);
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println(maxWater(arr));
    }
}
