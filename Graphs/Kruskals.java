package Graphs;

import java.util.*;

public class Kruskals {
    static class Edge implements Comparable<Edge> {
        int src;
        int dst;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dst = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) { // O(1)
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) { // O(1)
        int parA = par[a];
        int parB = par[b];

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static void kruskals(ArrayList<Edge> edges, int V) { // O(V + Elog(E))
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1; i++) {
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dst);

            if (parA != parB) {
                union(e.src, e.dst);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println(mstCost);
    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);

        kruskals(edges, V);
    }
}
