class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length,maxCount=0;
        int s=0,e=0,zeroCount=0;
        for(s=0;s<n;s++){
            if(nums[s]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[e]==0){
                    zeroCount--;
                }
                e++;
            }
            maxCount=Math.max(maxCount,s-e+1);
        }
        return maxCount;
    }
}