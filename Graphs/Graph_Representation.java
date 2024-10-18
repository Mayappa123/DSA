package Graphs;

import java.util.*;

public class Graph_Representation {

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

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] Graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            Graph[i] = new ArrayList<>();
        }

        // 0 vertex9
        Graph[0].add(new Edge(0, 1, 5));

        // 1 vertex
        Graph[1].add(new Edge(1, 0, 5));
        Graph[1].add(new Edge(1, 2, 1));
        Graph[1].add(new Edge(1, 3, 3));

        // 2 vertex
        Graph[2].add(new Edge(2, 1, 1));
        Graph[2].add(new Edge(2, 3, 1));
        Graph[2].add(new Edge(2, 4, 4));

        // 3 vertex
        Graph[3].add(new Edge(3, 1, 3));
        Graph[3].add(new Edge(3, 2, 1));

        // 4 vertex
        Graph[4].add(new Edge(4, 2, 2));

        // 2's neighbours
        for (int i = 0; i < Graph[2].size(); i++) {
            Edge e = Graph[2].get(i);
            System.out.println(e.dst);
        }

    }

}
