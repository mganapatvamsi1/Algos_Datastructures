package Algorithms_Part1_Princeton.QuickFind.Unit1_PracticeQuiz_Solutions;

/**
 *  Union-find with specific canonical element.
 *   Add a method find() to the union-find data type so that find(i)
 *   returns the largest element in the connected component containing i.
 *   The operations, union(), connected(), and find() should all take logarithmic time or better.
 *
 *   For example, if one of the connected components is {1,2,6,9},
 *   then the find() method should return 9 for each of the four elements in the connected components.
 *
 */
public class UFWithFindLargest {
    private int[] id; // id[i] ==> parent of node i
    private int[] size; // size[i] --> size of node i
    private int[] large; // large[i] --> largest element in the component

    public UFWithFindLargest(int integerNumber) {
        id = new int[integerNumber];
        size = new int[integerNumber];
        large = new int[integerNumber];
        for (int i = 0; i < integerNumber; i++) {
            id[i] = i;
            size[i] = i;
            large[i] = i;
        }
    }

    private int root(int number) {
        while (number != id[number]) {
            id[number] = id[id[number]]; // path compression
            number = id[number];
        }
        return number;
    }

    // return the largest element in the connected component containing 'number'
    public int find(int num) {
        return large[root(num)];

    }

    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    public void union(int c, int d) {
        int firstRoot = root(c);
        int secondRoot = root(d);
        if (firstRoot == secondRoot) return;
        int cLarge = large[firstRoot];
        int dLarge = large[secondRoot];
        if (size[firstRoot] < size[secondRoot]) {
            id[firstRoot] = secondRoot;
            size[secondRoot] += size[firstRoot];
            if (cLarge > dLarge)
                large[secondRoot] = cLarge;
        } else {
            id[secondRoot] = firstRoot;
            size[firstRoot] += size[secondRoot];
            if (dLarge > cLarge)
               large[firstRoot] = dLarge;
        }
    }
    public static void main(String[] args) {
        UFWithFindLargest ufWithFindLargest = new UFWithFindLargest(10);
        ufWithFindLargest.union(0, 2);
        ufWithFindLargest.union(8, 4);
        StdOut.println(ufWithFindLargest.find(0) == 2);
        StdOut.println(ufWithFindLargest.find(4) == 8);
        ufWithFindLargest.union(0, 4);
        StdOut.println(ufWithFindLargest.find(0) == 8);
        StdOut.println(ufWithFindLargest.find(2) == 8);
        ufWithFindLargest.union(0, 6);
        StdOut.println(ufWithFindLargest.find(6) == 8);
        ufWithFindLargest.union(1, 9);
        ufWithFindLargest.union(1, 2);
        StdOut.println(ufWithFindLargest.find(4) == 9);
    }

}
