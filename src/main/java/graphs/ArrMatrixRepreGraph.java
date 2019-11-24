package graphs;

public class ArrMatrixRepreGraph {

    private int V; // no. of vertices in the graph
    private int E; // no. of edges in the graph
    private int[][] adjMatrix;

    public ArrMatrixRepreGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1; // because this is an undirected graph.
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for(int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for(int w : adjMatrix[v]) sb.append(w + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrMatrixRepreGraph matrixGraph = new ArrMatrixRepreGraph(4);
        matrixGraph.addEdge(0,1);
        matrixGraph.addEdge(1,2);
        matrixGraph.addEdge(2,3);
        matrixGraph.addEdge(3,0);
        System.out.println(matrixGraph);
    }

}
