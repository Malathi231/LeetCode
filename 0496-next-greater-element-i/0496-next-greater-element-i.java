import java.util.*;

class Solution {

    public int[] nextGreaterRight(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        ans[n - 1] = -1;
        st.push(nums[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();

            st.push(nums[i]);
        }

        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ngr = nextGreaterRight(nums2);
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    ans[i] = ngr[j];
                    break;
                }
            }
        }

        return ans;
    }
}