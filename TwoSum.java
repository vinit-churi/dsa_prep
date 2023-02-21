import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1 };
        int target = 11;
        System.out.println(Arrays.toString(hashTwoSum(nums, target)));
    }

    static int[] hashTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (numbers.get(nums[i]) == null) {
                numbers.put(nums[i], i);
            }
            if (numbers.get(target - nums[i + 1]) != null) {
                return new int[] { numbers.get(target - nums[i + 1]), (i + 1) };
            }
        }
        return new int[] { 0, 1 };
    }
}
