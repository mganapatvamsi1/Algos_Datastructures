package sorting.mergesort;

import org.apache.coyote.http11.filters.IdentityOutputFilter;

public class MergeSortRecursive {

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // middle element
        int middle = (left + right) / 2;

        //sort the left half array
        sort(array, left, middle);

        //sort the right half array
        sort(array, (middle + 1), right);

        // merge these 2 halves
        mergeSort(array, left, middle, right);
    }

    public static void mergeSort(int[] array, int left, int middle, int right) {
        // finding the sizes of the sub-arrays that have to be merged
        int sizeOfLeftArray = middle - left + 1;
        int sizeOfRightArray = right - middle;

        // create tmp arrays
        int[] leftTmp = new int[sizeOfLeftArray];
        int[] rightTmp = new int[sizeOfRightArray];

        // copying data to tmp arrays
        for (int i = 0; i < sizeOfLeftArray; ++i) {
            leftTmp[i] = array[left + i];
        }
        for (int j = 0; j < sizeOfRightArray; ++j) {
            rightTmp[j] = array[middle + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < sizeOfLeftArray && j < sizeOfRightArray) {
            if (leftTmp[i] <= rightTmp[j]) {
                array[k] = leftTmp[i];
                i++;
            } else {
                array[k] = rightTmp[j];
                j++;
            }
            k++;
        }

        while (i < sizeOfLeftArray) {
            array[k] = leftTmp[i];
            i++;
            k++;
        }
        while (j < sizeOfRightArray) {
            array[k] = rightTmp[j];
            j++;
            k++;
        }

    }

    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] testArray = {12, 13, 11, 5, 7, 6, 15, 2};
        System.out.println("Given Array: ");
        printArray(testArray);

        MergeSortRecursive mergeSortRecursive = new MergeSortRecursive();
        mergeSortRecursive.sort(testArray, 0, (testArray.length - 1));

        System.out.println("\n Sorted Array");
        printArray(testArray);
    }
}
