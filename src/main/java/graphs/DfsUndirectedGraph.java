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

    public void depthFirstSearch(int value) {
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
        DfsUndirectedGraph dfs = new DfsUndirectedGraph(5);
        dfs.addEdge(0,1);
        dfs.addEdge(1,2);
        dfs.addEdge(2,3);
        dfs.addEdge(3,0);
        dfs.addEdge(2,4);
        dfs.depthFirstSearch(0);
    }

}
