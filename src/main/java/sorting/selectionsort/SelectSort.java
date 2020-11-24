package sorting.selectionsort;

public class SelectSort {

    public static void selectionSorting(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j; // searching for lowest index.
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

    public static void main(String[] args) {
        int[] testArray = {9,14,3,2,43,11,58,22};
        System.out.print("Before Selection Sort: ");
        for (int i: testArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        selectionSorting(testArray); //sorting array using selection sort.
        System.out.print("After Applying Selection Sort: ");
        for (int i: testArray) {
            System.out.print(i + " ");
        }
    }
}
