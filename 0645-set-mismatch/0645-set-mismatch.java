import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {

        Arrays.sort(nums);

        int duplicate = -1;
        int missing = -1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                duplicate = nums[i];
            }

            if (nums[i] - nums[i - 1] > 1) {
                missing = nums[i - 1] + 1;
            }
        }

        // Edge cases
        if (missing == -1) {
            if (nums[0] != 1) {
                missing = 1;
            } else {
                missing = nums.length;
            }
        }

        return new int[]{duplicate, missing};
    }
}