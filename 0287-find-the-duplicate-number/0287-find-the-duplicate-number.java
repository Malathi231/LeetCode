class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int ci = nums[i] - 1;

                if (nums[i] != nums[ci]) {
                    int temp = nums[i];
                    nums[i] = nums[ci];
                    nums[ci] = temp;
                } else {
                    return nums[i]; // duplicate found
                }
            } else {
                i++;
            }
        }

        return -1; // should never happen
    }
}