package Algorithms_Part1_Princeton.QuickFind;

/**
 * Using Algorithms_Part1_Princeton.QuickFind Datastructure with time complexity N^2
 */
public class QuickFindImpl {
    private int[] id;

    // Set id of each object to itself (integerNumber array accesses)
    public QuickFindImpl(int integerNumber) {
        id = new int[integerNumber];
        for (int i = 0; i < integerNumber; i++)
            id[i] = i;
    }

    // Check whether the 2 parameter integer arguments passed, p and q in this case are
    // in the same component (2 array accesses)
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // Change all entries with id[p] to id[q] (at most 2N + 2 array accesses)
    public void union(int p, int q) {
        extract(p, q, id);
    }

    public static void extract(int p, int q, int[] id) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid)
                id[i] = qid;
    }


}
