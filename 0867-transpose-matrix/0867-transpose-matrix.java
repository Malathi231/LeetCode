class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;      // rows
        int m = matrix[0].length;   // columns

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = matrix[j][i];
            }
        }

        return ans;
    }
}