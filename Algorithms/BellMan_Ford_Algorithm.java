import java.util.ArrayList;
import java.rmi.StubNotFoundException;
import java.util.*;
public class BellMan_Ford_Algorithm {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void Creategraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));

    }

    public static void bellmanford(ArrayList<Edge> graph[], int src) {
        int dist[] = new int [graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int v = graph.length;
        // Algorithm

        for(int i=0; i<v-1; i++) {
            // Edge
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    // u, v, wt
                    int u = e.src;
                    int V = e.dest;
                    int wt = e.wt;
                    // Relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[V]) {
                        dist[V] = dist[u] + wt;
                    }
                }
            }
        }
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        Creategraph(graph);
        bellmanford(graph, 0);
    }
}


