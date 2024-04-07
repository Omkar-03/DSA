package SegmentTrees;

public class MaxSegTree {
    // Max/Min Segment Tree
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildTree(int i, int si, int sj, int arr[]) { // O(n)
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        buildTree(2 * i + 1, si, mid, arr);
        buildTree(2 * i + 2, mid + 1, sj, arr);

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) {
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            int leftAns = getMaxUtil(0, si, mid, qi, qj);
            int rightAns = getMaxUtil(0, mid + 1, sj, qi, qj);

            return tree[i] = Math.max(leftAns, rightAns);
        }
    }

    public static int getMax(int arr[], int qi, int qj) { // O(log(n))
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) {
            return;
        }

        if (si == sj) {
            tree[i] = newVal;
        }

        if (si != sj) {
            tree[i] = Math.max(tree[i], newVal);
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, newVal); // left
            updateUtil(2 * i + 2, mid + 1, sj, idx, newVal); // right
        }
    }

    public static void update(int arr[], int idx, int newVal) { // O(log(n))
        arr[idx] = newVal;
        int n = arr.length;
        updateUtil(0, 0, n - 1, idx, newVal);
    }

    public static void main(String args[]) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        init(n);
        buildTree(0, 0, n - 1, arr);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        System.out.println("Maximum number in given range: " + getMax(arr, 2, 5));

        update(arr, 2, 20);

        System.out.println("Maximum number in given range: " + getMax(arr, 2, 5));

        // Similar code for finding minimum number in given range
    }
}
