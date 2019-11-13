package arrays;

public class MinValue {

    public static int findMinimum(int[] value) {
        if (value == null || value.length == 0) throw new IllegalArgumentException("Invalid Input");
        int min = value[0];
        for (int i = 1; i < value.length; i++) {
            if (value[i] < min) min = value[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] minimumValue = {1, 2, 3, 4, 0, 5, 6, 7, 8};
        System.out.println(findMinimum(minimumValue));
    }

}
