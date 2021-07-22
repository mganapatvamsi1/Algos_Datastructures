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
            int mid = (high + low) / 2;
            if (arr[mid] == key) return mid;
            if (key < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    /* 1.Given a sorted array of integers and an integer called target,
       find the element that equals the target and return its index. */
    public int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Invalid Input");
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) return mid;
            else if (target < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    /* 2.
    Problem statement #
    An array of boolean values is divided into two sections:
    the left section consists of all false, and the right section consists of all true.
    Find the boundary of the right section, i.e. the index of the first true element.
    If there is no true element, return -1 i.e, Finding the boundary of a boolean array.
    Input: arr = [false, false, true, true, true]
    Output: 2
    Explanation: first true's index is 2. */
    public int findBoundary1(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) return i; // arr[i] == true
        }
        return -1;
    }

    public int findBoundary2(boolean[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid]) {
                boundaryIndex = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return boundaryIndex;
    }

    /* 3.
    Problem statement #
    Given an array of integers sorted in increasing order and a target, find the
    index of the first element in the array that is larger or equal to the target.
    Assume that it is guaranteed to find a satisfying number.
    Example #
    Input: arr = [1, 3, 3, 5, 8, 8, 10],target = 2
    Output: 1    */
    public static int first_not_smaller(int[] arr, int target) {
        // approach-1
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] >= target) return i;
//        }
        // approach-2 (Using Binary Search)
        int low = 0;
        int high = arr.length - 1;
        int boundaryCondition = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                boundaryCondition = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return boundaryCondition;
    }

    /* 4. First Occurrence
    Given a sorted array of integers and a target integer, find the first occurrence of the target and return its index.
    Return -1 if the target is not in the array.
    Example # Input:arr = [1, 3, 3, 3, 3, 6, 10, 10, 10, 100],target = 3
    Output:1   Explanation: The first occurrence of 3 is at index 1.   */
    public static int find_first_occurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int boundaryCondition = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                boundaryCondition = mid;
                high = mid - 1;
            }
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return boundaryCondition;
    }

    /* 5. Square Root
    Given an integer, find its square root without using the built-in square root function. Only return the integer part (truncate the decimals).
    Example #
    Input: 16
    Output: 4
    Input: 8
    Output: 2  (Explanation: Square root of 8 is 2.83..., return integer part 2).   */
    public static int square_root(int n) {


        return -1;
    }


    public static void main(String[] args) {
        int[] sampleArr = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(sampleArr, 19));
        System.out.println(binarySearch.search(sampleArr, 22));
        int[] sampleArr2 = {2, 8, 89, 120, 1000};
        System.out.println(binarySearch.binarySearch(sampleArr2, 120));


    }

}
