package Graphs;

import java.util.*;

import arrays.Arraylist;

public class Cycle_in_Graph {
    static class Edge {
        int src;
        int dst;

        public Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    static void CreateGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    public static boolean DetectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectcycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectcycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 3
            if (!vis[e.dst]) {
                if (detectcycleUtil(graph, vis, e.dst, curr)) {
                    return true;
                }
            }

            // case 1
            else if (vis[e.dst] && e.dst != par) {
                return true;
            }

            // case 2 -> do nothing -> continue
        }
        return false;
    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);

        System.out.println(DetectCycle(graph));

    }

}
