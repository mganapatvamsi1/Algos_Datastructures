package graphs;

import java.util.LinkedList;
import java.util.Stack;

public class DfsUndirectedGraph {
    private int V,E;
    LinkedList<Integer>[] adj;

    public DfsUndirectedGraph(int nodes) {
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
    public void dFS(int value) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(value);
        while(!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for (int v : adj[u]) {
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        DfsUndirectedGraph dfsUndirectedGraph = new DfsUndirectedGraph(8);
        dfsUndirectedGraph.addEdge(1,2);
        dfsUndirectedGraph.addEdge(1,3);
        dfsUndirectedGraph.addEdge(2,4);
        dfsUndirectedGraph.addEdge(2,5);
        dfsUndirectedGraph.addEdge(3,6);
        dfsUndirectedGraph.addEdge(3,7);
        dfsUndirectedGraph.dFS(1);
    }

}
