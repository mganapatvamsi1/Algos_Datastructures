package sorting.quicksort;

import java.awt.*;

// doubt ---> need to confirm this
public class Quicksort {

    public static int getPartition(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        // index of smaller element
        int i = (startIndex - 1);
        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[endIndex];
        array[endIndex] = temp;

        return (i + 1);
    }

    public static void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitioningIndex = getPartition(array, startIndex, endIndex);

            // recursively sort elements before partitioning
            sort(array, startIndex, partitioningIndex - 1);

            //recursively sort elements after partitioning
            sort(array, partitioningIndex + 1, endIndex);
        }

    }

    public static void printArray(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] testArray = {10, 7, 8, 9, 1, 5};

        Quicksort quicksort = new Quicksort();
        quicksort.sort(testArray, 0 , testArray.length - 1);
        System.out.print("Sorted Array: ");
        printArray(testArray);
    }
}
