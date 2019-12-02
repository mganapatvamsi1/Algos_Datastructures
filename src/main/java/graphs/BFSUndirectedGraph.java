package graphs;

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
    public void breadthFirstSearch(int value) {
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
        BFSUndirectedGraph bfs = new BFSUndirectedGraph(5);
        bfs.addEdge(0,1);
        bfs.addEdge(1,2);
        bfs.addEdge(2,3);
        bfs.addEdge(3,0);
        bfs.breadthFirstSearch(0);
        //System.out.println(bfs);
    }
}
