package arrays;

public class ReverseArray {

    public static void reverseArray(int[] numbers, int start, int end) {
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] testArray = {10, 20, 30, 40, 50, 60, 70};
        printArray(testArray);
        reverseArray(testArray, 0, testArray.length - 1);
        printArray(testArray);
    }

}
