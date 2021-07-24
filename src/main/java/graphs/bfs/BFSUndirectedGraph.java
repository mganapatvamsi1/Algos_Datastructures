package graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSUndirectedGraph {
    private int V,E;
    LinkedList<Integer>[] adj;

    public BFSUndirectedGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) adj[i] = new LinkedList<>();
    }
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, "+E+" edges "+"\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) sb.append(w + " ");
            sb.append("\n");
        }
        return sb.toString();
    }
    public void bFS(int value) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[value] = true;
        queue.offer(value);
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            System.out.print(u + " ");
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        BFSUndirectedGraph bfsUndirectedGraph = new BFSUndirectedGraph(5);
        bfsUndirectedGraph.addEdge(0,1);
        bfsUndirectedGraph.addEdge(1,2);
        bfsUndirectedGraph.addEdge(2,3);
        bfsUndirectedGraph.addEdge(3,0);
        bfsUndirectedGraph.bFS(0);
    }

}
