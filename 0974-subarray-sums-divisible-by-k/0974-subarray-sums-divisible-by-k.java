class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int[] remainderCount = new int[k];

        // Prefix sum = 0 before starting
        remainderCount[0] = 1;

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            int remainder = prefixSum % k;

            // Handle negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            // Same remainder means subarray sum is divisible by k
            count += remainderCount[remainder];

            // Store the remainder
            remainderCount[remainder]++;
        }

        return count;
    }
}