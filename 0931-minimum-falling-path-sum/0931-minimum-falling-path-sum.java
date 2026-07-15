class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int top = matrix[i - 1][j];

                int topLeft = Integer.MAX_VALUE;
                if (j > 0)
                    topLeft = matrix[i - 1][j - 1];

                int topRight = Integer.MAX_VALUE;
                if (j < n - 1)
                    topRight = matrix[i - 1][j + 1];

                matrix[i][j] += Math.min(top,
                                Math.min(topLeft, topRight));
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, matrix[n - 1][j]);
        }

        return ans;
    }
}