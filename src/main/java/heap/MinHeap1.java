package heap;

import java.util.Arrays;

public class MinHeap1 {
    private int capacity = 10;
    private int size = 0;

    int[] elements = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 + parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return elements[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return elements[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return elements[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = elements[indexOne];
        elements[indexOne] = elements[indexTwo];
        elements[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            elements = Arrays.copyOf(elements, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        return elements[0];
    }

    public int poll() {
        if (size == capacity) {
            throw new IllegalStateException("Array is empty");
        }
        int element = elements[0];
        elements[0] = elements[size - 1]; //Take the very last element in the array and move it to the very first.
        size--;
        heapifyDown();
        return element;
    }

    public void add(int element) {
        ensureExtraCapacity();
        elements[size] = element;
        size++;
        heapifyUp();  // swapping each element with its parent as required.
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > elements[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (elements[index] < elements[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }


    public static void main(String[] args) {

    }

}
