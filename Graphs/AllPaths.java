package Graphs;

import java.util.*;

public class AllPaths {
    static class Edge {
        int src;
        int dst;

        public Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 3));

        // 2 - vertex
        graph[2].add(new Edge(2, 3));

        // 3 - vertex
        graph[3].add(new Edge(3, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // 5 - vertex
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void printAllPath(ArrayList<Edge> graph[], int src, int dst, String path) { // O(V^V)
        if (src == dst) {
            System.out.print(path + dst);
            System.out.println();
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            printAllPath(graph, e.dst, dst, path + src);
        }
    }

    public static void main(String args[]) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        printAllPath(graph, 5, 1, "");
    }
}
