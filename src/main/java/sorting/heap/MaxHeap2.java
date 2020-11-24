package sorting.heap;

import java.util.NoSuchElementException;

public class MaxHeap2 {
    private int[] heapElements;
    private int size;
    private int maximumCapacity;

    public MaxHeap2(int size) {
        this.maximumCapacity = size;
        this.size = 0;
        heapElements = new int[maximumCapacity];
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int leftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    //TODO: have doubt with this logic
    private boolean hasLeaf(int indexPosition) {
        if (rightChildIndex(indexPosition) >= maximumCapacity ||
                leftChildIndex(indexPosition) >= maximumCapacity) {
            return true;
        }
        return false;
    }

    private void swap(int firstElement, int secondElement) {
        int temp = heapElements[firstElement];
        heapElements[firstElement] = heapElements[secondElement];
        heapElements[secondElement] = temp;
    }

    private void insert(int element) {
        if (size >= maximumCapacity) {
            return;
        }
        heapElements[size] = element;
        int current = size;

        while (heapElements[current] > heapElements[getParentIndex(current)]) {
            swap(current, getParentIndex(current));
            current = getParentIndex(current);
        }
        size++;
    }

    // removes and returns the minimum element from the sorting.heap
    public int remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        // since its max sorting.heap will be at root value
        int poppedValue = heapElements[0];
        heapElements[0] = heapElements[--size];
        //size--;
        maxHeapify(0);
        return poppedValue;
    }

    // heapify the node at i
    private void maxHeapify(int i) {
        if (!hasLeaf(i)) {
            if (heapElements[i] < heapElements[leftChildIndex(i)] ||
                    heapElements[i] < heapElements[rightChildIndex(i)]) {
                if (heapElements[leftChildIndex(i)] > heapElements[rightChildIndex(i)]) {
                    swap(i, leftChildIndex(i));
                    maxHeapify(leftChildIndex(i));
                } else {
                    // right child value is greater than the left one
                    swap(i, rightChildIndex(i));
                    maxHeapify(rightChildIndex(i));
                }
            }
        }
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return heapElements[0];
    }

    private void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heapElements[i] +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap2 maxHeap2 = new MaxHeap2(7);
        maxHeap2.insert(30);
        maxHeap2.insert(33);
        maxHeap2.insert(37);
        maxHeap2.insert(36);
        maxHeap2.insert(41);
        maxHeap2.insert(42);
        maxHeap2.insert(49);
        maxHeap2.printHeap();
        maxHeap2.remove();
        maxHeap2.printHeap();
        maxHeap2.remove();  //TODO: its breaking here as after this step result is coming as (41 37 41 30 36)
        maxHeap2.printHeap();
    }


}
