import java.util.*;
public class Topological_Sort_Using_BFS {

    static class Edge{
        int src;
        int dst;

        public Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    static void CreateGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        
    }

    public static void CalcInDegree (ArrayList<Edge> graph[] ,int InDegree []) {
        for(int i=0; i<graph.length; i++) {
            int v=i;
            for(int j=0; j<graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                InDegree[e.dst]++;
            }
        }
    }

    public static void TopSort (ArrayList<Edge> graph[]) {
        int InDegree[] = new int[graph.length];
        CalcInDegree(graph, InDegree);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<InDegree.length; i++) {
            if(InDegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");

            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                InDegree[e.dst]--;
                if(InDegree[e.dst] == 0) {
                    q.add(e.dst);
                }
            }

            
        }

        System.out.println();
        
    
     
    }

    public static void main(String[] args) {
        
        int v = 6;
        ArrayList<Edge> graph [] = new ArrayList[v];
        CreateGraph(graph);

        TopSort(graph);
    }

 }
