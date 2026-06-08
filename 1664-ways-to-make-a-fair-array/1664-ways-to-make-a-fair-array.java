class Solution {
    public int waysToMakeFair(int[] nums) {

        int oddSum = 0, evenSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }

        int leftEven = 0, leftOdd = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i % 2 == 0) {
                evenSum -= nums[i];
            } else {
                oddSum -= nums[i];
            }

            int newEven = leftEven + oddSum;
            int newOdd = leftOdd + evenSum;

            if (newEven == newOdd) {
                count++;
            }

            if (i % 2 == 0) {
                leftEven += nums[i];
            } else {
                leftOdd += nums[i];
            }
        }

        return count;
    }
}