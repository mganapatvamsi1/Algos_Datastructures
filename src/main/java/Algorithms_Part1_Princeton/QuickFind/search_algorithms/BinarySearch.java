package Algorithms_Part1_Princeton.QuickFind.search_algorithms;

import java.util.Arrays;

public class BinarySearch {


    public static void search(int[] sorted, int low, int high,int key) {
        while (low <= high) {
           int mid = (low + high)/2;
            if (key == sorted[mid]) {
                System.out.println("We have found the element:");
                break;
            } else if (key < sorted[mid])
                high = mid - 1;
            else
                low = mid + 1;
            mid = (low + high)/2;
        }
        if (low > high) {
            System.out.println("We did not find the element in our given array:");
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 10 ,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95};
        int keyValue = 50;
        int high = array.length - 1;
        search(array,0,high,keyValue);
    }



}
