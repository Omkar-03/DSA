package Arrays;

public class SubArray {

    public static void subarray(int arr[]) {
        int total = 0, maxsum = Integer.MIN_VALUE, minsum = Integer.MAX_VALUE;

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;

                // Brute force method
                // for (int k = i; k <= j; k++) {
                // sum = sum + arr[k];
                // System.out.print(arr[k] + " ");
                // }

                // Prefix sum method
                sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];

                minsum = Math.min(minsum, sum);
                maxsum = Math.max(maxsum, sum);

                // if (sum > maxsum) {
                // maxsum = sum;
                // }
                // if (sum < minsum) {
                // minsum = sum;
                // }

                System.out.print("Sum of subarray: " + sum);
                total++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total number of subarrays: " + total);
        System.out.println("Maximum sum of a subarray: " + maxsum);
        System.out.println("Minimum sum of a subarray: " + minsum);
    }

    public static void kadanes(int arr[]) {
        int maxsum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {
                sum = 0;
            }
            maxsum = Math.max(maxsum, sum);
        }

        if (maxsum == 0) {
            maxsum = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                maxsum = Math.max(maxsum, arr[i]);
            }
        }
        System.out.println("Maximum sum of a subarray: " + maxsum);
    }

    public static void main(String[] args) {
        int arr[] = { -2, -3, 0, -2, -3 };
        // subarray(arr);
        kadanes(arr); // IMPORTANT
    }
}
