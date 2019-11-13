package Algorithms_Part1_Princeton.QuickFind;

/**
 * Using QuickUnionImpl Datastructure with time complexity N
 */
public class QuickUnionImpl {
    private int[] id;

    // Set id of each object to itself
    public QuickUnionImpl(int integerNumber) {
        id = new int[integerNumber];
        for (int i = 0; i < integerNumber; i++)
            id[i] = i;
    }

    // Chase parent pointers until we reach root (depth of i array accesses)
    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    // Check if p and q have the same root (depth of p and q array accesses)
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // Change root of p to point to root of q (depth of p and q array accesses)
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

}

