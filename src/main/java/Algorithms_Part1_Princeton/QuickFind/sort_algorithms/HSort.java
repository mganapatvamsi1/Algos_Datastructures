package Algorithms_Part1_Princeton.QuickFind.sort_algorithms;

import java.util.Arrays;

public class HSort {
    private int capacity = 10;
    private int size = 0;

    int[] itemArr = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    private int getParentIndex(int childIndex) {
        return (childIndex - 1)/2;
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
        return itemArr[getLeftChildIndex(index)];
    }
    private int rightChild(int index) {
        return itemArr[getRightChildIndex(index)];
    }
    private int parent(int index) {
        return itemArr[getParentIndex(index)];
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = itemArr[firstIndex];
        itemArr[firstIndex] = itemArr[secondIndex];
        itemArr[secondIndex] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            itemArr = Arrays.copyOf(itemArr,capacity*2);
            capacity *= 2;
        }
    }

    public int peak() {
        if (size == 0) throw new IllegalStateException();
        return itemArr[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = itemArr[0];
        itemArr[0] = itemArr[size - 1];
        size --;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        itemArr[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > itemArr[index]) {
            // this means the elements are out of order so we have to swap
            swap(getParentIndex(index),index);
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
            if (itemArr[index] < itemArr[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }

    }


}
