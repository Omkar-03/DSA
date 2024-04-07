package Heaps;

import java.util.*;

public class PQ1 {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank; // Ascending order
        }
    }

    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>(); // Use Comparator.reverseOrder() for descending order

        pq.add(new Student("Sahil", 3));
        pq.add(new Student("Omkar", 1));
        pq.add(new Student("Amey", 5));
        pq.add(new Student("Tanmay", 7));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
