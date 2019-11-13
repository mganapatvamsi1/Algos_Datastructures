package Algorithms_Part1_Princeton.QuickFind.sort_algorithms;

public class HeapSort {

    public void sort(int[] array) {
        int n = array.length;

        for (int i = n/2 -1; i >= 0; i--)
            heapify(array,n,i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array,i,0);
        }

    }

    public void heapify(int[] array, int sizeOfHeap, int root) {
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;

        if (leftChild < sizeOfHeap && array[leftChild] > largest)
            largest = leftChild;

        if (rightChild < sizeOfHeap && array[rightChild] > largest)
            largest = rightChild;

        if (largest != root) {
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;
            heapify(array,sizeOfHeap,root);
        }
    }


    public static void main(String[] args) {

    }


}
