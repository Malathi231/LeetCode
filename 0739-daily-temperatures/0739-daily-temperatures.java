class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return ans;
    }
}

// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
//         int[] ans = new int[n];

//         for (int i = 0; i < n; i++) {

//             for (int j = i + 1; j < n; j++) {

//                 if (temperatures[j] > temperatures[i]) {
//                     ans[i] = j - i;
//                     break;
//                 }

//             }
//         }

//         return ans;
//     }
// }