import java.util.*;

public class Binary {
    public static void generateBinary(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");

        while (n-- > 0) {
            String s1 = q.remove();
            System.out.println(s1);
            q.add(s1 + "0");
            q.add(s1 + "1");
        }
    }

    public static int minCost(int arr[]) {
        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        System.out.println(pq);
        // for (int i = 0; i < n; i++) {
        // System.out.println(pq.peek());
        // pq.remove();
        // }

        int res = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            res += first + second;
            System.out.println(res);
            pq.add(first + second);
        }

        return res;
    }

    static class Job {
        char job_id;
        int deadline;
        int profit;

        Job(char job_id, int deadline, int profit) {
            this.job_id = job_id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static void printJobScheduling(ArrayList<Job> arr) {
        int n = arr.size();
        Collections.sort(arr, (a, b) -> {
            return a.deadline - b.deadline;
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr.get(i).job_id);
        }

        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.profit - a.profit;
        });

        for (int i = 0; i < n; i++) {
            System.out.println(maxHeap.poll());
        }

        for (int i = n - 1; i >= 0; i--) {
            int slot_available;
            if (i == 0) {
                slot_available = arr.get(i).deadline;
            } else {
                slot_available = arr.get(i).deadline - arr.get(i - 1).deadline;
            }
            maxHeap.add(arr.get(i));
            while (slot_available > 0 && maxHeap.size() > 0) {
                Job job = maxHeap.remove();
                slot_available--;
                result.add(job);
            }
        }

        Collections.sort(result, (a, b) -> {
            return a.deadline - b.deadline;
        });

        for (Job job : result) {
            System.out.print(job.job_id + " ");
        }
    }

    static void reverseFristK(Queue<Integer> q, int k) {
        int n = q.size();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }
        for (int i = 0; i < k; i++) {
            q.add(s.pop());
        }
        for (int i = 0; i < n - k; i++) {
            int a = q.remove();
            q.add(a);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(q.remove() + " ");
        }
    }

    static void printMax(int arr[], int n, int k) {
        Deque<Integer> q = new LinkedList<Integer>();
        int i;
        for (i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }

        for (; i < n; ++i) {
            System.out.print(arr[q.peek()] + " ");
            while (!q.isEmpty() && q.peek() <= i - k) {
                q.removeFirst();
            }

            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        System.out.println(arr[q.peek()]);
    }

    public static void main(String args[]) {
        // Generate Binary Numbers
        int n = 10;
        // generateBinary(n);

        // Connect n ropes with minimum cost
        int len[] = { 8, 7, 3, 5 };
        // System.out.println("The minimum cost for connecting " + len.length + " ropes
        // is " + minCost(len));

        // Job Sequencing Problem
        ArrayList<Job> arr = new ArrayList<Job>();
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        // arr.add(new Job('a', 4, 20));
        // arr.add(new Job('b', 1, 10));
        // arr.add(new Job('c', 1, 40));
        // arr.add(new Job('d', 1, 30));

        // System.out.print("Following is maximum profit sequence of jobs: ");
        // printJobScheduling(arr);

        // Reversing the first K elements of a Queue
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        // reverseFristK(q, 5);

        // Maximum of all subarrays of size k
        int arr1[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        // printMax(arr1, arr1.length, k);
    }
}
