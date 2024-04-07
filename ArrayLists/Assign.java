import java.util.*;

public class Assign {

    public static boolean isMonotonic(ArrayList<Integer> A) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) < A.get(i + 1)) {
                dec = false;
            }
            if (A.get(i) > A.get(i + 1)) {
                inc = false;
            }
        }

        return inc || dec;
    }

    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(nums);

        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i));
            }
        }

        if (nums.size() == 1) {
            list.add(nums.get(0));
        }

        if (nums.size() > 1) {
            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }

            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }

        return list;
    }

    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        int result[] = new int[1000];

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }

        return ans;
    }

    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();

        divideConquer(1, 1, res, n);
        return res;
    }

    public static void divideConquer(int start, int increment, ArrayList<Integer> res, int n) {
        if (start + increment > n) {
            res.add(start);
            return;
        }

        divideConquer(start, 2 * increment, res, n);
        divideConquer(start + increment, 2 * increment, res, n);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(2);
        // System.out.println(list);
        // System.out.println(isMonotonic(list));

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(6);
        nums.add(5);
        nums.add(8);
        // System.out.println(findLonely(nums));

        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(1);
        nums1.add(100);
        nums1.add(200);
        nums1.add(1);
        nums1.add(100);
        // System.out.println(mostFrequent(nums1, 1));

        System.out.println(beautifulArray(10));
    }
}