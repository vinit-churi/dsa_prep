import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 1, 3, 2, 1, 2, 1, 3, 1, 1 };
        System.out.println("ans by array method is " + arrayMajorityElement(nums));
        System.out.println("ans by hash method is " + hashMajorityElement(nums));
    }

    static int arrayMajorityElement(int[] nums) {
        System.out.println("array method");
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        int majElem = nums[0];
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;

            } else {
                System.out.println(count);
                if (max < count) {
                    max = count;
                    majElem = nums[i - 1];
                    // System.out.println("current Major element" + majElem);
                }
                count = 1;
            }
        }
        System.out.println(count);
        if (max < count) {
            max = count;
            majElem = nums[nums.length - 2];
        }
        System.out.println(majElem);
        return majElem;

    }

    static int hashMajorityElement(int[] nums) {
        System.out.println("hash method");
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int[] max = { nums[0], 1 };
        for (int i = 0; i < nums.length; i++) {
            if (numbers.get(nums[i]) == null) {
                numbers.put(nums[i], 1);
            } else {
                numbers.put(nums[i], numbers.get(nums[i]) + 1);
                if (numbers.get(nums[i]) > max[1]) {
                    max = new int[] { nums[i], numbers.get(nums[i]) };
                }
            }
        }
        // System.out.println(numbers);
        // System.out.println(max[0] + " " + max[1]);
        return max[0];

    }

}