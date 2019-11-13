package Algorithms_Part1_Princeton.QuickFind.Unit1_PracticeQuiz_Solutions;

/**
 * WeightedQuickUnionUF: Using QuickUnion datastructure with improvements and using path compression model
 * where in we would make the root of the smaller tree point to
 * the root of the larger tree to improve the performance.
 * This is also part of the weighted QuickUnion which has the time complexity of
 * N + MlogN with logN here being very less so time complexity here is linear (N).
 *
 * Social network connectivity. Given a social network containing N members and a log file containing M timestamps at which times pairs of members formed friendships,
 * design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend … of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be MlogN or better and use extra space proportional to N.
 *Solution: This can be easily done by adding a count for number of connected component. Regard N members as N objects, regard M timestamps as M unions.
 * Then “the earliest time at which all members are connected” is the time when the number of connected component is equal to 1.
 *
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] size;
    private int count; // number of connected components

    public WeightedQuickUnionUF(int integerNumber) {
        count = integerNumber;
        id = new int[integerNumber];
        size = new int[integerNumber];
        for (int i = 0; i< integerNumber; i++) {
            id[i] = i;
            size[i] = i;
        }

    }

    public int count() {
        return count;
    }

    private int root(int i) {
        while (i != id[i]) {
            // to keep the tree flat as part of the path compression
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int firstRoot = root(p);
        int secondRoot = root(q);
        if (firstRoot == secondRoot) return;
        if (size[firstRoot] < size[secondRoot]) {
            id[firstRoot] = secondRoot;
            size[secondRoot] += size[firstRoot];
        } else {
            id[secondRoot] = firstRoot;
            size[firstRoot] += size[secondRoot];
        }

    }

    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
        StdOut.println(uf.count == 10);
        uf.union(0, 1);
        StdOut.println(uf.count == 9);
        uf.union(2, 3);
        StdOut.println(uf.count == 8);
        uf.union(0, 2);
        StdOut.println(uf.count == 7);
        uf.union(1, 3);
        StdOut.println(uf.count == 7);

    }


}

// when opening a new site in the percolation simulation, union() is called
// for each neighboring site that is already open. There are 4 possible neighbors,
// but for some of them may not already be open. (0,1,2,3,4)
