package Algorithms_Part1_Princeton.QuickFind.Unit1_PracticeQuiz_Solutions;

/**
 * Successor with delete. Given a set of N integers S={0,1,…,N−1} and a sequence of requests of the
 * following form: Remove x from S
 * Find the successor of x: the smallest y in S such that y ≥ x.
 * design a data type so that all operations (except construction) should take logarithmic time or better.
 *
 * Solution: I know it’s hard to believe this one can be solved by Union-Find.
 * But take a look at the time constraint, and think about how you can use union-find here,
 * you will soon figure out the UFWithFindLargest we created for Question 2 is super helpful.
 * When a number is removed, union the immediate neighbor if it is also removed. Then the largest
 * successor is equal to the largest number in that component plus 1.
 *
 */
public class SuccessorWithDelete {
    private boolean[] data; // data[i] == false if removed
    private UFWithFindLargest uf; // used to find largest unremoved element
    private int number; // number integers in S

    public SuccessorWithDelete(int integerNumber) {
        this.number = integerNumber;
        data = new boolean[integerNumber];
        for (int i = 0; i < integerNumber; i++)
            data[i] = true;
        uf = new UFWithFindLargest(integerNumber);
    }

    public void remove(int n) {
        data[n] = false;
        if (n > 0 && !data[n-1])
            uf.union(n,n-1);
        if (n < number && !data[n+1])
            uf.union(n,n+1);
    }

    public int successor(int a) {
        if (data[a])
            return a;
        else {
            int result = uf.find(a) + 1;
            if (result >= number) {
                StdOut.println("Error, no successor can be found");
                return -1;
            } else
                return result;
        }
    }


    public static void main(String[] args) {
        SuccessorWithDelete successorWithDelete = new SuccessorWithDelete(11);
        successorWithDelete.remove(2);
        StdOut.println(successorWithDelete.successor(2) == 3);
        successorWithDelete.remove(3);
        StdOut.println(successorWithDelete.successor(3) == 4);
        StdOut.println(successorWithDelete.successor(8) == 8);
        successorWithDelete.remove(8);
        StdOut.println(successorWithDelete.successor(8) == 9);
        successorWithDelete.remove(9);
        StdOut.println(successorWithDelete.successor(8) == -1);
        successorWithDelete.remove(4);
        successorWithDelete.remove(5);
        StdOut.println(successorWithDelete.successor(3) == 6);
    }



}
