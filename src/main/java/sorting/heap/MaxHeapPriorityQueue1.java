package sorting.heap;

public class MaxHeapPriorityQueue1 {
    Integer[] heap;
    int n; // size of max sorting.heap

    public MaxHeapPriorityQueue1(int capacity) {
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
            k = k/2; // Because we need to continue shifting new value inserted is at correct
        }
    }

    public static void main(String[] args) {
        MaxHeapPriorityQueue1 maxHeapPriorityQueue1 = new MaxHeapPriorityQueue1(3);
     // System.out.println(maxHeapPriorityQueue.isEmpty());
        maxHeapPriorityQueue1.insert(4);
        maxHeapPriorityQueue1.insert(5);
        maxHeapPriorityQueue1.insert(0);
        maxHeapPriorityQueue1.insert(2);
        maxHeapPriorityQueue1.insert(6);
        maxHeapPriorityQueue1.insert(1);
        maxHeapPriorityQueue1.insert(3);
        System.out.println(maxHeapPriorityQueue1.size());
        maxHeapPriorityQueue1.printMaxHeap();
    }

}
