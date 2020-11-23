package heap;

public class MinHeap2 {
    private int[] heapElements;
    private int size;
    private int maximumCapacity;

    public MinHeap2(int s) {
        this.maximumCapacity = s;
        this.size = 0;
        heapElements = new int[maximumCapacity];
    }

    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }
    private int leftChildIndex(int parentIndex) { return (parentIndex * 2) + 1; }
    private int rightChildIndex(int parentIndex) { return (parentIndex * 2) + 2; }

    //TODO: have doubt with this logic
    private boolean hasLeaf(int indexPosition) {
        if (rightChildIndex(indexPosition) >= maximumCapacity || leftChildIndex(indexPosition) >= maximumCapacity) {
            return true;
        }
        return false;
        //short form: return rightChildIndex(index) >= size || leftChildIndex(index) >= size;
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

        while (heapElements[current] < heapElements[getParentIndex(current)]) {
            swap(current, getParentIndex(current));
            current = getParentIndex(current);
        }
        size++;
    }

    // removes and returns the minimum element from the heap
    public int remove() {
        // since its min heap so root == minimum
        int poppedValue = heapElements[0];
        heapElements[0] = heapElements[--size];
        minHeapify(0);
        return poppedValue;
    }

    // heapify the node at i
    private void minHeapify(int i) {
        if (!hasLeaf(i)) {
            if (heapElements[i] > heapElements[leftChildIndex(i)] ||
                    heapElements[i] > heapElements[rightChildIndex(i)]) {
                if (heapElements[leftChildIndex(i)] < heapElements[rightChildIndex(i)]) {
                    swap(i, leftChildIndex(i));
                    minHeapify(leftChildIndex(i));
                } else {
                    // right child value is lesser than left child value
                    swap(i, rightChildIndex(i));
                    minHeapify(rightChildIndex(i));
                }
            }
        }
    }

    // builds the min-heap using the minHeapify
    public void minHeap() {
        for (int i = ((size - 1) / 2); i >= 1; i--) {
            minHeapify(i);
        }
    }

    // prints the contents of the heap
    public void printHeap() {
        for (int i = 0; i < (size / 2); i++) {
            System.out.print("Parent : " + heapElements[i] + " ");
            if (leftChildIndex(i) < size) {
                System.out.print("Left Child :  " + heapElements[leftChildIndex(i)] + " ");
            }
            if (rightChildIndex(i) < size) {
                System.out.print("Right Child : " + heapElements[rightChildIndex(i)]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinHeap2 minHeap2 = new MinHeap2(7);
        minHeap2.insert(30);
        minHeap2.insert(13);
        minHeap2.insert(7);
        minHeap2.insert(9);
        minHeap2.insert(11);
        minHeap2.insert(5);
        minHeap2.insert(2);
        minHeap2.minHeap();
        minHeap2.printHeap();
        System.out.println("The min value is : " + minHeap2.remove());
    }
}











