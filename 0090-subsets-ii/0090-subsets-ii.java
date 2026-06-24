class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        backtrack(0, nums, new ArrayList<>());

        return ans;
    }

    void backtrack(int start, int[] nums, List<Integer> temp) {

        ans.add(new ArrayList<>(temp));

        for(int i=start;i<nums.length;i++){

            if(i>start && nums[i]==nums[i-1])
                continue;

            temp.add(nums[i]);

            backtrack(i+1, nums, temp);

            temp.remove(temp.size()-1);
        }
    }
}