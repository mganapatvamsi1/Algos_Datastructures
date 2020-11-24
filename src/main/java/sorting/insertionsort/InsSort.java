package sorting.insertionsort;

public class InsSort {
    public static void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {5, 2, 4, 6, 1, 3};
        int[] array2 = {9, 14, 3, 2, 43, 11, 58, 22};
        System.out.print("Before Insertion Sort: ");
        for (int i : array2) {
            System.out.print(i + " ");
        }
        System.out.println();
        insertionSort(array2); // sorting array using insertion sort.
        System.out.print("After Insertion Sort: ");
        for (int i : array2) {
            System.out.print(i + " ");
        }
    }
}
