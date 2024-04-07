package Graphs;

import java.util.ArrayList;

public class Bellman {
    static class Edge {
        int src;
        int dst;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
    }

    public static void createGraph1(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1 - vertex
        graph[1].add(new Edge(1, 2, -4));

        // 2 - vertex
        graph[2].add(new Edge(2, 3, 2));

        // 3 - vertex
        graph[3].add(new Edge(3, 4, 4));

        // 4 - vertex
        graph[4].add(new Edge(4, 1, -1));
    }

    public static void createGraph2(ArrayList<Edge> graph) {
        // 0 - vertex
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        // 1 - vertex
        graph.add(new Edge(1, 2, -4));

        // 2 - vertex
        graph.add(new Edge(2, 3, 2));

        // 3 - vertex
        graph.add(new Edge(3, 4, 4));

        // 4 - vertex
        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord1(ArrayList<Edge> graph[], int src) { // O(VE)
        int dist[] = new int[graph.length];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;

        for (int i = 0; i < V - 1; i++) {

            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dst;
                    int w = e.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // This is the same code as above. Just we have reduced a for loop keeping the
    // time complexity same.
    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) { // O(VE)
        int dist[] = new int[V];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dst;
                int w = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph1[] = new ArrayList[V];
        ArrayList<Edge> graph2 = new ArrayList<>();
        createGraph1(graph1);
        createGraph2(graph2);

        bellmanFord1(graph1, 0);
        bellmanFord2(graph2, 0, V);
    }
}
