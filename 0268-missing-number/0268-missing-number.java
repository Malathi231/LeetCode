class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int ci = nums[i];

            if (nums[i] < n && nums[i] != nums[ci]) {
                int temp = nums[i];
                nums[i] = nums[ci];
                nums[ci] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return n;
    }
}