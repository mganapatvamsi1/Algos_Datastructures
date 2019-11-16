package heap;

public class MaxHeapPriorityQueue {
    Integer[] heap;
    int n; // size of max heap

    public MaxHeapPriorityQueue(int capacity) {
        heap = new Integer[capacity + 1]; // index 0 is kept as empty
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(int x) {
        if (n == heap.length - 1) resize(2*heap.length);
        n++;
        heap[n] = x;
        swim(n);
    }

    private void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for (int i = 0; i < heap.length; i++) temp[i] = heap[i];
        heap = temp;
    }

    public void printMaxHeap() {
        for (int i = 1; i <= n; i++) System.out.print(heap[i] + " ");
    }

    private void swim(int k) {
        while (k > 1 && heap[k/2] < heap[k]) {
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2; // Because we need to continue shiftin new value inserted is at correct
        }
    }

    public static void main(String[] args) {
        MaxHeapPriorityQueue maxHeapPriorityQueue = new MaxHeapPriorityQueue(3);
     // System.out.println(maxHeapPriorityQueue.isEmpty());
        maxHeapPriorityQueue.insert(4);
        maxHeapPriorityQueue.insert(5);
        maxHeapPriorityQueue.insert(0);
        maxHeapPriorityQueue.insert(2);
        maxHeapPriorityQueue.insert(6);
        maxHeapPriorityQueue.insert(1);
        maxHeapPriorityQueue.insert(3);
        System.out.println(maxHeapPriorityQueue.size());
        maxHeapPriorityQueue.printMaxHeap();
    }

}
