package Algorithms_Part1_Princeton.QuickFind.sort_algorithms;

import java.util.Arrays;
import java.util.List;

public class MergeSort {


    public static void msort(int[] one, int[] two, int sizeOne, int sizeTwo) {
        int i =1;
        int j = 1;
        int k = 1;
        int size1 = 4;
        int size2 = 4;
        int[] three = new int[size1 + size2];
        while(i <= size1 && j <= size2) {
            if (one[i] < two[j])
                three[k++] = one[i++];
            else
                three[k++ ] = two[j++];
        }
        for (; i <=size1 ; i++) {
            three[k++] = one[i];
            break;
        }
        for (; j <= size2 ; j++) {
            three[k++] = two[j];
            break;
         }



    }

    public static void main(String[] args) {
        int[] first = {2,8,15,18};
        int[] second = {5,9,12,17};
        int[] third = {2,5,8,9,12,15,17,18};
        msort(first,second,4,4);
    }
}
