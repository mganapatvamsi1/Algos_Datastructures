package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Test {

    List<Integer> criticalRouters(int numRouters, int numLinks, ArrayList<ArrayList<Integer>> links) {
        int n = 3;

        // Here aList is an ArrayList of ArrayLists
        ArrayList<ArrayList<Integer> > aList =
                new ArrayList<ArrayList<Integer> >(n);

        // Create n lists one by one and append to the
        // master list (ArrayList of ArrayList)
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        aList.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(5);
        aList.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(10);
        a3.add(20);
        a3.add(30);
        aList.add(a3);

        for (int i = 0; i < aList.size(); i++) {
            for (int j = 0; j < aList.get(i).size(); j++) {
                System.out.print(aList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        List<Integer> finalList = new ArrayList<>();
        while (!aList.isEmpty())
            finalList.add(n);
        return finalList;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer> > links =
                new ArrayList<ArrayList<Integer> >(3);
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        links.add(a1);
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(1);
        a2.add(3);
        links.add(a2);
        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(2);
        a3.add(4);
        int numRouters = 3;
        int numLinks = 3;
        links.add(a3);
        System.out.println(links);

    }
}
