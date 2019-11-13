package Algorithms_Part1_Princeton.QuickFind.greedy_method;

import java.util.ArrayList;
import java.util.Arrays;

public class ListMultiply {
    public static void main(String[] args) {
        ArrayList<String> firstList = new ArrayList<>(Arrays.asList("1", "2"));
        ArrayList<String> secondList = new ArrayList<>(Arrays.asList("1"));
        ArrayList<String> thirdList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        ArrayList<String> fourthList = new ArrayList<>(Arrays.asList("1", "2", "3"));
        ArrayList<String> fifthList = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        firstList.addAll(secondList);
        System.out.println(firstList);
        firstList.addAll(fourthList);
        System.out.println(firstList);
        thirdList.addAll(fifthList);
        System.out.println(thirdList);
        firstList.addAll(thirdList);
        System.out.println(firstList);

    }

}
