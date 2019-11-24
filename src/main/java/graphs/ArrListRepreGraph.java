package graphs;

import java.util.LinkedList;

public class ArrListRepreGraph {
    private int V;
    private int E;
    LinkedList<Integer>[] adj;

    public ArrListRepreGraph(int nodes) {
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
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) sb.append(w + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrListRepreGraph listGraph = new ArrListRepreGraph(4);
        listGraph.addEdge(0,1);
        listGraph.addEdge(1,2);
        listGraph.addEdge(2,3);
        listGraph.addEdge(3,0);
        System.out.println(listGraph);
    }

}
