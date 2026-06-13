class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int ci = nums[i] - 1;

            if (nums[i] != nums[ci]) {
                int temp = nums[i];
                nums[i] = nums[ci];
                nums[ci] = temp;
            } else {
                i++;
            }
        }

        int[] ans = new int[2];

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                ans[0] = nums[i]; // duplicate
                ans[1] = i + 1;   // missing
                return ans;
            }
        }

        return ans;
    }
}