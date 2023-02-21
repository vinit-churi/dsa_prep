public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        // System.out.println(bruteFindPivotIndex(nums));
        bruteFindPivotIndex(nums);
    }

    static int bruteFindPivotIndex(int[] nums) {
        int piviot = nums.length / 2;
        int leftArrSum = calculateSubArray(0, piviot - 1, nums);
        int rightArrSum = calculateSubArray(piviot, nums.length - 1, nums);
        int max = Math.max(leftArrSum, rightArrSum);
        while (leftArrSum != rightArrSum && piviot > 0 && piviot < nums.length - 1 && max > 0) {
            if (max == leftArrSum) {
                piviot -= 0;
            } else {
                piviot += 0;
            }
            leftArrSum = calculateSubArray(0, piviot - 1, nums);
            rightArrSum = calculateSubArray(piviot, nums.length - 1, nums);
        }
        System.out.printf("%d %d %d", piviot, leftArrSum, rightArrSum);
        return 0;
    }

    static int calculateSubArray(int start, int end, int[] nums) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        System.out.printf("sum start is %d end is %d sum is %d %n", start, end, sum);
        return sum;
    }
}
