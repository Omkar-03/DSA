package DivideNConquer;
public class DivideNConquer {

    public static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        int temp[] = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (i = low, k = 0; k < temp.length; k++, i++) { // Important step
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low, j = low, temp;

        for (j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static int search(int arr[], int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        // mid on L1
        if (arr[low] <= arr[mid]) {
            if (arr[low] <= target && target <= arr[mid]) {
                return search(arr, target, low, mid - 1);
            } else {
                return search(arr, target, mid + 1, high);
            }
        }

        // mid on L2
        else {
            if (arr[mid] <= target && target <= arr[high]) {
                return search(arr, target, mid + 1, high);
            } else {
                return search(arr, target, low, mid - 1);
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = { 6, 2, 3, 9, 4, 1 };
        // mergeSort(arr, 0, arr.length - 1);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // quickSort(arr, 0, arr.length - 1);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // Sorted and rotated array search
        int arr1[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(arr1, target, 0, arr1.length - 1));

    }
}

// Merge Sort
// Time Complexity = O(nlogn)
// Space Complexity = O(n)

// Quick Sort
// Time Complexity = O(nlogn) (Average), O(n2) (Worst)
// Space Complexity = O(1)