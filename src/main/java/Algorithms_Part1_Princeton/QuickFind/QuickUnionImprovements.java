package Algorithms_Part1_Princeton.QuickFind;

/**
 * Using QuickUnionImpl DataStructure with improvements by always
 * keeping the lower tree below the upper tree which improves the
 * time complexity to N + logN. This is also called as weighted QuickUnion
 */
public class QuickUnionImprovements {
    private int[] id;
    private int[] size;

    public QuickUnionImprovements(int integerNumber) {
        id = new int[integerNumber];
        size = new int[integerNumber];
        for (int i = 0; i < integerNumber; i++)
            id[i] = i;
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

}
