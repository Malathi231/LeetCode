class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, new ArrayList<>());

        return ans;
    }

    void backtrack(int[] nums, boolean[] visited, List<Integer> temp) {

        // Base case
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip if already used
            if (visited[i])
                continue;

            // Choose
            visited[i] = true;
            temp.add(nums[i]);

            // Explore
            backtrack(nums, visited, temp);

            // Undo
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}