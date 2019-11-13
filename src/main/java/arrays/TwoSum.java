package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int[] finalResult = new int[2];
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!resultMap.containsKey(target - numbers[i])) resultMap.put(numbers[i],i);
            else {
                finalResult[1] = i;
                finalResult[0] = resultMap.get(target - numbers[i]);
                //System.out.println("These are the indexes of final result{}: " + finalResult);
                return finalResult;
            }
        }
        throw new IllegalArgumentException("Two numbers not found");
    }

    public static void main(String[] args) {
        int[] numbers = {2, 11, 5, 10, 7, 8};
        int[] testingResult = twoSum(numbers, 9);
        System.out.println("The two indices are{}" + testingResult[0] + " and " + testingResult[1]);
    }
}
