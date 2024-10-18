package Graphs;
import java.util.*;
public class All_Paths_from_Source_to_Destination {

    static class Edge{
        int src;
        int dst;
        public int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    static void CreateGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        
    }

    public static void Printallpaths(ArrayList<Edge> graph[], int src, int dest, String path) {
        if(src == dest) {
            System.out.println(path+dest);
            return;
        }

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            Printallpaths(graph, e.dest, dest, path+src);
        }
    }

    public static void main(String[] args) {

        int v = 6;
        ArrayList<Edge> graph [] = new ArrayList[v];
        CreateGraph(graph);

        int src = 5, dest = 1;
        Printallpaths(graph, src, dest, "");
        
    }

    
}
