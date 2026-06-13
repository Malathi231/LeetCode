class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer>ans=new ArrayList();
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

        

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                ans.add(i+1);
            }
        }

        return ans;
        
  
    }
}