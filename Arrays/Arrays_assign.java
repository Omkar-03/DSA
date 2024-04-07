package Arrays;

public class Arrays_assign {
    public static boolean check(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int search(int a[], int target) {
        // min will have index of minimum element of a
        int min = minsearch(a);
        // find in sorted left
        if (a[min] <= target && target <= a[a.length - 1]) {
            return search(a, min, a.length - 1, target);
        }
        // find in sorted right
        else {
            return search(a, 0, min, target);
        }
    }

    // binary search to find target in left to right boundary
    public static int search(int a[], int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // smallest element index
    public static int minsearch(int a[]) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && a[mid - 1] > a[mid]) {
                return mid;
            } else if (a[mid] >= a[left] && a[mid] > a[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void triplets(int b[]) {
        for (int i = 0; i < b.length - 2; i++) {
            for (int j = i + 1; j < b.length - 1; j++) {
                for (int k = j + 1; k < b.length; k++) {
                    if (b[i] + b[j] + b[k] == 0) {
                        System.out.print("[" + b[i] + "," + b[j] + "," + b[k] + "] ");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Arrays Q.1 (Better approach is there but not understood.)
        int nums[] = { 1, 2, 3, 2 };
        // System.out.println(check(nums));

        // Arrays Q.2 (How to rotate an array ?)
        // int a[] = { 0, 1, 2, 4, 5, 6, 7 };
        int a[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        // int pivot = 3, target = 0;
        // for (int i = 0; i < a.length; i++) {
        // int b = a[i];
        // for (int j = pivot; j < a.length; j++) {
        // int c = a[pivot];
        // a[i] = c;
        // c = a[pivot + 1];
        // a[pivot + 1] = b;

        // }
        // }
        // System.out.println(search(a, target));

        // Arrays Q.4 (Better approach is there but not understood.)

        // Arrays Q.5 (Approach for unique triplet not understood.)
        int b[] = { -1, 0, 1, 2, -1, -4 };
        System.out.println("The triplets are: ");
        triplets(b);
    }
}