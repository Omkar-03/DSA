package Heaps;

import java.util.ArrayList;

public class PQ2 {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size() - 1; // child index
            int par = (x - 1) / 2; // parent index

            while (arr.get(par) > arr.get(x)) { // O(logn) use < for maxHeap
                int temp = arr.get(par);
                arr.set(par, arr.get(x));
                arr.set(x, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int min = i; // use max for maxHeap

            if (left < arr.size() && arr.get(min) > arr.get(left)) { // use < for maxHeap
                min = left;
            }

            if (right < arr.size() && arr.get(min) > arr.get(right)) { // use < for maxHeap
                min = right;
            }

            if (min != i) {
                int temp = arr.get(min);
                arr.set(min, arr.get(i));
                arr.set(i, temp);

                heapify(min);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // Swap first and last node
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Delete last node
            arr.remove(arr.size() - 1);

            // Heapify
            heapify(0); // O(logn)

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String args[]) {
        Heap pq = new Heap();

        pq.add(3);
        pq.add(1);
        pq.add(4);
        pq.add(5);

        while (!pq.isEmpty()) { // heap sort
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
