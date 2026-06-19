import java.util.*;

class Solution {

    public int[] nearestSmallerLeft(int[] heights) {

        int n = heights.length;
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                left[i] = -1;
            else
                left[i] = st.peek();

            st.push(i);
        }

        return left;
    }

    public int[] nearestSmallerRight(int[] heights) {

        int n = heights.length;
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                right[i] = n;
            else
                right[i] = st.peek();

            st.push(i);
        }

        return right;
    }

    public int largestRectangleArea(int[] heights) {

        int[] left = nearestSmallerLeft(heights);
        int[] right = nearestSmallerRight(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}