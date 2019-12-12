package search;

/**
 * Time Complexity of Binary Search is O(log N) and space complexity is O(1)
 */
public class BinarySearch {

    public int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Invalid Input");
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low)/2;
            if (arr[mid] == key) return mid;
            if (key < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] sampleArr = {11,12,13,14,15,16,17,18,19,20,21};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(sampleArr,19));
        System.out.println(binarySearch.search(sampleArr,22));
    }

}
