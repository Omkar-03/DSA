package Graphs;

import java.util.PriorityQueue;

public class ConnectingCities {
    static class Edge implements Comparable<Edge> {
        int dst;
        int cost;

        public Edge(int d, int c) {
            this.dst = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!vis[curr.dst]) {
                vis[curr.dst] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dst].length; i++) {
                    if (cities[curr.dst][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dst][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    public static void main(String args[]) {
        int cities[][] = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 }
        };

        System.out.println(connectCities(cities));
    }
}
