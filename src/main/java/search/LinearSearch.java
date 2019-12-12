package search;

/**
 * Time Complexity of Linear Search is O(N) and space complexity is O(1)
 */
public class LinearSearch {

    public int search(int[] arr, int n, int value) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Invalid Input");
        for (int i = 0; i < n; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] testArr = {5,6,7,8,9,10};
        LinearSearch linearSearch = new LinearSearch();
        System.out.println(linearSearch.search(testArr,testArr.length,9));
        System.out.println(linearSearch.search(testArr,testArr.length,90));
    }

}
